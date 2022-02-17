package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Database Name - playlist
/**
 * @author Owen Miner - osminer
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */
@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="SONGNAME")
	private String song;
	@Column(name="ARTIST")
	private String artist;
	@Column(name="GENRE")
	private String genre;
	
	public Song() { //default constructor
		super();
	}
	public Song(String song, String artist, String genre) { //non-default constructor
		super();
		this.song = song;
		this.artist = artist;
		this.genre = genre;
	}
	//getters and setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the song
	 */
	public String getSong() {
		return song;
	}
	/**
	 * @param song the song to set
	 */
	public void setSong(String song) {
		this.song = song;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String songInfo() { //string output
		return "Song Name: " + this.song + " Artist: " + this.artist + " Genre: " + this.genre;
	}
	
	
	
}
