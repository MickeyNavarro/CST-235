package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative 
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService!"); 
    }

}
