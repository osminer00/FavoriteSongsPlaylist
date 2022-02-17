package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Song;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String sel = request.getParameter("selection");
		
		String path = "/displayPlaylistServlet";
		
		if(sel.equals("delete song")) {
			try {
				Integer tId = Integer.parseInt(request.getParameter("id"));
				Song deleteSong = sc.searchSongbyId(tId);
				sc.removeSong(deleteSong);
				
			}catch(NumberFormatException e) {
				System.out.println("Did Not Select A Song to Delete. Try Again.");
			}
		}else if(sel.equals("edit song")){
			try {
				Integer tId = Integer.parseInt(request.getParameter("id"));
				Song editSong = sc.searchSongbyId(tId);
				request.setAttribute("editSong", editSong);
				path = "/playlistEditor.jsp";
			}catch(NumberFormatException e) {
				System.out.println("Did Not Select A Song to Edit. Try Again.");
			}
		}else if(sel.equals("add song")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
