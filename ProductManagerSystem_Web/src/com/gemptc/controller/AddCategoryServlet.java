package com.gemptc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.service.CategoryService;
import com.gemptc.utils.MyMessageReturn;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryService categoryService = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String c_name = request.getParameter("c_name");
		System.out.println(c_name);
		if(c_name != null && !c_name.trim().equals("")) {
			if(categoryService.addCategory(c_name)) {
				MyMessageReturn.returnJSPInfoPage("3", "addCategory.jsp", "添加商品分类成功", request, response);
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "addCategory.jsp", "添加失败，请重试", request, response);
			}
		}else {
			MyMessageReturn.returnJSPInfoPage("3", "addCategory.jsp", "未接收到参数，请检查服务器", request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
