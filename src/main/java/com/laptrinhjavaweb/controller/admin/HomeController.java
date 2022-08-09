package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.service.IKhachHangService;



@WebServlet(value = "/admin-home")
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest rq,HttpServletResponse rp) throws ServletException,IOException{
		
		
		RequestDispatcher rd = rq.getRequestDispatcher("/views/admin/admin-home.jsp");
		rd.forward(rq, rp);
	}
	protected void doPost(HttpServletRequest rq,HttpServletResponse rp) throws ServletException,IOException{
		
	}
}


