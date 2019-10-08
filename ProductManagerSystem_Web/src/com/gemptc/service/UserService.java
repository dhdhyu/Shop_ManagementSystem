package com.gemptc.service;

import com.gemptc.dao.UserDao;
import com.gemptc.dao.UserDaoImpl;
import com.gemptc.entity.User;

public class UserService {
	UserDao udao = new UserDaoImpl();
	public User login(User u) {
		return udao.login(u);
	}

}
