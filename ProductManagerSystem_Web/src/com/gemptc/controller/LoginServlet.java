package com.gemptc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.entity.User;
import com.gemptc.service.UserService;
import com.gemptc.utils.MyMessageReturn;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService userService = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		if(userName != null && !userName.equals("")
		&& userPwd != null && !userPwd.equals("")) {			
			User u = new User(userName,userPwd);
			User result = null;
			if((result = userService.login(u)) != null) {
				if(result.getA_name().equals(u.getA_name()) && result.getA_pwd().equals(u.getA_pwd())) {					
					request.getSession().setAttribute("user", u);
					response.sendRedirect("index");
				}else {
					MyMessageReturn.returnJSPInfoPage("3", "loginUI", "用户名或密码错误", request, response);
				}
			}else {
				MyMessageReturn.returnJSPInfoPage("3", "loginUI", "用户不存在，请先注册", request, response);
			}
		}else {
			MyMessageReturn.returnJSPInfoPage("3", "loginUI", "用户名或密码为空", request, response);
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
