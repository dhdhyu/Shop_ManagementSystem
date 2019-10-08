package com.gemptc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.entity.Product;
import com.gemptc.service.ProductService;
import com.gemptc.utils.MyMessageReturn;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService productService = new ProductService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_category_id = request.getParameter("c_id");
		if(p_name != null && !p_name.equals("") 
		&& p_price != null && !p_price.equals("")
		&& p_category_id != null && !p_category_id.equals("")) {			
			if(productService.insertNewProduct(new Product(p_name, Double.parseDouble(p_price), Integer.parseInt(p_category_id)))) {
				MyMessageReturn.returnJSPInfoPage("3", "showProductUI", "添加商品成功", request, response);
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "addProductUI", "添加商品失败，请检查服务器", request, response);
			}
		}else {
			MyMessageReturn.returnJSPInfoPage("3", "addProductUI", "参数错误，请重试", request, response);
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
