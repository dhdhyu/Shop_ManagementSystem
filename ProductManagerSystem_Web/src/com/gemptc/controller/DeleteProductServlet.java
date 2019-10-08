package com.gemptc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.service.ProductService;
import com.gemptc.utils.MyMessageReturn;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService productService = new ProductService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_id = request.getParameter("p_id");
		String c_id = request.getParameter("c_id");
		String currentPage = request.getParameter("page");
		if(c_id != null && !c_id.trim().equals("") && currentPage != null && !currentPage.trim().equals("")) {			
			if(p_id != null && !p_id.trim().equals("")) {
				if(productService.deleteProductById(p_id)){
					MyMessageReturn.returnJSPInfoPage("3", "showProductUI?cateid="+c_id+"&currentPage="+currentPage, "删除成功", request, response);
				}else {
					MyMessageReturn.returnJSPInfoPage("3", "showProductUI?cateid="+c_id+"&currentPage="+currentPage, "删除失败，请重试", request, response);
				}
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "showProductUI?cateid="+c_id+"&currentPage="+currentPage, "未获取到参数，请检查服务器", request, response);
			}
		}else {
			if(p_id != null && !p_id.trim().equals("")) {
				if(productService.deleteProductById(p_id)){
					MyMessageReturn.returnJSPInfoPage("3", "searchProductUI", "删除成功", request, response);
				}else {
					MyMessageReturn.returnJSPInfoPage("3", "searchProductUI", "删除失败，请重试", request, response);
				}
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "searchProductUI", "未获取到参数，请检查服务器", request, response);
			}
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
