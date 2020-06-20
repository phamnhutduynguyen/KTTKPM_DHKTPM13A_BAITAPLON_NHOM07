package fit.se.nhom07.queue;

import java.util.List;

import javax.ejb.Remote;

import fit.se.nhom07.entity.DonHang;


@Remote
public interface SenderRemote {
	public void sendMessage(DonHang dh);
}
