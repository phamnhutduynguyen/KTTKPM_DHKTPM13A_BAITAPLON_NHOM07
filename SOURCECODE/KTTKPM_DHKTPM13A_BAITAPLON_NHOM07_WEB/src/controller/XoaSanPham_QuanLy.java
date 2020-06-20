package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.entity.SanPham;


/**
 * Servlet implementation class XoaSanPham_QuanLy
 */
@WebServlet("/XoaSanPham_QuanLy")
public class XoaSanPham_QuanLy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
     private SanPhamDAORemote sanPhamDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPham_QuanLy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SanPham sanPhamXoa = sanPhamDAORemote.getSanPhamFindByMaSanPham(Integer.parseInt(request.getParameter("id")));
		sanPhamDAORemote.removeSanPham(sanPhamXoa);
		System.out.println("????????????????????????????????????? Xoa san pham duoc ???????????????????????????????");
		response.sendRedirect("QuanLySanPham");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
