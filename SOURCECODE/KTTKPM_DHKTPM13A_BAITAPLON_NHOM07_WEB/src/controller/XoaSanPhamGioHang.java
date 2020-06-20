package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.giohang.GioHangBeanRemote;


/**
 * Servlet implementation class XoaSanPhamGioHang
 */
@WebServlet("/XoaSanPhamGioHang")
public class XoaSanPhamGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       SanPhamDAORemote daoRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPhamGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBeanRemote gioHang = (GioHangBeanRemote) session.getAttribute("cart");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		gioHang.xoaSanPham(daoRemote.getSanPhamFindByMaSanPham(id));
		
		if(gioHang.getGioHang().size() < 1) {
			session.removeAttribute("cart");
			gioHang.remove();
		}
		
		response.sendRedirect("ThongTinGioHang");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
