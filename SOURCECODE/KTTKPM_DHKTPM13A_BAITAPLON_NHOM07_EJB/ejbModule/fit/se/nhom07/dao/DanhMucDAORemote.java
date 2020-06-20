package fit.se.nhom07.dao;

import java.util.List;
import javax.ejb.Remote;

import fit.se.nhom07.entity.DanhMuc;


/**
 * @generated DT_ID=none
 */
@Remote
public interface DanhMucDAORemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public DanhMuc persistDanhMuc(DanhMuc danhMuc);

    /**
     * @generated DT_ID=none
     */
    public DanhMuc mergeDanhMuc(DanhMuc danhMuc);

    /**
     * @generated DT_ID=none
     */
    public void removeDanhMuc(DanhMuc danhMuc);

    /**
     * @generated DT_ID=none
     */
    public List<DanhMuc> getDanhMucFindAll();

    /**
     * @generated DT_ID=none
     */
    public DanhMuc getDanhMucFindByMaDanhMuc(Integer maDanhMuc);

    /**
     * @generated DT_ID=none
     */
    public List<DanhMuc> getDanhMucFindByTenDanhMuc(String tenDanhMuc);

}
