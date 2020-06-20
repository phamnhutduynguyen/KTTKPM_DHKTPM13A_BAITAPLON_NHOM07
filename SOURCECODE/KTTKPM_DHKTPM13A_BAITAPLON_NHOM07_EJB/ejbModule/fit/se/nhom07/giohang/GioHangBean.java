package fit.se.nhom07.giohang;

import java.util.HashMap;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import fit.se.nhom07.entity.SanPham;


/**
 * Session Bean implementation class GioHangBean
 */
@Stateful(mappedName = "giohangmapped")
@LocalBean
public class GioHangBean implements GioHangBeanRemote {
	private HashMap<SanPham, Integer> gioHang;
	private String user;

	public GioHangBean() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@PostConstruct
	public void construct() {
		this.gioHang = new HashMap<SanPham, Integer>();
	}

	@Override
	public void themSanPham(SanPham sp) {
		gioHang.put(sp, 1);
	}
	
	@Override
	public void xoaSanPham(SanPham sp) {
		gioHang.remove(sp);
	}

	@Override
	public HashMap<SanPham, Integer> getGioHang() {
		return this.gioHang;
	}
	@Remove
	@Override
	public void remove() {
		gioHang.clear();
	}

	@Override
	public void thayDoiSoLuong(SanPham sp, int soLuong) {
		gioHang.put(sp, soLuong);
	}

}
