package com.gemptc.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyMessageReturn {
	
	public static void returnJSPInfoPage(String time,String location,String info,HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("time", time);
		request.setAttribute("location", location);
		request.setAttribute("info", info);
		try {
			request.getRequestDispatcher("/common/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
