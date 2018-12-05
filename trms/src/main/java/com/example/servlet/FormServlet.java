package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.obj.TrForm;
import com.example.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FormServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside doget");
		
		response.getWriter().write("dd");
		
		System.out.println("after");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside dopost");
		ObjectMapper om = new ObjectMapper();
		String userJson = request.getReader().readLine();
		System.out.println("userJSON: " + userJson);
		TrForm form = om.readValue(userJson, TrForm.class);
		//System.out.println("User: " +  form.getCost());
		FormService service=new FormService();
		//service.addForm(form);
		service.addForm(form);
		//uServ.makeUser(user);
	}

}
