package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Song;

/**
 * Servlet implementation class PlaylistEditorServlet
 */
@WebServlet("/playlistEditorServlet")
public class PlaylistEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistEditorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SongController sc = new SongController();
		String song = request.getParameter("song");
		String artist = request.getParameter("artist");
		String genre = request.getParameter("genre");
		
		Integer tId = Integer.parseInt(request.getParameter("id"));
		
		Song songEdit = sc.searchSongbyId(tId);
		
		songEdit.setSong(song);
		songEdit.setArtist(artist);
		songEdit.setGenre(genre);
		
		sc.updateSong(songEdit);
		
		getServletContext().getRequestDispatcher("/displayPlaylistServlet").forward(request, response);
	}

}
