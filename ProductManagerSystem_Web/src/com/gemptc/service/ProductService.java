package com.gemptc.service;

import java.util.List;

import com.gemptc.entity.PageBean;
import com.gemptc.dao.ProductDao;
import com.gemptc.dao.ProductDaoImpl;
import com.gemptc.entity.Product;

public class ProductService {
	ProductDao pdao = new ProductDaoImpl();
	public List<Product> searchProductByCid(String currentCid) {
		return pdao.searchProductByCid(currentCid);
	}
	public PageBean findPageBean(String searchCateid, String currentPage, String currentCount) {
		PageBean pageBean = new PageBean();
		//每页10条数据
		int tempCount = Integer.parseInt(currentCount);
		pageBean.setCurrentCount(tempCount);
		//当前第几页
		int tempPage = Integer.parseInt(currentPage);
		pageBean.setCurrentPage(tempPage);
	    //总的商品条数
		int totalCount = pdao.getAllCount(searchCateid);
		pageBean.setTotalCount(totalCount);
		//总的分页数量
		pageBean.setTotalPage((int)Math.ceil(1.0*totalCount/tempCount));
		//查询数据库的信息
		//索引
		int index = (tempPage-1)*tempCount;
		List<Product> list = pdao.selectProductByPageAndCateId(searchCateid,index,tempCount);
		pageBean.setList(list);	
		
		return pageBean;
	}
	public boolean insertNewProduct(Product product) {
		return pdao.insertNewProduct(product);
	}
	public Product searchProductById(String p_id) {
		return pdao.searchProductById(p_id);
	}
	public boolean updateProduct(Product p) {
		return pdao.updateProduct(p);
	}
	public boolean deleteProductById(String p_id) {
		return pdao.deleteProductById(p_id);
	}
	public PageBean findPageBeanByName(String searchName, String c_id, String currentPage, String currentCount) {
		PageBean pageBean = new PageBean();
		//每页10条数据
		int tempCount = Integer.parseInt(currentCount);
		pageBean.setCurrentCount(tempCount);
		//当前第几页
		int tempPage = Integer.parseInt(currentPage);
		pageBean.setCurrentPage(tempPage);
	    //总的商品条数
		int totalCount = pdao.getAllCountByName(c_id,searchName);
		pageBean.setTotalCount(totalCount);
		//总的分页数量
		pageBean.setTotalPage((int)Math.ceil(1.0*totalCount/tempCount));
		//查询数据库的信息
		//索引
		int index = (tempPage-1)*tempCount;
		List<Product> list = pdao.selectProductByPageAndCateIdAndName(searchName,c_id,index,tempCount);
		pageBean.setList(list);	
		
		return pageBean;
	}

}
