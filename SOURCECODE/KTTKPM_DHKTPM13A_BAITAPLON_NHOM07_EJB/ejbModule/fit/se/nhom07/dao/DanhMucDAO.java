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

import fit.se.nhom07.entity.DanhMuc;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "DanhMucDAO", mappedName = "WebBanHang_EAR-WebBanHang_EJB-DanhMucDAO")
public class DanhMucDAO
        implements DanhMucDAOLocal, DanhMucDAORemote
{

    /**
     * @generated DT_ID=none
     */
//	@Resource
//	SessionContext sessionContext;

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="KTTKPM_DHKTPM13A_BAITAPLON_NHOM07_EJB")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public DanhMucDAO() {
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
    public DanhMuc persistDanhMuc(DanhMuc danhMuc) {
        em.persist(danhMuc);
        return danhMuc;
    }

    /**
     * @generated DT_ID=none
     */
    public DanhMuc mergeDanhMuc(DanhMuc danhMuc) {
        return em.merge(danhMuc);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeDanhMuc(DanhMuc danhMuc) {
        danhMuc = em.find(DanhMuc.class, danhMuc.getMaDanhMuc());
        em.remove(danhMuc);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<DanhMuc> getDanhMucFindAll() {
        return em.createNamedQuery("DanhMuc.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public DanhMuc getDanhMucFindByMaDanhMuc(Integer maDanhMuc) {
        return (DanhMuc) em.createNamedQuery("DanhMuc.findByMaDanhMuc").setParameter("maDanhMuc", maDanhMuc).getSingleResult();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<DanhMuc> getDanhMucFindByTenDanhMuc(String tenDanhMuc) {
        return em.createNamedQuery("DanhMuc.findByTenDanhMuc").setParameter("tenDanhMuc", tenDanhMuc).getResultList();
    }

}
