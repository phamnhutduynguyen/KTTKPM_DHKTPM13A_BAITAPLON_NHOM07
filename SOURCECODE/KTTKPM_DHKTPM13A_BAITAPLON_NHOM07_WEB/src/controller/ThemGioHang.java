package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.SanPhamDAORemote;
import fit.se.nhom07.entity.SanPham;
import fit.se.nhom07.giohang.GioHangBeanRemote;

/**
 * Servlet implementation class ThemGioHang
 */
@WebServlet("/ThemGioHang")
public class ThemGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private SanPhamDAORemote sanPhamDAORemote;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemGioHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		SanPham sp = sanPhamDAORemote.getSanPhamFindByMaSanPham(id);
		GioHangBeanRemote gioHang = (GioHangBeanRemote) session.getAttribute("cart");
		if (sp.getSoLuong() < 1) {
			out.println("alert('Sản phẩm này đã hết hàng.');");
		} else {
			if(gioHang == null) {
				try {
					Context context = new InitialContext();
					gioHang =  (GioHangBeanRemote) context.lookup("giohangmapped");					
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}else {
				for (Entry<SanPham, Integer> entry : gioHang.getGioHang().entrySet()) {
					if(entry.getKey().getMaSanPham() == id) {
						int soluong = gioHang.getGioHang().get(sanPhamDAORemote.getSanPhamFindByMaSanPham(id));
						System.out.println("Số Lượng Ra Đấy: " +soluong);					
						session.setAttribute("cart", gioHang);
						gioHang.thayDoiSoLuong(sp, soluong+1);
						response.sendRedirect("ThongTinGioHang");
						return;
					}
					
				}
			}							
			System.out.println("Raaa dayyyy");
			session.setAttribute("cart", gioHang);
			gioHang.themSanPham(sp);
			response.sendRedirect("ThongTinGioHang");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
