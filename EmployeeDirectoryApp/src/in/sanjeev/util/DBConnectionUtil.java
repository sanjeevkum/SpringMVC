package in.sanjeev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	//Defining the Database property
	private static final String URL = "jdbc:mysql://localhost:3306/employeedirectory";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysqlroot";
	private static Connection connection = null;
	
	//Define the Static Method
	public static Connection openConnection(){
		//Check The Connection
		if(connection!=null) {
			return connection;
		}else {
			try {
				//Load the Driver
				Class.forName(DRIVER);
				//Get the Connection 
				connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); 
				
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			//return Connection
			return connection;
		}
		
	}
	
}
