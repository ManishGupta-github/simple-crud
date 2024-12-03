package com.studentapp18.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.studentapp18.model.DAOServiceImpl;


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
	String password=request.getParameter("password");
	DAOServiceImpl service=new DAOServiceImpl();
	service.connectDB();
	boolean status=service.verifylogin(email, password);
	if(status)
	{
		HttpSession session = request.getSession(true);
		session.setAttribute("email",email );
		session.setMaxInactiveInterval(10);
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inquiry.jsp");
		rd.forward(request, response);
	}
	else
	{
		request.setAttribute("errorMessage", "Invalid Credential");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	
	
	}
}
