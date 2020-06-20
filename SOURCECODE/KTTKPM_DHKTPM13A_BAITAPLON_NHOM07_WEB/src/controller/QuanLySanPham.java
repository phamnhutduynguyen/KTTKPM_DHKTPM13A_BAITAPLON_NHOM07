package controller;


import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.entity.SanPham;


/**
 * Servlet implementation class QuanLy
 */
@WebServlet("/QuanLySanPham")
public class QuanLySanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private SanPhamDAORemote sanPhamDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null) {
			List<SanPham> sanPhams = sanPhamDAORemote.getSanPhamFindAll();
			request.setAttribute("listsanpham", sanPhams);
			request.getRequestDispatcher("/WEB-INF/view/QuanLySanPham.jsp").forward(request, response);
		}else {
			response.sendRedirect("Home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
