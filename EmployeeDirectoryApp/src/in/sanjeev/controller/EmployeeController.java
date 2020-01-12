package in.sanjeev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.sanjeev.dao.EmployeeDAO;
import in.sanjeev.dao.EmployeeDAOImpl;
import in.sanjeev.entity.Employee;

//@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Create Reference variable for Employee DAO
	EmployeeDAO employeeDAO = null;

//	RequestDispatcher 
	RequestDispatcher dispatcher = null;

	// Create a constructor and initialize employee DAO
	public EmployeeController() {
		employeeDAO = new EmployeeDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {
		case "LIST":
			listEmployee(request, response);
			break;
		case "EDIT":
			getSingleEmployee(request, response);
			break;
		case "DELETE":
			deleteEmployee(request, response);
			break;	
		default:
			listEmployee(request, response);
			break;
		}

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String department = request.getParameter("department");
		
		// Testing
//		System.out.println("ID:- "+ id); 
//		System.out.println("Name:- "+ name); 
//		System.out.println("dob:- "+ dob);
//		System.out.println("department:- "+ department);
		
		Employee e = new Employee();
		e.setName(name);
		e.setDob(dob);
		e.setDepartment(department);
		
		if(id.isEmpty() || id==null) {
			//save data
			if (employeeDAO.save(e)) {
				request.setAttribute("message", "Save Successfully");
			}			
		}else {
			//update data
			e.setId(Integer.parseInt(id));
			if (employeeDAO.update(e)) {
				request.setAttribute("message", "Update Successfully");
			}
		}
		
		
		listEmployee(request, response);
	}

	public void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call dao method to get list of employee
		List<Employee> list = employeeDAO.get();

		// Add the employee to request object
		request.setAttribute("list", list);

		// Get the request Dispatcher
		dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");

		// forward the request and response object
		dispatcher.forward(request, response);
	}

	private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Employee employee = employeeDAO.get(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		// Get the request Dispatcher
		dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");

		// forward the request and response object
		dispatcher.forward(request, response);
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		System.out.println("Employee Id:- "+ id);	
		if(employeeDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("message","Record Hashbeen Dleted");
		}
		listEmployee(request,response);
	}
	

}
