package com.gemptc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gemptc.entity.Product;
import com.gemptc.utils.JdbcTemplateSingle;

public class ProductDaoImpl implements ProductDao {
	JdbcTemplate template = JdbcTemplateSingle.getTemplate();
	@Override
	public List<Product> searchProductByCid(String currentCid) {
		String sql = "SELECT * FROM pms_product WHERE p_category_id = ?";
		List<Product> list = new ArrayList<>();
		try {
			list = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class), currentCid);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Product> selectProductByPageAndCateId(String searchCateid, int index, int tempCount) {
		String sql = "SELECT * FROM pms_product WHERE p_category_id = ? LIMIT ?,?";
		List<Product> list = null;
		try {
			list = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class),searchCateid,index,tempCount);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询发生异常  查询不到商品");
		}
		return list;
	}
	@Override
	public int getAllCount(String searchCateid) {
		String sql = "SELECT count(*) FROM pms_product WHERE p_category_id=?";
		Integer count = 0;
		try {
			count = template.queryForObject(sql, Integer.class,searchCateid);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public Product searchProductById(String p_id) {
		String sql = "SELECT * FROM pms_product WHERE p_id = ?";
		Product result = null;
		try {
			result = template.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class),p_id);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean updateProduct(Product p) {
		String sql = "UPDATE pms_product SET p_name = ?,p_price = ?,p_category_id = ? WHERE p_id = ?";
		int result = template.update(sql, p.getP_name(),p.getP_price(),p.getP_category_id(),p.getP_id());
		return result > 0;
	}
	@Override
	public boolean insertNewProduct(Product p) {
		String sql = "INSERT INTO pms_product(p_id,p_name,p_price,p_category_id) VALUES(?,?,?,?)";
		int result = template.update(sql,p.getP_id(),p.getP_name(),p.getP_price(),p.getP_category_id());
		return result > 0;
	}
	@Override
	public boolean deleteProductById(String p_id) {
		String sql = "DELETE FROM pms_product WHERE p_id = ?";
		int result = template.update(sql, p_id);
		return result > 0;
	}
	@Override
	public List<Product> selectProductByPageAndCateIdAndName(String searchName, String c_id, int index, int tempCount) {
		String sql = "SELECT * FROM pms_product WHERE p_category_id = ? AND p_name LIKE ? LIMIT ?,?";
		List<Product> list = null;
		try {
			list = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class),c_id,"%"+searchName+"%",index,tempCount);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询发生异常  查询不到商品");
		}
		return list;
	}
	@Override
	public int getAllCountByName(String c_id, String searchName) {
		String sql = "SELECT count(*) FROM pms_product WHERE p_category_id=? AND p_name LIKE ?";
		Integer count = 0;
		try {
			count = template.queryForObject(sql, Integer.class,c_id,"%"+searchName+"%");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
