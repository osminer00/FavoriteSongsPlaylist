package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PlaylistManager;

/**
 * @author Owen Miner - osminer
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */
public class PlaylistManagerEditor {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FavoriteSongs");
	
	public List<PlaylistManager> getPlaylists(){
		EntityManager e = emfactory.createEntityManager();
		List<PlaylistManager> playlists = e.createQuery("Select p FROM PlaylistManager p").getResultList();
		return playlists;
		
	}
	
	public void addNewPlaylist(PlaylistManager pm) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		e.persist(pm);
		e.getTransaction().commit();
		e.close();
	}
	
	public PlaylistManager findId(Integer id) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		PlaylistManager pm = e.find(PlaylistManager.class, id);
		e.close();
		return pm;
	}
	
	public void removePlaylist(PlaylistManager pm) {
		EntityManager e = emfactory.createEntityManager();
		e.getTransaction().begin();
		TypedQuery<PlaylistManager> tq = e.createQuery("SELECT p FROM PlaylistManager p where p.id = :i", PlaylistManager.class);
		
		tq.setParameter("i", pm.getId());
		tq.setMaxResults(1);
		
		PlaylistManager deletePm = tq.getSingleResult();
		
		e.remove(deletePm);
		
		e.getTransaction().commit();
		
	}
}
