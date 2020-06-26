package controller;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.entity.SanPham;
import fit.se.nhom07.giohang.GioHangBeanRemote;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/ThongTinGioHang")
public class ThongTinGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBeanRemote ghBean = (GioHangBeanRemote) session.getAttribute("cart");
		
		session.setAttribute("giohangbean", ghBean);
		int tongTienGioHang = 0;
		
		if(ghBean != null) {
			for (Entry<SanPham, Integer> entry : ghBean.getGioHang().entrySet()) {
			     tongTienGioHang  += entry.getKey().getGia() * entry.getValue();
			}
		}		
		request.setAttribute("tongtien", tongTienGioHang);
		request.getRequestDispatcher("/WEB-INF/view/GioHang.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
