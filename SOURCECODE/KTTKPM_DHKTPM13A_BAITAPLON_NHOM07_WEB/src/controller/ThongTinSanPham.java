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

import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.entity.SanPham;


/**
 * Servlet implementation class ThongTinSanPham
 */
@WebServlet("/ThongTinSanPham")
public class ThongTinSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private SanPhamDAORemote sanPhamDAORemote;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		SanPham sanPham = sanPhamDAORemote.getSanPhamFindByMaSanPham(i);
		
		List<SanPham> sanPhams = sanPhamDAORemote.getSanPhamFindAll();
		request.setAttribute("dssp", sanPhams);
		
		request.setAttribute("ttsp", sanPham);
		request.getRequestDispatcher("/WEB-INF/view/ThongTinSanPham.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
