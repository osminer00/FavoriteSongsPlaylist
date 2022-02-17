package view;

import java.util.List;
import java.util.Scanner;

import controller.SongController;
import model.Song;

/**
 * @author Owen Miner - osminer
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */
public class FavoriteSongsDriver {

	/**
	 * @param args
	 */
	
	static Scanner input = new Scanner(System.in);
	static SongController sc = new SongController();
	
	private static void addSong() {
		//gathering song name from user
		System.out.println("Enter a song name: ");
		String song = input.nextLine();
		
		//gathering artist name from user
		System.out.println("Enter the artist of the song: ");
		String artist = input.nextLine();
		
		//gathering song genre from user
		System.out.println("Enter the genre of the song: ");
		String genre = input.nextLine();
		
		
		Song newSong = new Song(song, artist, genre); //creating new song object from input
		sc.insertSong(newSong); //inserting song into database controller
	}
	
	private static void deleteSong() {
				//gathering song name to delete from user
				System.out.println("Enter a song name to delete: ");
				String song = input.nextLine();
				
				//gathering artist name to delete from user
				System.out.println("Enter the artist of the song to delete: ");
				String artist = input.nextLine();
				
				//gathering song genre to delete from user
				System.out.println("Enter the genre of the song to delete: ");
				String genre = input.nextLine();
				
				Song removeSong = new Song(song, artist, genre); //new song object
				sc.removeSong(removeSong); //sending song object to remove song method
	}
	
	private static void editSongDetails() {
		System.out.println("Select a Field to Search by: ");
		System.out.println("- 1 : Song Name");
		System.out.println("- 2 : Artist");
		System.out.println("- 3 : Genre");
		System.out.print("---- Select 1-3: ");
		
		int editAction = input.nextInt();
		input.nextLine();
		
		List<Song> foundSong;
		
		if(editAction == 1) {
			System.out.print("Enter the Song Name: ");
			String songName = input.nextLine();
			foundSong = sc.searchSongbyName(songName);
			
		}else if(editAction == 2) {
			System.out.print("Enter the songs Artist: ");
			String songArtist = input.nextLine();
			foundSong = sc.searchSongbyArtist(songArtist);
			
		}else {
			System.out.print("Enter the songs Genre: ");
			String songGenre = input.nextLine();
			foundSong = sc.searchSongbyGenre(songGenre);
		}
		
		if (!foundSong.isEmpty()) {
			for(Song i : foundSong) {
				System.out.println(i.getId() + "  -  " + i.songInfo());
			}
			System.out.print("Select a Song to Edit Based on ID: ");
			int id = input.nextInt();
			
			Song edit = sc.searchSongbyId(id);
			
			System.out.println("Got it! " + edit.getSong() + " by " + edit.getArtist() + " which falls under the genre of " + edit.getGenre());
			System.out.println("Choose a Field to edit: ");
			
			System.out.println("- 1: Song Name");
			System.out.println("- 2: Artist ");
			System.out.println("- 3: Genre");
			
			int editField = input.nextInt();
			input.nextLine();
			
			if(editField == 1) {
				System.out.print("Enter a new Song Name: ");
				String editedName = input.nextLine();
				edit.setSong(editedName);
				
			}else if(editField == 2){
				System.out.print("Enter a new Artist: ");
				String editedArtist = input.nextLine();
				edit.setArtist(editedArtist);
				
			}else if(editField == 3) {
				System.out.print("Enter a new Genre:");
				String editedGenre = input.nextLine();
				edit.setGenre(editedGenre);
			}
			sc.updateSong(edit);
			
			
		}else {
			System.out.print("Nothing matches your input. Try again. ");
		}
		
	}
	private static void showPlaylist() {
		List<Song> playList = sc.displayPlaylist();
		for(Song s : playList) {
			System.out.println(s.songInfo());
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		boolean repeat = true;
		System.out.println("Favorite Songs - A Custom Playlist Manager to Hold all Your Favorite Songs.");
		while(repeat) {
			System.out.println("How would you like to modify your playlist?");
			System.out.println("- 1: Add a New Song to your playlist. ");
			System.out.println("- 2: Delete an Existing Song from your playlist. ");
			System.out.println("- 3: Edit an Existing Song in your playlist. ");
			System.out.println("- 4: Display your playlist.");
			System.out.println("- 5: Exit Your Playlist Manager");
			System.out.print("---- Select 1-5: ");
			int playlistAction = input.nextInt();
			input.nextLine();
			
			if (playlistAction == 1) {
				addSong();
			}else if(playlistAction == 2) {
				deleteSong();
			}else if(playlistAction == 3) {
				editSongDetails();
			}else if (playlistAction == 4) {
				showPlaylist();
				
			}else {
				System.out.println("Ending Program - See you later!");
				repeat = false;
				sc.endProgram();
			}
				
			
		}
	
		
	}

}
