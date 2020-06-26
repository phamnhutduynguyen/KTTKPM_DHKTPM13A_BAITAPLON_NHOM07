package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.NguoiDungDAORemote;
import fit.se.nhom07.entity.NguoiDung;


/**
 * Servlet implementation class QuanLyNguoiDung
 */
@WebServlet("/QuanLyNguoiDung")
public class QuanLyNguoiDung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private NguoiDungDAORemote nguoiDungDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyNguoiDung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null) {
		List<NguoiDung> nguoiDungs = nguoiDungDAORemote.getNguoiDungFindAll();
			List<NguoiDung> listNguoiDung = new ArrayList<NguoiDung>();
			for (NguoiDung nguoiDung : nguoiDungs) {
				listNguoiDung.add(nguoiDung);
			}
			request.setAttribute("dsnd", listNguoiDung);
			request.getRequestDispatcher("/WEB-INF/view/QuanLyNguoiDung.jsp").forward(request, response);
		}else {
			response.sendRedirect("Home");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
