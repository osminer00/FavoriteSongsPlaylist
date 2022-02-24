package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PlaylistManager;

/**
 * Servlet implementation class ManagerNavServlet
 */
@WebServlet("/managerNavServlet")
public class ManagerNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerNavServlet() {
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
		PlaylistManagerEditor editor = new PlaylistManagerEditor();
		String sel = request.getParameter("selection");
		
		if (sel.equals("New Playlist")) {
			SongController sc = new SongController();
			request.setAttribute("songs", sc.displayPlaylist());
			if(sc.displayPlaylist().isEmpty()) {
				request.setAttribute("songs", " ");
			}
			getServletContext().getRequestDispatcher("/newPlaylist.jsp").forward(request, response);
			
		}else if(sel.equals("Delete Playlist")){
			Integer id = Integer.parseInt(request.getParameter("id"));
			PlaylistManager manager = editor.findId(id);
			editor.removePlaylist(manager);
			getServletContext().getRequestDispatcher("/displayPlaylistManagerServlet").forward(request, response);
		}
	}

}
