package controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.DanhMucDAORemote;
import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.entity.DanhMuc;
import fit.se.nhom07.entity.SanPham;


/**
 * Servlet implementation class QuanLy
 */
@WebServlet("/QuanLySanPham")
public class QuanLySanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private SanPhamDAORemote sanPhamDAORemote;
       @EJB
       private DanhMucDAORemote danhMucDAORemote;
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
		int cn = Integer.parseInt(request.getParameter("cn"));		
		if(cn==1) {				
			SanPham sanPham = new SanPham();
			sanPham.setTenSanPham(request.getParameter("tensanpham"));
			sanPham.setGia(Integer.parseInt(request.getParameter("gia")));
			sanPham.setSoLuong(Integer.parseInt(request.getParameter("soluong")));
			sanPham.setMoTa(request.getParameter("mota"));
			sanPham.setHinh(request.getParameter("hinh"));
			DanhMuc danhMuc =  danhMucDAORemote.getDanhMucFindByMaDanhMuc(Integer.parseInt(request.getParameter("madanhmuc")));
			sanPham.setMaDanhMuc(danhMuc);
			sanPhamDAORemote.persistSanPham(sanPham);
			System.out.println("Them SP Thanh Cong");
			response.sendRedirect("QuanLySanPham");
			return;			
		}		
		response.sendRedirect("QuanLySanPham");
	}

}
