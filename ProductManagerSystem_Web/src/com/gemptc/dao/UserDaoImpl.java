package com.gemptc.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gemptc.entity.User;
import com.gemptc.utils.JdbcTemplateSingle;

public class UserDaoImpl implements UserDao {
	JdbcTemplate template = JdbcTemplateSingle.getTemplate();
	@Override
	public User login(User u) {
		String sql = "SELECT * FROM pms_admin WHERE a_name = ?";
		User result = null;
		try {
			result = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),u.getA_name());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
