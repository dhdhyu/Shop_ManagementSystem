package com.gemptc.dao;

import java.util.List;

import com.gemptc.entity.Category;

public interface CategoryDao {

	List<Category> selectAllCategory();

	boolean addCategory(String c_name);

}
