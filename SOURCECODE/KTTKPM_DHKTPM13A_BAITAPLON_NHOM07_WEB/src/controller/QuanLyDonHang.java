package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.ChiTietDonHangDAORemote;
import fit.se.nhom07.dao.DonHangDAORemote;
import fit.se.nhom07.entity.ChiTietDonHang;
import fit.se.nhom07.entity.ChiTietDonHangPK;
import fit.se.nhom07.entity.DonHang;
import fit.se.nhom07.queue.ReciverRemote;


/**
 * Servlet implementation class QuanLyDonHang
 */
@WebServlet("/QuanLyDonHang")
public class QuanLyDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @EJB
      private DonHangDAORemote donHangDAORemote;
      
      @EJB
      private ChiTietDonHangDAORemote chiTietDonHangDAORemote;;
      @EJB
      private ReciverRemote reciverRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null) {
			List<DonHang> donHangChuaXacNhan = reciverRemote.recive();
			List<DonHang> donHangDaXacNhan = donHangDAORemote.getDonHangFindAll();
			request.setAttribute("dsdhfalse", donHangChuaXacNhan);
			request.setAttribute("dsdhtrue", donHangDaXacNhan);
			request.getRequestDispatcher("/WEB-INF/view/QuanLyDonHang.jsp").forward(request, response);
		}else {
			response.sendRedirect("Home");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cn = Integer.parseInt(request.getParameter("cn"));
		
		if(cn == 1) {
			
			doGet(request, response);
		}
		if(cn == 2) {
			System.out.println("DEo zo cn2");
			String user =  request.getParameter("user");
			System.out.println(user);
			List<DonHang> listdh = reciverRemote.recive();
			for(DonHang dh : listdh) {
				if(dh.getMaNguoiDung().getUsername().equalsIgnoreCase(user)) {
					
					DonHang dhcc = new DonHang();
					dhcc.setMaNguoiDung(dh.getMaNguoiDung());
					LocalDate ldate = LocalDate.now();
					Date date = Date.valueOf(ldate);
					dhcc.setNgayTaoDonHang(date);
					donHangDAORemote.persistDonHang(dhcc);
					List<DonHang> ListDH = donHangDAORemote.getDonHangFindAll();
					DonHang dhnew = ListDH.get((ListDH.size()) - 1);
					
					List<ChiTietDonHang> ctdhcc = dh.getChiTietDonHangList();
					for (ChiTietDonHang ct : ctdhcc) {
						ChiTietDonHang ctcc = new ChiTietDonHang();
						ChiTietDonHangPK pk = new ChiTietDonHangPK(dhnew.getMaDonHang(), ct.getSanPham().getMaSanPham());
						ctcc.setChiTietDonHangPK(pk);
						ctcc.setGiaSanPham(ct.getSanPham().getGia());
						ctcc.setSoLuongSanPham(ct.getSoLuongSanPham());
						chiTietDonHangDAORemote.persistChiTietDonHang(ctcc);
					}
					

				}
			}
			response.sendRedirect("QuanLyDonHang");
		}
	}

}
