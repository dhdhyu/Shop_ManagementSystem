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
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService productService = new ProductService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String p_id = request.getParameter("p_id");
		String p_name = request.getParameter("p_name");
		String p_price = request.getParameter("p_price");
		String p_category_id = request.getParameter("c_id");
		String currentCid = request.getParameter("currentCid");
		String currentPage = request.getParameter("page");
		System.out.println(currentCid);
		System.out.println(currentPage);
		if(currentCid != null && !currentCid.trim().equals("") && currentPage != null && !currentPage.trim().equals("")) {			
			if(p_id != null && !p_id.equals("") 
					&& p_name != null && !p_name.equals("")
					&& p_price != null && !p_price.equals("")
					&& p_category_id != null && !p_category_id.equals("")) {
				Product p = new Product(p_name,Double.parseDouble(p_price),Integer.parseInt(p_category_id));
				p.setP_id(Integer.parseInt(p_id));
				if(productService.updateProduct(p)) {
					MyMessageReturn.returnJSPInfoPage("3", "showProductUI?cateid="+currentCid+"&currentPage="+currentPage, "修改商品信息成功", request, response);
				}else {
					MyMessageReturn.returnJSPInfoPage("3", "editProductUI?cateid="+currentCid+"&currentPage="+currentPage, "修改商品信息失败", request, response);
				}
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "editProductUI?cateid="+currentCid+"&currentPage="+currentPage, "未接收到参数，请检查服务器", request, response);
			}
		}else {
			if(p_id != null && !p_id.equals("") 
					&& p_name != null && !p_name.equals("")
					&& p_price != null && !p_price.equals("")
					&& p_category_id != null && !p_category_id.equals("")) {
				Product p = new Product(p_name,Double.parseDouble(p_price),Integer.parseInt(p_category_id));
				p.setP_id(Integer.parseInt(p_id));
				if(productService.updateProduct(p)) {
					MyMessageReturn.returnJSPInfoPage("3", "searchProduct?cateid="+p_category_id+"&searchName="+p_name, "修改商品信息成功", request, response);
				}else {
					MyMessageReturn.returnJSPInfoPage("3", "searchProduct?cateid="+p_category_id+"&searchName="+p_name, "修改商品信息失败", request, response);
				}
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "searchProduct?cateid="+p_category_id+"&searchName="+p_name, "未接收到参数，请检查服务器", request, response);
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
