package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.HangHoaModel;
import com.laptrinhjavaweb.service.impl.HangHoaService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(value = "/api-admin-test")
public class NewApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private HangHoaService hangHoaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// Set thuoc tinh
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// Nhan du lieu tu client, mapper vao model duoc tao
		HangHoaModel hangHoaModel = HttpUtil.of(request.getReader()).toModel(HangHoaModel.class);
		// Luu Data vao Database
		hangHoaModel = hangHoaService.save(hangHoaModel);
//		// Tra ve Json
		mapper.writeValue(response.getOutputStream(), hangHoaModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// Set thuoc tinh
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// Nhan du lieu tu client, mapper vao Model
		HangHoaModel hangHoaModel = HttpUtil.of(request.getReader()).toModel(HangHoaModel.class);
		// Luu Data vao Database
		hangHoaModel = hangHoaService.update(hangHoaModel);

		// Tra ve Json
		mapper.writeValue(response.getOutputStream(), hangHoaModel);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// Set thuoc tinh
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		// Nhan du lieu tu client, mapper vao Model
		HangHoaModel hangHoaModel = HttpUtil.of(request.getReader()).toModel(HangHoaModel.class);
		
		// xu li 
		hangHoaService.delete(hangHoaModel.getIds());
		
		// Tra ve Json
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
