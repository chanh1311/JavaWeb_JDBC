package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.router.IndexRouter;
import com.laptrinhjavaweb.service.IKhachHangService;




@WebServlet(urlPatterns ={"/trangchu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	private IKhachHangService khachHangService;
	
	protected void doGet(HttpServletRequest rq,HttpServletResponse rp) throws ServletException,IOException{
		String action = rq.getParameter("action");
		IndexRouter.doGetIndex(rq, rp, action);

		
	}
	
	protected void doPost(HttpServletRequest rq,HttpServletResponse rp) throws ServletException,IOException{
		String action = rq.getParameter("action");
		IndexRouter.doPostIndex(rq, rp, khachHangService, action);


	}
	
}