package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// update maven project
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.HangHoaModel;
import com.laptrinhjavaweb.pagging.PageRequest;
import com.laptrinhjavaweb.pagging.Pageable;
import com.laptrinhjavaweb.service.impl.HangHoaService;
import com.laptrinhjavaweb.service.impl.LoaiHangHoaService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;


@WebServlet(value = "/admin-products")
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	HangHoaService hangHoaService;
	
	@Inject
	LoaiHangHoaService loaiHangHoaService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		
		HangHoaModel model = FormUtil.toModel(HangHoaModel.class, rq);
		if(model.getType().equals("list")) {
			// set parameter
			Pageable pageAble = new PageRequest(model.getPage(),model.getMaxPageItems(),new Sorter(model.getSortBy(),model.getSortName()));
			
			model.setResultList(hangHoaService.findAll(pageAble));
			model.setTotalItems(hangHoaService.getToTalItems());
			model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));
			
			
			ResourceBundle myResources = ResourceBundle.getBundle("message");
			String message = rq.getParameter("message");
			String alert = rq.getParameter("alert");
			
			if(message != null && alert != null) {
				rq.setAttribute("message", myResources.getString(message));
				rq.setAttribute("alert", alert);
			}
			
			
			
			rq.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd = rq.getRequestDispatcher("/views/admin/products/list.jsp");
			rd.forward(rq, rp);
			
		}else if(model.getType().equals("edit")) {
			rq.setAttribute("LoaiHangHoa", loaiHangHoaService.findAll());
			
			if(model.getMshh() != 0l) {
				model = hangHoaService.findOne(model.getMshh());
				rq.setAttribute(SystemConstant.MODEL, model);
				
				RequestDispatcher rd = rq.getRequestDispatcher("/views/admin/products/edit.jsp");
				rd.forward(rq, rp);
			}else {
				RequestDispatcher rd = rq.getRequestDispatcher("/views/admin/products/edit.jsp");
				rd.forward(rq, rp);
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {

	}

}
