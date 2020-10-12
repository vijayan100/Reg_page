package net.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.registration.dao.empdao;
import net.registration.model.emp;

/**
 * Servlet implementation class empservlet
 */
@WebServlet("/register")
public class empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private empdao Empdao = new empdao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/views/empregister.jsp");
		
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String firstName = request.getParameter("firstName");
	     String lastName= request.getParameter("lastName");
	     String username= request.getParameter("username");
	     String password= request.getParameter("password");
	     String address= request.getParameter("address");
	     String contact= request.getParameter("contact");
	     
	     emp Emp =new emp();
	     Emp.setFirstName(firstName);
	     Emp.setLastName(lastName);
	     Emp.setUsername(username);
	     Emp.setPassword(password);
	     Emp.setAddress(address);
	     Emp.setContact(contact);
	     
	     
		try {
			
			Empdao.registerEmployee(Emp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    		 
		
	RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/views/empdetails.jsp");
		
		dispatch.forward(request, response);
	}

}
