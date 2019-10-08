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
 * Servlet implementation class SearchProductUIServlet
 */
@WebServlet("/searchProductUI")
public class SearchProductUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryService categoryService = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_id = request.getParameter("cateid");
		String currentCid = null;
		if(c_id != null) {
			currentCid = c_id;
		}else {
			currentCid = "1";
		}
		List<Category> categories = categoryService.selectAllCategory();
		request.setAttribute("currentCid", currentCid);
		request.setAttribute("cates", categories);
		request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
