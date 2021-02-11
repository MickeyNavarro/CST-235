package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative 
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders; 
	
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
    	//initialize with fake data 
    	this.orders = new ArrayList<Order>(); 
		orders.add(new Order("1", "product1 from AnotherOrdersBusinessService", 1, 1)); 
		orders.add(new Order("2", "product2 from AnotherOrdersBusinessService", 2, 2)); 
		orders.add(new Order("3", "product3 from AnotherOrdersBusinessService", 3, 3)); 
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService!"); 
    }

    @Override
	public List<Order> getOrders() {
		return this.orders; 
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders; 
	}

}
