package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fit.se.nhom07.dao.NguoiDungDAORemote;
import fit.se.nhom07.entity.ChiTietDonHang;
import fit.se.nhom07.entity.ChiTietDonHangPK;
import fit.se.nhom07.entity.DonHang;
import fit.se.nhom07.entity.NguoiDung;
import fit.se.nhom07.entity.SanPham;
import fit.se.nhom07.giohang.GioHangBeanRemote;
import fit.se.nhom07.queue.SenderRemote;


/**
 * Servlet implementation class XacNhanDonHang
 */
@WebServlet("/XacNhanDonHang")
public class XacNhanDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private SenderRemote sender;
    @EJB
    private NguoiDungDAORemote nguoiDungRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String user = (String) session.getAttribute("user");
		if(user == null) {
			String thongbao = "Bạn cần đăng nhập trước khi xác nhận đơn hàng";
			request.setAttribute("thongbao", thongbao);
			request.getRequestDispatcher("DangNhap").forward(request, response);
		}else {
			GioHangBeanRemote gioHang = (GioHangBeanRemote) session.getAttribute("cart");
			NguoiDung nd  = nguoiDungRemote.getNguoiDungFindByUsername(user);
			// viếc cái xác nhận giở hàng của
			// chỉ càn lưu xuống database vs xóa trong session
			ArrayList<ChiTietDonHang> dsdh = new ArrayList<ChiTietDonHang>();
			
			if(gioHang != null) {
				DonHang dh = new DonHang();
				dh.setMaNguoiDung(nd);
				
				for (Map.Entry<SanPham, Integer> entry : gioHang.getGioHang().entrySet()) {
					ChiTietDonHangPK pk = new ChiTietDonHangPK(1, entry.getKey().getMaSanPham());
					ChiTietDonHang ct = new ChiTietDonHang(pk);
					ct.setSanPham(entry.getKey());
					ct.setSoLuongSanPham(entry.getValue());
				     dsdh.add(ct); //cau lenh nay ra loi LAZY
				     // coi fix t dii ra ngoai ti
				     // m
				}
				dh.setChiTietDonHangList(dsdh);
				//Jsonb jsonb = JsonbBuilder.create();
				//String donhangjson = jsonb.toJson(dh);
				sender.sendMessage(dh);// giờ lỗi chỗ này
				gioHang.remove();
			}
			response.sendRedirect("Home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
