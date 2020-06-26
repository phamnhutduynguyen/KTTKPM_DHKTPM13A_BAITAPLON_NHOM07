/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.se.nhom07.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author 
 */
@Embeddable
public class ChiTietDonHangPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "MaDonHang")
    private int maDonHang;
    @Basic(optional = false)
    @Column(name = "MaSanPham")
    private int maSanPham;

    public ChiTietDonHangPK() {
    }

    public ChiTietDonHangPK(int maDonHang, int maSanPham) {
        this.maDonHang = maDonHang;
        this.maSanPham = maSanPham;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }   

	public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maDonHang;
        hash += (int) maSanPham;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ChiTietDonHangPK)) {
            return false;
        }
        ChiTietDonHangPK other = (ChiTietDonHangPK) object;
        if (this.maDonHang != other.maDonHang) {
            return false;
        }
        if (this.maSanPham != other.maSanPham) {
            return false;
        }
        return true;
    }
}
