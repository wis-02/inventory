package inventory.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TitleManager {

	 private Connection connection;
	 
	 
	 public TitleManager() {
	        connection = Database.getConnection();
	    }
	 
	 public int getOccurencesforTitle(String title){
		 int counter=0;
		   try {
         //PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT( * ) AS counter from  comments where user = ?");
	     PreparedStatement preparedStatement = connection.prepareStatement("SELECT stock AS counter from  dvd where title = ?");
         preparedStatement.setString(1, title);
         ResultSet rs = preparedStatement.executeQuery();
         while (rs.next()) {
         		counter = Integer.parseInt(rs.getString("counter"));
         }
		   } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return counter;
	 }
	 public boolean reserveFromStock(UpdateStock update){
	        Boolean b=false;
	              
	        try {
	            System.out.println("update title  start");
	            //PreparedStatement preparedStatement = connection.prepareStatement("insert into comments(comment, user) values (?, ?)");
	            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE DVD SET STOCK = ? WHERE TITLE = ?");
	            // Parameters start with 1  UPDATE dvd SET stock = 5 WHERE title = 'Toy Story'	
	            preparedStatement.setInt(1, update.getQuantity());
	            preparedStatement.setString(2, update.getTitle());
	           
	          
	            preparedStatement.executeUpdate();
	             System.out.println("add preparedStatement end");
	             b=true;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("SQLException ");
	        }
	        
	        return b;
	    }
}
