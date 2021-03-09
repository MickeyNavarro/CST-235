package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean 
@ViewScoped
public class Orders {
	private List<Order> listOfOrders;

	public Orders() {
		/*this.listOfOrders = new ArrayList<Order>(); 
		listOfOrders.add(new Order("1", "product1", 1, 1)); 
		listOfOrders.add(new Order("2", "product2", 2, 2)); 
		listOfOrders.add(new Order("3", "product3", 3, 3)); 
		*/

	}

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	} 
	
	
}
