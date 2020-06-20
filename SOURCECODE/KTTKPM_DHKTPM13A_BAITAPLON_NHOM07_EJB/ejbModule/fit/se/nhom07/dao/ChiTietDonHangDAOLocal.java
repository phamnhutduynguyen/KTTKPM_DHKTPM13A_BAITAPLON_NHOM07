package fit.se.nhom07.dao;

import java.util.List;
import javax.ejb.Local;

import fit.se.nhom07.entity.ChiTietDonHang;


/**
 * @generated DT_ID=none
 */
@Local
public interface ChiTietDonHangDAOLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public ChiTietDonHang persistChiTietDonHang(ChiTietDonHang chiTietDonHang);

    /**
     * @generated DT_ID=none
     */
    public ChiTietDonHang mergeChiTietDonHang(ChiTietDonHang chiTietDonHang);

    /**
     * @generated DT_ID=none
     */
    public void removeChiTietDonHang(ChiTietDonHang chiTietDonHang);

    /**
     * @generated DT_ID=none
     */
    public List<ChiTietDonHang> getChiTietDonHangFindAll();

    /**
     * @generated DT_ID=none
     */
    public List<ChiTietDonHang> getChiTietDonHangFindByMaDonHang(Integer maDonHang);

    /**
     * @generated DT_ID=none
     */
    public List<ChiTietDonHang> getChiTietDonHangFindByMaSanPham(Integer maSanPham);

    /**
     * @generated DT_ID=none
     */
    public List<ChiTietDonHang> getChiTietDonHangFindBySoLuongSanPham(Integer soLuongSanPham);

    /**
     * @generated DT_ID=none
     */
    public List<ChiTietDonHang> getChiTietDonHangFindByGiaSanPham(Integer giaSanPham);

}
