package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Song;

/**
 * @author Owen Miner - osminer
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */
public class SongController {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FavoriteSongs");
	
	public void insertSong(Song s) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		e.persist(s);
		e.getTransaction().commit();
		e.close();
	}
	
	public void removeSong(Song removeS) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Song> tq = e.createQuery("select s from Song s where s.song = :selectedSong and s.artist = :selectedArtist and s.genre = :selectedGenre", Song.class);
		
		tq.setParameter("selectedSong", removeS.getSong());
		tq.setParameter("selectedArtist", removeS.getArtist());
		tq.setParameter("selectedGenre", removeS.getGenre());
		tq.setMaxResults(1);
		Song toRemove = tq.getSingleResult();
		e.remove(toRemove);
		e.getTransaction().commit();
		e.close();
	}
	
	public void endProgram() {
		emfactory.close();
	}

	/**
	 * @param songName 
	 * @return
	 */
	public List<Song> searchSongbyName(String songName) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Song> tq = e.createQuery("select s from Song s where s.song = :selectedSong", Song.class);
		tq.setParameter("selectedSong", songName);
		List<Song> songFound = tq.getResultList();
		return songFound;
	}

	/**
	 * @param id
	 * @return
	 */
	public Song searchSongbyId(int id) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		Song foundSong = e.find(Song.class, id);
		e.close();
		return foundSong;
		
	}

	/**
	 * @param songGenre
	 * @return
	 */
	public List<Song> searchSongbyGenre(String songGenre) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Song> tq = e.createQuery("select s from Song s where s.genre = :selectedGenre", Song.class);
		tq.setParameter("selectedGenre", songGenre);
		List<Song> songFound = tq.getResultList();
		return songFound;
	}

	/**
	 * @param songArtist
	 * @return
	 */
	public List<Song> searchSongbyArtist(String songArtist) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<Song> tq = e.createQuery("select s from Song s where s.artist = :selectedArtist", Song.class);
		tq.setParameter("selectedArtist", songArtist);
		List<Song> songFound = tq.getResultList();
		return songFound;
	}
	
	/**
	 * @param edit
	 */
	public void updateSong(Song edit) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		e.merge(edit);
		e.getTransaction().commit();
		e.close();
	}
	
	public List<Song> displayPlaylist(){
		EntityManager e = emfactory.createEntityManager();
		List<Song> songs = e.createQuery("SELECT s FROM Song s").getResultList();
		return songs;
	}

}
