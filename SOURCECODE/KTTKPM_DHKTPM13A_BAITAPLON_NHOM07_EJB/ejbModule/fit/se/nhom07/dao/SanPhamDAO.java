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
import fit.se.nhom07.entity.SanPham;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "SanPhamDAO", mappedName = "WebBanHang_EAR-WebBanHang_EJB-SanPhamDAO")
public class SanPhamDAO
        implements SanPhamDAOLocal, SanPhamDAORemote
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
    public SanPhamDAO() {
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
    public SanPham persistSanPham(SanPham sanPham) {
        em.persist(sanPham);
        return sanPham;
    }

    /**
     * @generated DT_ID=none
     */
    public SanPham mergeSanPham(SanPham sanPham) {
        return em.merge(sanPham);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeSanPham(SanPham sanPham) {
        sanPham = em.find(SanPham.class, sanPham.getMaSanPham());
        em.remove(sanPham);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SanPham> getSanPhamFindAll() {
        return em.createNamedQuery("SanPham.findAll").getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public SanPham getSanPhamFindByMaSanPham(Integer maSanPham) {
        return (SanPham) em.createNamedQuery("SanPham.findByMaSanPham").setParameter("maSanPham", maSanPham).getSingleResult();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SanPham> getSanPhamFindByTenSanPham(String tenSanPham) {
        return em.createNamedQuery("SanPham.findByTenSanPham").setParameter("tenSanPham", tenSanPham).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SanPham> getSanPhamFindByGia(Integer gia) {
        return em.createNamedQuery("SanPham.findByGia").setParameter("gia", gia).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SanPham> getSanPhamFindBySoLuong(Integer soLuong) {
        return em.createNamedQuery("SanPham.findBySoLuong").setParameter("soLuong", soLuong).getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SanPham> getSanPhamFindByMoTa(String moTa) {
        return em.createNamedQuery("SanPham.findByMoTa").setParameter("moTa", moTa).getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SanPham> getSanPhamFindByDanhMuc(DanhMuc DanhMuc) {
        return em.createNamedQuery("SanPham.findByDanhMuc").setParameter("maDanhMuc", DanhMuc).getResultList();
    }

}
