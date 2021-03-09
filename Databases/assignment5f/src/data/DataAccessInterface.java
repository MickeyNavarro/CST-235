package data;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local 
public interface DataAccessInterface {
	public List<Order> findAll(); 
}
