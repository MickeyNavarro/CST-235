package beans;

public class Order {
	// attributes 
	private String orderNumber = ""; 
	private String productName =""; 
	private float Price = 0; 
	private int quantity = 0;
	
	// non-default constructor
	public Order(String orderNumber, String productName, float price, int quantity) {
		super();
		this.orderNumber = orderNumber;
		this.productName = productName;
		Price = price;
		this.quantity = quantity;
	}
	
	// getters and setters
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
