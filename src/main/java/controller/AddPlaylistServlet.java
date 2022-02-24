package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlaylistManager;
import model.Song;

/**
 * Servlet implementation class AddPlaylistServlet
 */
@WebServlet("/addPlaylistServlet")
public class AddPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SongController sc = new SongController();
		
		String playlistName = request.getParameter("playlistName");
		String creator = request.getParameter("creator");
		PlaylistManager manager = new PlaylistManager(playlistName, creator);
		
		String[] addSongs = request.getParameterValues("addSongs");
		List<Song> newSongs = new ArrayList<Song>();
		
		if (addSongs.length > 0 && addSongs != null) {
			for (int i = 0; i < addSongs.length; i++) {
				Song song = sc.searchSongbyId(Integer.parseInt(addSongs[i]));
				newSongs.add(song);
			}
		}
		manager.setPlaylist(newSongs);
		
		PlaylistManagerEditor managerEditor = new PlaylistManagerEditor();
		
		managerEditor.addNewPlaylist(manager);
		
		getServletContext().getRequestDispatcher("/displayPlaylistManagerServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
