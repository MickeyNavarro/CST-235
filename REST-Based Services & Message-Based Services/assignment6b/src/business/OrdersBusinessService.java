package business;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.DataAccessInterface;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative 
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	@Inject 
	DataAccessInterface service; 

	//List<Order> orders = new ArrayList<Order>(); 
	
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
    	/*//initialize with fake data 
    	this.orders = new ArrayList<Order>(); 
		orders.add(new Order("1", "product1 from OrdersBusinessService", 1, 1)); 
		orders.add(new Order("2", "product2 from OrdersBusinessService", 2, 2)); 
		orders.add(new Order("3", "product3 from OrdersBusinessService", 3, 3)); */
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        System.out.println("Hello from the OrdersBusinessService!"); 
    }

	@Override
	public List<Order> getOrders() {
		System.out.println("------->Processing OrdersBusinessService.getOrders()...");
		return service.findAll(); 
	}

	@Override
	public void setOrders(List<Order> orders) {
		//this.orders = orders; 
	}

	@Override
	public Order getOrdersById(int id) {
		return service.findById(id);
	}

	@Override
	public void createOrder(Order order) {
		service.create(order);	
	}

	@Override
	public void updateOrder(Order order) {
		service.update(order);
	}

	@Override
	public void deleteOrder(Order order) {
		service.delete(order);
	}

	@Override
	public void sendOrder(Order order) {
		// Send a Message for an Order
		try {
			Connection connection = connectionFactory.createConnection(); 
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			
			//message 1 
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			
			//message 2
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject((Serializable) order);
			messageProducer.send(message2);
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
