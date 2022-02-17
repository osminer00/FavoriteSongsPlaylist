package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Song;

/**
 * Servlet implementation class NewSongServlet
 */
@WebServlet("/newSongServlet")
public class NewSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String artist = request.getParameter("artist");
		String genre = request.getParameter("genre");
		
		Song s = new Song(name, artist, genre);
		SongController sc = new SongController();
		sc.insertSong(s);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
