package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Owen Miner - osminer
 * CIS175 - Spring 2022
 * Feb 23, 2022
 */
@Entity
public class PlaylistManager {
	@Id
	@GeneratedValue
	private int id;
	private String playlistName;
	private String creator;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Song> playlist;
	
	public PlaylistManager() {
		super();
	}
	public PlaylistManager(int id, String playlistName, String creator, List<Song> playlist) {
		super();
		this.id = id;
		this.playlistName = playlistName;
		this.playlist = playlist;
		this.creator = creator;
	}
	public PlaylistManager(String playlistName, String creator, List<Song> playlist) {
		super();
		this.playlistName = playlistName;
		this.playlist = playlist;
		this.creator = creator;
	}
	public PlaylistManager(String playlistName, String creator) {
		super();
		this.playlistName = playlistName;
		this.creator = creator;
	}
	public PlaylistManager(String playlistName) {
		super();
		this.playlistName = playlistName;
	}
	/**
	 * @return the playlistName
	 */
	public String getPlaylistName() {
		return playlistName;
	}
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
	 * @param playlistName the playlistName to set
	 */
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return the playlist
	 */
	public List<Song> getPlaylist() {
		return playlist;
	}
	/**
	 * @param playlist the playlist to set
	 */
	public void setPlaylist(List<Song> playlist) {
		this.playlist = playlist;
	}
	@Override
	public String toString() {
		return "PlaylistManager [playlistName=" + playlistName + ", creator=" + creator + ", playlist=" + playlist
				+ "]";
	}
	
	
	
}
