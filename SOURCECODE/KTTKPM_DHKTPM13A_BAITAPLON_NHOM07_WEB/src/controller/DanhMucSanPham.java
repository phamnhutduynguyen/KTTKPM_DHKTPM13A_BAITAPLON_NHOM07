package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.nhom07.dao.DanhMucDAORemote;
import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.entity.DanhMuc;
import fit.se.nhom07.entity.SanPham;


/**
 * Servlet implementation class DanhMuc
 */
@WebServlet("/DanhMucSanPham")
public class DanhMucSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @EJB
      private SanPhamDAORemote sanPhamDAORemote;
      @EJB
      private DanhMucDAORemote danhMucDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhMucSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maDM = Integer.parseInt(request.getParameter("id"));
		DanhMuc danhmuc = danhMucDAORemote.getDanhMucFindByMaDanhMuc(maDM);
		
		List<SanPham> list = sanPhamDAORemote.getSanPhamFindByDanhMuc(danhmuc);
		
		
		request.setAttribute("tenDanhMuc", danhmuc.getTenDanhMuc());
		request.setAttribute("dssp", list);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
