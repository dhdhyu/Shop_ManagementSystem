package com.gemptc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.entity.Category;
import com.gemptc.entity.Product;
import com.gemptc.service.CategoryService;
import com.gemptc.service.ProductService;
import com.gemptc.utils.MyMessageReturn;

/**
 * Servlet implementation class EditProductUIServlet
 */
@WebServlet("/editProductUI")
public class EditProductUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_id = request.getParameter("p_id");
		String currentCid = request.getParameter("currentCid");
		String currentPage = request.getParameter("page");
		List<Category> categories = categoryService.selectAllCategory();
		request.setAttribute("cates", categories);
		if(p_id != null && !p_id.equals("")) {
			Product p = null;
			if((p = productService.searchProductById(p_id)) != null) {
				request.setAttribute("p", p);
				request.setAttribute("currentCid", currentCid);
				request.setAttribute("page", currentPage);
				request.getRequestDispatcher("editProduct.jsp").forward(request, response);
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "showProductUI", "未找到对应商品", request, response);
			}
		}else {
			MyMessageReturn.returnJSPInfoPage("3", "showProductUI", "参数不存在，请重试", request, response);
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
