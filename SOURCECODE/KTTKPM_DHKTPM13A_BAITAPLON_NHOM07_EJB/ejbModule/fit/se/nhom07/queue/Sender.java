package fit.se.nhom07.queue;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import fit.se.nhom07.entity.DonHang;


/**
 * Session Bean implementation class Sender
 */
@Stateless
public class Sender implements SenderRemote{

	@Resource(mappedName = "jms/JMSConnectionFactoryJNDI")
    private ConnectionFactory connectionFactory;
 
    @Resource(mappedName = "jms/donhangqueueJNDI")
    Queue queue;
   
    Jsonb jsonb = JsonbBuilder.create();
    /**
     * Default constructor. 
     */
    public Sender() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void sendMessage(DonHang dh) {
		MessageProducer messageProducer;
        ObjectMessage textMessage;
        try {
        	System.out.println("bat dau gui du lieu len queue");
        	//String donHang = jsonb.toJson(dh);
        	System.out.println(dh.toString()); // no khong chay vao cho nay ???? di xacj pin ddi
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			messageProducer = session.createProducer(queue);
            textMessage = session.createObjectMessage();
            textMessage.setObject(dh);
            messageProducer.send(textMessage);
            messageProducer.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
