package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface {
	

	public OrdersDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> findAll() {
		
		System.out.println("---->Entering OrdersDataService.findAll()...");
		
		List<Order> orders = new ArrayList<Order>(); 


		//create a Connection as a local variable 
		Connection conn = null;

		// db url & login credentials needed to create the connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		// sql query to the db
		String sql = "SELECT * FROM testapp.ORDERS";

		try {
			// connect to the db
			conn = DriverManager.getConnection(url, username, password);

			// output if connection was successful
			System.out.println("The connection in findAll() was success!");

			// create the connection statement
			Statement stmt = conn.createStatement();

			// execute sql query
			ResultSet rs = stmt.executeQuery(sql);

			// use a while loop to go through the result set
			while (rs.next()) {

				// add each row in the result set as a new order
				orders.add(new Order(rs.getInt("ID"), rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"),
						rs.getInt("QUANTITY")));

			}

			// close the connection
			conn.close();
			System.out.println("Connection was closed in OrdersDataService.findAll()");



		} catch (SQLException e) {
			// output if connection was successful
			System.out.println("The connection in findAll() failed!");

			e.printStackTrace();
		}
		
		System.out.println("---->Leaving OrdersDataService.findAll()...");

		//return the orders list 
		return orders; 
	}

	@Override
	public Order findById(int id) {
		System.out.println("---->Entering OrdersDataService.findById()...");
		
		Order order = new Order(id, "", "", 0, 0); 
		
		//create a Connection as a local variable 
		Connection conn = null;

		// db url & login credentials needed to create the connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		// sql query to the db
		String sql = "SELECT * FROM testapp.ORDERS WHERE ID = ?";

		try {
			// connect to the db
			conn = DriverManager.getConnection(url, username, password);

			// output if connection was successful
			System.out.println("The connection in findById() was success!");

			// create the connection statement
			PreparedStatement stmt = conn.prepareStatement(sql); 
			
			//bind parameters
			stmt.setInt(1,id);
		
			// execute sql query
			ResultSet rs = stmt.executeQuery(); 

			// use a while loop to go through the result set
			while(rs.next()) {
				order = (new Order(rs.getInt("ID"), rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY")));
			}

			// close the connection
			conn.close();
			System.out.println("Connection was closed in OrdersDataService.findById()");



		} catch (SQLException e) {
			// output if connection was successful
			System.out.println("The connection in findById() failed!");

			e.printStackTrace();
		}
		
		System.out.println("---->Leaving OrdersDataService.findById()...");

		//return the orders list 
		return order; 
	}

	@Override
	public void create(Order order) {

		// create a Connection as a local variable
		Connection conn = null;

		// db url & login credentials needed to create the connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		// sql query to the db
		String sql = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";

		try {
			// connect to the db
			conn = DriverManager.getConnection(url, username, password);

			// output if connection was successful
			System.out.println("The connection in create() was success!");

			// create the connection statement
			PreparedStatement stmt = conn.prepareStatement(sql); 
						
			//bind parameters
			stmt.setString(1, order.getOrderNumber());
			stmt.setString(2, order.getProductName());
			stmt.setFloat(3, order.getPrice());
			stmt.setInt(4, order.getQuantity());
					
			// execute sql query
			//ResultSet rs = stmt.executeQuery(); 
			if (stmt.executeUpdate() == 1) {
				System.out.println("Success! A new row was inserted in create()!");
			}
			else { 
				System.out.println("Failure! A new row failed to be inserted in create()!");
			}
			
			// close the connection
			conn.close();

		} catch (SQLException e) {
			// output if connection was successful
			System.out.println("The connection in create() failed!");

			e.printStackTrace();
		}

	}

	@Override
	public void update(Order order) {
		// create a Connection as a local variable
		Connection conn = null;

		// db url & login credentials needed to create the connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		// sql query to the db
		String sql = "UPDATE testapp.orders SET ORDER_NO = ?, PRODUCT_NAME = ?, PRICE = ?, QUANTITY = ? WHERE id = ?";

		try {
			// connect to the db
			conn = DriverManager.getConnection(url, username, password);

			// output if connection was successful
			System.out.println("The connection in create() was success!");

			// create the connection statement
			PreparedStatement stmt = conn.prepareStatement(sql);

			// bind parameters
			stmt.setString(1, order.getOrderNumber());
			stmt.setString(2, order.getProductName());
			stmt.setFloat(3, order.getPrice());
			stmt.setInt(4, order.getQuantity());
			stmt.setInt(5, order.getID());

			// execute sql query
			if (stmt.executeUpdate() == 1) {
				System.out.println("Success! The row was updated in update()!");
			} else {
				System.out.println("Failure! The row failed to be updated in update()!");
			}

			// close the connection
			conn.close();

		} catch (SQLException e) {
			// output if connection was successful
			System.out.println("The connection in create() failed!");

			e.printStackTrace();
		}

	}

	@Override
	public void delete(Order order) {
		// create a Connection as a local variable
		Connection conn = null;

		// db url & login credentials needed to create the connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		// sql query to the db
		String sql = "DELETE FROM testapp.orders WHERE id = ?";

		try {
			// connect to the db
			conn = DriverManager.getConnection(url, username, password);

			// output if connection was successful
			System.out.println("The connection in create() was success!");

			// create the connection statement
			PreparedStatement stmt = conn.prepareStatement(sql);

			// bind parameters
			stmt.setInt(1, order.getID());

			// execute sql query
			if (stmt.executeUpdate() == 1) {
				System.out.println("Success! The row was deleted in delete()!");
			} else {
				System.out.println("Failure! The row failed to be deleted in delete()!");
			}

			// close the connection
			conn.close();

		} catch (SQLException e) {
			// output if connection was successful
			System.out.println("The connection in create() failed!");

			e.printStackTrace();
		}

	}

}
