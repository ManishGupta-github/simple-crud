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


@WebServlet("/addInquiry")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inquiry.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null)
			{
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String mobile=request.getParameter("mobile");
				DAOServiceImpl service=new DAOServiceImpl();
				service.connectDB();
				service.addController(name, email, mobile);
				request.setAttribute("message", "saved!!");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inquiry.jsp");
				rd.forward(request, response);
			}else {
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
					}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Session time out..Login again");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
			
	}
		
		
	
	}


