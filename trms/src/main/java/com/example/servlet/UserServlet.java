package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.obj.Employee;
import com.example.obj.TrForm;
import com.example.service.FormService;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UserServler
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside dopost");
		ObjectMapper om = new ObjectMapper();
		String userJson = request.getReader().readLine();
		System.out.println("userJSON: " + userJson);
		Employee user = om.readValue(userJson, Employee.class);
		//System.out.println("User: " +  form.getCost());
		UserService userservice=new UserService();
		//service.addForm(form);
		System.out.println(userservice.validateUser(user));
		//uServ.makeUser(user);
	}

}
