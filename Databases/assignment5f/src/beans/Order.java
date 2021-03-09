package beans;

public class Order {
	// attributes 
	private int ID = 0; 
	private String orderNumber = ""; 
	private String productName =""; 
	private float Price = 0; 
	private int quantity = 0;
	
	// non-default constructor
	public Order(int ID, String orderNumber, String productName, float price, int quantity) {
		super();
		this.ID = ID;
		this.orderNumber = orderNumber;
		this.productName = productName;
		Price = price;
		this.quantity = quantity;
	}
	
	// getters and setters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
