package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.OrdersBusinessInterface;

@ManagedBean 
@ViewScoped
public class FormController {
	
	//EJB
	@Inject 
	OrdersBusinessInterface service; 
	
	public String onSubmit(User user) { 
		
		// call the test() method to ensure that the bean is being injected & that the ordersBusinessService class is being used
		service.test(); //should output to console
		
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
