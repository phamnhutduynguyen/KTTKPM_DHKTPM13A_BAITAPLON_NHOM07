package fit.se.nhom07.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fit.se.nhom07.entity.DonHang;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "DonHangDAO", mappedName = "EAR-WebBanHang_EJB-DonHangDAO")
public class DonHangDAO
        implements DonHangDAOLocal, DonHangDAORemote
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
    public DonHangDAO() {
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
    public DonHang persistDonHang(DonHang donHang) {
        em.persist(donHang);
        return donHang;
    }

    /**
     * @generated DT_ID=none
     */
    public DonHang mergeDonHang(DonHang donHang) {
        return em.merge(donHang);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeDonHang(DonHang donHang) {
        donHang = em.find(DonHang.class, donHang.getMaDonHang());
        em.remove(donHang);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<DonHang> getDonHangFindAll() {
        return em.createNamedQuery("DonHang.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<DonHang> getDonHangFindByMaDonHang(Integer maDonHang) {
        return em.createNamedQuery("DonHang.findByMaDonHang").setParameter("maDonHang", maDonHang).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<DonHang> getDonHangFindByNgayTaoDonHang(java.util.Date ngayTaoDonHang) {
        return em.createNamedQuery("DonHang.findByNgayTaoDonHang").setParameter("ngayTaoDonHang", ngayTaoDonHang).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
}
