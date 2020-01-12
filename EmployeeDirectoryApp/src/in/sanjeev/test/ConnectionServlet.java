package in.sanjeev.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConnectionServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//define the fields
		String username = "root";
		String password = "mysqlroot";
		String jdbcURL = "jdbc:mysql://localhost:3306/employeedirectory";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			//Get the PrintWriter object
			PrintWriter writer = response.getWriter();
			writer.println("Connecting to database"+jdbcURL);
			
			//Load the Driver
			Class.forName(driver);
			
			
			//Get the connection
			Connection connection = DriverManager.getConnection(jdbcURL,username,password);
			writer.println("connection successful");
			
			//close the connection
			connection.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
