package fit.se.nhom07.giohang;

import java.util.HashMap;

import javax.ejb.Remote;

import fit.se.nhom07.entity.SanPham;


@Remote
public interface GioHangBeanRemote {
	public void themSanPham(SanPham sp); 
	public void xoaSanPham(SanPham sp);
	public void thayDoiSoLuong(SanPham sp, int soLuong);
	public HashMap<SanPham, Integer> getGioHang();
	public void setUser(String user);
	public String getUser();
	public void remove();
}
