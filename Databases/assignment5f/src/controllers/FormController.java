package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean 
@ViewScoped
public class FormController {
	
	@Inject 
	OrdersBusinessInterface service; 
	
	@EJB 
	MyTimerService timer; 
	
	public String onSubmit(User user) { 
		
		// call the test() method to ensure that the bean is being injected & that the ordersBusinessService class is being used
		service.test(); //should output to console
		
		// call the setTimer() method 
		timer.setTimer(10000);
		
		System.out.println("-------------->About to process service.getOrders() in FormController...");

		// call the getOrders() method to get all the orders from the db
		service.getOrders(); 
		
		System.out.println("-------------->Finished processing service.getOrders() in FormController...");

		
		// send the User managed bean to the TestResponse view 
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user); 
		return "TestResponse.xhtml"; 
	}
	
	public String onFlash(User user) { 
		
		// send the User managed bean to the TestResponse view 
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user); 
		return "TestResponse2.xhtml?faces-redirect=true"; 
	}
		
	
	public OrdersBusinessInterface getService() {
		return this.service; 

	}
	

	
}
