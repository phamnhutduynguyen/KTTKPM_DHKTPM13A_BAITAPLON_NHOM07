package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.giohang.GioHangBeanRemote;

/**
 * Servlet implementation class CapNhatGioHang
 */
@WebServlet("/CapNhatGioHang")
public class CapNhatGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private SanPhamDAORemote sanPhamDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sl = Integer.parseInt(request.getParameter("sl"));
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		GioHangBeanRemote gioHang = (GioHangBeanRemote) session.getAttribute("cart");
		
		if(gioHang != null) {
			int soluong = gioHang.getGioHang().get(sanPhamDAORemote.getSanPhamFindByMaSanPham(id));
			if(soluong+sl <1 || soluong+sl> sanPhamDAORemote.getSanPhamFindByMaSanPham(id).getSoLuong()) {
				response.sendRedirect("ThongTinGioHang");
			}else {
				gioHang.thayDoiSoLuong(sanPhamDAORemote.getSanPhamFindByMaSanPham(id), soluong+sl);
				response.sendRedirect("ThongTinGioHang");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
