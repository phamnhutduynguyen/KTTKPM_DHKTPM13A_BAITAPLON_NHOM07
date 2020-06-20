package fit.se.nhom07.dao;

import java.util.List;
import javax.ejb.Remote;

import fit.se.nhom07.entity.DanhMuc;
import fit.se.nhom07.entity.SanPham;


/**
 * @generated DT_ID=none
 */
@Remote
public interface SanPhamDAORemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public SanPham persistSanPham(SanPham sanPham);

    /**
     * @generated DT_ID=none
     */
    public SanPham mergeSanPham(SanPham sanPham);

    /**
     * @generated DT_ID=none
     */
    public void removeSanPham(SanPham sanPham);

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindAll();

    /**
     * @generated DT_ID=none
     */
    public SanPham getSanPhamFindByMaSanPham(Integer maSanPham);

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindByTenSanPham(String tenSanPham);

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindByGia(Integer gia);

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindBySoLuong(Integer soLuong);

    /**
     * @generated DT_ID=none
     */
    public List<SanPham> getSanPhamFindByMoTa(String moTa);
    
    public List<SanPham> getSanPhamFindByDanhMuc(DanhMuc DanhMuc);

}
