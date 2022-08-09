package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String data;

	public HttpUtil(String data) {
		this.setData(data);
	}

	public static HttpUtil of(BufferedReader buffer) {
		StringBuilder result = new StringBuilder();
		String line;
		try {
			while ((line = buffer.readLine()) != null) {
				result.append(line);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return new HttpUtil(result.toString());

	}
	// Tra ve mot Model bat ki, Nhan vao Class bat ki
	
	public <T> T toModel(Class<T> tclass){
		try {
			return new ObjectMapper().readValue(getData(),tclass);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
