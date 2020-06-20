package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jms.*;
import javax.json.bind.*;
import javax.naming.Context;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import fit.se.nhom07.dao.NguoiDungDAORemote;
import fit.se.nhom07.entity.NguoiDung;

/**
 * Servlet implementation class DangKy
 */
@WebServlet("/DangKy")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private NguoiDungDAORemote ndRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/DangKy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String thongbao = "";
		String hoten = request.getParameter("hoten");
		String diachi = request.getParameter("diachi");
		String email = request.getParameter("email");
		String sdt = request.getParameter("phone");
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String passconfirm = request.getParameter("passwordconfirm");
		NguoiDung nguoidung = new NguoiDung(hoten, diachi, email, sdt, username, pass, false);
		try {
			ndRemote.getNguoiDungFindByUsername(username);
			thongbao = "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.";
			request.setAttribute("thongbao", thongbao);
			request.getRequestDispatcher("/WEB-INF/view/DangKy.jsp").forward(request, response);
		} catch (Exception e) {
			if (!pass.equals(passconfirm)) {
				thongbao = "Mật khẩu nhập lại không trùng khớp";
				request.setAttribute("thongbao", thongbao);
				request.getRequestDispatcher("/WEB-INF/view/DangKy.jsp").forward(request, response);
			} else {
				ndRemote.persistNguoiDung(nguoidung);
				response.sendRedirect("Home");
			}
		}
		
		

	}

}
