package fit.se.nhom07.queue;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import fit.se.nhom07.entity.DonHang;


/**
 * Session Bean implementation class Reciver
 */
@Stateless
@LocalBean
public class Reciver implements ReciverRemote {
	@Resource(mappedName = "jms/JMSConnectionFactory")
    private ConnectionFactory connectionFactory;
 
    @Resource(mappedName = "jms/donhangqueue")
    Queue myQueue;
    
    /**
     * Default constructor. 
     */
    public Reciver() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DonHang> recive() {
    	Connection connection;
    	List<DonHang> list = new ArrayList<DonHang>();
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueBrowser queueBrowser = session.createBrowser(myQueue);
			Enumeration<Object> enumeration = queueBrowser.getEnumeration();
			while (enumeration.hasMoreElements()) {
				Object message =  enumeration.nextElement();
				if(message instanceof ObjectMessage) {
					Object obj = ((ObjectMessage) message).getObject();
					DonHang dh = (DonHang) obj;
					list.add(dh);
				}
				
				
			}
			session.close();
            connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    	return list;
    }
}
