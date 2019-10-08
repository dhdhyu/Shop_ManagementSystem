package com.gemptc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gemptc.entity.Category;
import com.gemptc.utils.JdbcTemplateSingle;

public class CategoryDaoImpl implements CategoryDao {
	JdbcTemplate template = JdbcTemplateSingle.getTemplate();
	@Override
	public List<Category> selectAllCategory() {
		String sql = "SELECT * FROM pms_category";
		List<Category> list = new ArrayList<>();
		try {
			list = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean addCategory(String c_name) {
		String sql = "INSERT INTO pms_category VALUES(?,?)";
		int result = template.update(sql, 0,c_name);
		return result > 0;
	}

}
