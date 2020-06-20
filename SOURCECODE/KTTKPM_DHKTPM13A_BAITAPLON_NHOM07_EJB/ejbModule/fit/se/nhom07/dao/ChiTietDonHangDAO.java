package fit.se.nhom07.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fit.se.nhom07.entity.ChiTietDonHang;
import fit.se.nhom07.entity.ChiTietDonHangPK;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "ChiTietDonHangDAO", mappedName = "EAR-WebBanHang_EJB-ChiTietDonHangDAO")
public class ChiTietDonHangDAO implements ChiTietDonHangDAOLocal, ChiTietDonHangDAORemote
{

    /**
     * @generated DT_ID=none
     */

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="KTTKPM_DHKTPM13A_BAITAPLON_NHOM07_EJB")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public ChiTietDonHangDAO() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public ChiTietDonHang persistChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        em.persist(chiTietDonHang);
        return chiTietDonHang;
    }

    /**
     * @generated DT_ID=none
     */
    public ChiTietDonHang mergeChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        return em.merge(chiTietDonHang);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        ChiTietDonHangPK chiTietDonHangPK = new ChiTietDonHangPK();
        chiTietDonHangPK.setMaDonHang(chiTietDonHang.getChiTietDonHangPK().getMaDonHang());
        chiTietDonHangPK.setMaSanPham(chiTietDonHang.getChiTietDonHangPK().getMaSanPham());
        chiTietDonHang = em.find(ChiTietDonHang.class, chiTietDonHangPK);
        em.remove(chiTietDonHang);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ChiTietDonHang> getChiTietDonHangFindAll() {
        return em.createNamedQuery("ChiTietDonHang.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ChiTietDonHang> getChiTietDonHangFindByMaDonHang(Integer maDonHang) {
        return em.createNamedQuery("ChiTietDonHang.findByMaDonHang").setParameter("maDonHang", maDonHang).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ChiTietDonHang> getChiTietDonHangFindByMaSanPham(Integer maSanPham) {
        return em.createNamedQuery("ChiTietDonHang.findByMaSanPham").setParameter("maSanPham", maSanPham).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ChiTietDonHang> getChiTietDonHangFindBySoLuongSanPham(Integer soLuongSanPham) {
        return em.createNamedQuery("ChiTietDonHang.findBySoLuongSanPham").setParameter("soLuongSanPham", soLuongSanPham).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ChiTietDonHang> getChiTietDonHangFindByGiaSanPham(Integer giaSanPham) {
        return em.createNamedQuery("ChiTietDonHang.findByGiaSanPham").setParameter("giaSanPham", giaSanPham).getResultList();
    }

}
