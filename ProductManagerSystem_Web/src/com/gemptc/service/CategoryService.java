package com.gemptc.service;

import java.util.List;

import com.gemptc.dao.CategoryDao;
import com.gemptc.dao.CategoryDaoImpl;
import com.gemptc.entity.Category;

public class CategoryService {
	CategoryDao cdao = new CategoryDaoImpl();
	public List<Category> selectAllCategory() {
		return cdao.selectAllCategory();
	}
	public boolean addCategory(String c_name) {
		// TODO Auto-generated method stub
		return cdao.addCategory(c_name);
	}

}
