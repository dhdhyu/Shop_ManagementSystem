package com.gemptc.dao;

import java.util.List;

import com.gemptc.entity.Product;

public interface ProductDao {

	List<Product> searchProductByCid(String currentCid);

	List<Product> selectProductByPageAndCateId(String searchCateid, int index, int tempCount);

	int getAllCount(String searchCateid);

	Product searchProductById(String p_id);

	boolean updateProduct(Product p);

	boolean insertNewProduct(Product product);

	boolean deleteProductById(String p_id);

	List<Product> selectProductByPageAndCateIdAndName(String searchName, String c_id, int index, int tempCount);

	int getAllCountByName(String c_id, String searchName);

}
