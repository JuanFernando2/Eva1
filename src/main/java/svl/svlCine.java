package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.CineDAO;


public class svlCine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public svlCine() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Object idCine = request.getParameter("idCine");
		if(idCine == null) {
			String[][] mCines = CineDAO.getVerCines();
			session.setAttribute("id",idCine.equals("cines"));
			session.setAttribute("id",idCine == null ?null : idCine.equals("cartelera"));
			session.setAttribute("mCines", mCines);
		}
		response.sendRedirect("index.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
