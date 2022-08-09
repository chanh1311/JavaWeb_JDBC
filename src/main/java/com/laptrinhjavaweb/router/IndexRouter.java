package com.laptrinhjavaweb.router;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.KhachHangModel;
import com.laptrinhjavaweb.service.IKhachHangService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

//@WebServlet(urlPatterns ={"/trangchu","/dang-nhap","/thoat"})

public class IndexRouter {
	public static void doGetIndex(HttpServletRequest rq,HttpServletResponse rp,String action)throws ServletException,IOException {
		if(action != null && action .equals("login")){
			ResourceBundle myResources = ResourceBundle.getBundle("message");
			String message = rq.getParameter("message");
			String alert = rq.getParameter("alert");
			if(message != null && alert != null) {
				rq.setAttribute("message", myResources.getString(message));
				rq.setAttribute("alert", alert);
			}
			RequestDispatcher rd = rq.getRequestDispatcher("/views/login.jsp");
			rd.forward(rq, rp);
						
		}else if(action != null && action .equals("logout")){
			
			SessionUtil.getInstance().removeValue(rq, "KHACHHANG_MODEL");
			rp.sendRedirect(rq.getContextPath() + "/trangchu");
	
		}else {
			RequestDispatcher rd = rq.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(rq, rp);
		}
	}
	
	public static void doPostIndex(HttpServletRequest rq,HttpServletResponse rp,IKhachHangService khachHangService,String action)throws ServletException,IOException {
		
	if(action != null && action.equals("login")) {
			
			KhachHangModel model = FormUtil.toModel(KhachHangModel.class, rq);
			model = khachHangService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getMatKhau(), 1);
			if(model != null) {
				
				SessionUtil.getInstance().putValue(rq, "KHACHHANG_MODEL", model);
				
				if(model.getChucVu().getTenChucVu().equals("ADMIN")) {
					rp.sendRedirect(rq.getContextPath() + "/admin-home");
				}else if(model.getChucVu().getTenChucVu().equals("USER")){
					rp.sendRedirect(rq.getContextPath() + "/trangchu");
				}
				
			}else {
				rp.sendRedirect(rq.getContextPath() + "/dang-nhap?action=login&message=message_login_faild&alert=danger");
			}
		}
	}
	
}

