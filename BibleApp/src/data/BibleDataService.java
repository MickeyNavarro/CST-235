//Almicke Navarro 
//CST-235 
//April 11, 2021
//I used the following source code from https://github.com/MickeyNavarro/CST-235 
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Bible;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class BibleDataService implements DataAccessInterface{
	
	//default constructor
	public BibleDataService() {}
	
	//method to find full verse from database
	public Bible findFullVerse(String bookName, int chapterNo, int verseNo) {
		System.out.println("---->Entering BibleDataService.findFullVerse()...");
		
		Bible bible = new Bible(); 
		
		//create a Connection as a local variable 
		Connection conn = null;

		// db url & login credentials needed to create the connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";

		// sql query to the db
		String sql = "SELECT * FROM bible.VERSES WHERE bookname = ? AND chapter_no = ? AND verse_no = ?";		
		
		try {
			// connect to the db
			conn = DriverManager.getConnection(url, username, password);

			// output if connection was successful
			System.out.println("The connection in findFullVerse() was success!");

			// create the connection statement
			PreparedStatement stmt = conn.prepareStatement(sql); 
			
			//bind parameters
			stmt.setString(1, bookName);
			stmt.setInt(2, chapterNo);
			stmt.setInt(3, verseNo);
		
			// execute sql query
			ResultSet rs = stmt.executeQuery();

			// use a while loop to go through the result set
			while(rs.next()) {
					bible = new Bible(rs.getString("bookname"), rs.getInt("chapter_no"), rs.getInt("verse_no"), rs.getString("full_verse"));
			}
			
			// close the connection
			conn.close();
			System.out.println("Connection was closed in BibleDataService.findFullVerse()");
		}
		catch (SQLException e) {
			
			// output if connection was successful
			System.out.println("The connection in findFullVerse() failed!");
			
			e.printStackTrace();
		}
				
		System.out.println("---->Leaving BibleDataService.findFullVerse()...");

		//return the bible object 
		return bible;
	}
}