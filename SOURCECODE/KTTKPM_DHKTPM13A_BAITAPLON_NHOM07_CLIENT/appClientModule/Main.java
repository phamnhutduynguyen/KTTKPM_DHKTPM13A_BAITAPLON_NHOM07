import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fit.se.nhom07.dao.DonHangDAORemote;
import fit.se.nhom07.entity.DonHang;

public class Main {
	public static void main(String[] args) throws NamingException{
		// TODO Auto-generated method stubContext ctx;
		Context ctx;
		try {
			ctx = new InitialContext();
			DonHangDAORemote rm = (DonHangDAORemote) ctx.lookup("EAR-WebBanHang_EJB-DonHangDAO");
			List<DonHang> dhs = rm.getDonHangFindAll();
			System.out.println(dhs.size());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}