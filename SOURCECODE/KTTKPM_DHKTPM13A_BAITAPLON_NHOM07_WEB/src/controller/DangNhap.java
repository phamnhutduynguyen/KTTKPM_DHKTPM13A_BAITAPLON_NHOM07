package controller;

import java.io.IOException;

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
 * Servlet implementation class DangNhap
 */
@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       NguoiDungDAORemote remote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/DangNhap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		String thongbao = "";
		
		NguoiDung nd = null;
		try {
			nd = (NguoiDung) remote.getNguoiDungFindByUsername(userName);
		}catch(Exception e){
			if(e != null) {
				nd = new NguoiDung();
			}
		}
		
		
		if(pass.equals(nd.getPass())) {
			System.out.println("da vao nhan vien");
			session.setAttribute("user", nd.getUsername());
			if(nd.getIsNhanVien()) {
				System.out.println("admin 1");
				session.setAttribute("admin", "1");
				response.sendRedirect("QuanLyDonHang");
			}else {
				response.sendRedirect("Home");
			}
		}else {
			thongbao = "Tài khoản hoặc mật khẩu không đúng. Vui lòng nhập lại!";
			request.setAttribute("thongbao", thongbao);
			request.getRequestDispatcher("/WEB-INF/view/DangNhap.jsp").forward(request, response);
		}
	
	}

}
