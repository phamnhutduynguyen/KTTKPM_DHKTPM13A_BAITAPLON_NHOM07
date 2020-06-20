package controller;

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
 * Servlet implementation class Index
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private SanPhamDAORemote sanPhamDAORemote;
	@EJB
	private DanhMucDAORemote danhMucDAORemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<DanhMuc> danhMucs = danhMucDAORemote.getDanhMucFindAll();
		List<SanPham> sanPhams = sanPhamDAORemote.getSanPhamFindAll();
		
		request.setAttribute("dssp", sanPhams);
		session.setAttribute("dsdm", danhMucs);
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
