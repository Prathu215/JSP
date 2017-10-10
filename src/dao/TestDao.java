package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestDao {
	private static final String query = "SELECT value from testtable where id = 1";
	static String dbUrl = "jdbc:mysql://localhost:3305/prathyusha";
    static String userName = "prathu";
    static String password = "prathu";

	public static String getValueById(int id){
		String response = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(dbUrl,userName,password) ;
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				response = resultSet.getString(1);
				System.out.println("line is"+response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return response;
	}
	
	/*public static void main(String[] args) {
		System.out.println(getValueById(1));
	}*/
	
	
}
