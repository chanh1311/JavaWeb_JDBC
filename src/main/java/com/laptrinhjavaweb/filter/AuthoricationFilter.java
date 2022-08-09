package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.KhachHangModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthoricationFilter implements Filter {
	@SuppressWarnings("unused")
	private ServletContext context;
	
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requestHttp = (HttpServletRequest)request;
		HttpServletResponse responseHttp = (HttpServletResponse)response;
		
		String url = requestHttp.getRequestURI();
		if(url.startsWith("/admin")) {
			KhachHangModel model = (KhachHangModel)SessionUtil.getInstance().getValue(requestHttp, "KHACHHANG_MODEL");
			if(model != null) {
				if(model.getChucVu().getTenChucVu().equals("ADMIN")) {
					chain.doFilter(request,response);
				}else if(model.getChucVu().getTenChucVu().equals("USER")){
					responseHttp.sendRedirect(requestHttp.getContextPath() + "/dang-nhap?action=login&message=not_permistion&alert=danger");
				}
			}else {
				responseHttp.sendRedirect(requestHttp.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		}else {
			chain.doFilter(request,response);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}
