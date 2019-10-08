package com.gemptc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.entity.Category;
import com.gemptc.service.CategoryService;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProductUI")
public class AddProductUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService categoryService = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryService.selectAllCategory();
		request.setAttribute("cates", categories);
		request.setAttribute("currentCid", 1);
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
