package fit.se.nhom07.dao;

import java.util.List;
import javax.ejb.Remote;

import fit.se.nhom07.entity.DonHang;


/**
 * @generated DT_ID=none
 */
@Remote
public interface DonHangDAORemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public DonHang persistDonHang(DonHang donHang);

    /**
     * @generated DT_ID=none
     */
    public DonHang mergeDonHang(DonHang donHang);

    /**
     * @generated DT_ID=none
     */
    public void removeDonHang(DonHang donHang);

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindAll();

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindByMaDonHang(Integer maDonHang);

    /**
     * @generated DT_ID=none
     */
    public List<DonHang> getDonHangFindByNgayTaoDonHang(java.util.Date ngayTaoDonHang);

}
