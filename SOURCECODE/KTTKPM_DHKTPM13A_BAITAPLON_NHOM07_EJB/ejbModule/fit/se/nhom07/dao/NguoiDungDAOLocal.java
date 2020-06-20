package fit.se.nhom07.dao;

import java.util.List;
import javax.ejb.Local;

import fit.se.nhom07.entity.NguoiDung;


/**
 * @generated DT_ID=none
 */
@Local
public interface NguoiDungDAOLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public NguoiDung persistNguoiDung(NguoiDung nguoiDung);

    /**
     * @generated DT_ID=none
     */
    public NguoiDung mergeNguoiDung(NguoiDung nguoiDung);

    /**
     * @generated DT_ID=none
     */
    public void removeNguoiDung(NguoiDung nguoiDung);

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindAll();

    /**
     * @generated DT_ID=none
     */
    public NguoiDung getNguoiDungFindByMaNguoiDung(Integer maNguoiDung);

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByTenNguoiDung(String tenNguoiDung);

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByDiaChi(String diaChi);

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByEmail(String email);

    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindBySoDienThoai(String soDienThoai);

    /**
     * @generated DT_ID=none
     */
    public NguoiDung getNguoiDungFindByUsername(String username);


    /**
     * @generated DT_ID=none
     */
    public List<NguoiDung> getNguoiDungFindByIsNhanVien(Boolean isNhanVien);

}
