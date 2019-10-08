package com.gemptc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.entity.Category;
import com.gemptc.entity.PageBean;
import com.gemptc.service.CategoryService;
import com.gemptc.service.ProductService;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_id = request.getParameter("cateid");
		String searchName = request.getParameter("searchName");
		List<Category> categories = categoryService.selectAllCategory();
		String currentCount = request.getParameter("currentCount");
		if(currentCount==null||"".equals(currentCount)) {
			currentCount="5";  //如果不设置默认是每页10条数据
		}
		//设置默认的页面  当前是第几页
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null || "".equals(currentPage)) {
			currentPage = "1";  //默认请求第1页的数据
		}
		//查PageBean的数据
		if(c_id != null && !c_id.trim().equals("") && searchName != null && !searchName.trim().equals("")) {
			PageBean page = productService.findPageBeanByName(searchName,c_id,currentPage,currentCount);
			if(page.getList()!=null && page.getList().size()>0) {
				//计算分页的数据显示
				List<Integer> pageValue = getPageValue(page.getTotalPage(),page.getCurrentPage());
				System.out.println(pageValue);
				page.setPageValue(pageValue);
				request.setAttribute("pageBean", page);
				request.setAttribute("cates", categories); 
				request.setAttribute("currentcid", c_id);
				request.setAttribute("searchName", searchName);
				request.getRequestDispatcher("searchProduct.jsp").forward(request, response); 
			}else {
				request.setAttribute("errorInfo", "没有商品数据信息或者查询发生错误");
				request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
			}
		}
	}
	public List<Integer> getPageValue(int pageCount, int pageNo) {
		List<Integer> pageList = new ArrayList<>();
		int pageSize = 6;
		int start = 0; 
		int end = 0;
		if (pageNo < pageSize) {
			start = 1;
			end = pageSize;
		} else {
			start = pageNo - 2;
			end = pageNo + 2;
		}
		if (end > pageCount) {
			end = pageCount;
		}		
		if (start > 1) {
			pageList.add(1);
			pageList.add(-1);
		}
		for (int i = start; i <= end; i++) {
			pageList.add(i);
		}			
		if (end < pageCount) {
			if (end != pageCount - 1) {
				pageList.add(-1);
			}
			pageList.add(pageCount);	
		}
		return pageList;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
