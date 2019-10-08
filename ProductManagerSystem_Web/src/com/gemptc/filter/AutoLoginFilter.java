package com.gemptc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gemptc.utils.MyMessageReturn;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code her
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		System.out.println("AutoLogin:"+req.getServletPath());
		//chain 链子    doFilter 放行 继续后面的请求 
		String currentPath = req.getServletPath();
		//System.out.println("user:"+req.getSession().getAttribute("user"));
		//放行公众资源
		if(currentPath.startsWith("/login")||currentPath.startsWith("/assets/")||currentPath.startsWith("/gt/")) {
			//继续后面的代码
			chain.doFilter(request, response);
		}else {
			if(req.getSession().getAttribute("user")!=null) {
				//用户登录了就放行 
				chain.doFilter(request, response);
			}else {
				//自己转发到错误的页面
				MyMessageReturn.returnJSPInfoPage("3", "loginUI", "用户未登录请先登录", req, res);	
			}
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
