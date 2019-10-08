package com.gemptc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
static DataSource dataSource= null;
	static {
		Properties prop = new Properties();
		try {
			ClassLoader loader = JDBCUtils.class.getClassLoader();
			prop.load(loader.getResourceAsStream("druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(prop);
		    //可以在代码初始化的时候 自动获取一个连接  这样连接池就自动初始化了 加速数据的连接
			dataSource.getConnection();
		}catch(Exception e) {
			System.out.println("文件加载失败");
		}
	}
	//dataSource 就是Connection的集合  多个Connection 都在里面
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static DataSource getDateSource() {
		return dataSource;
	}
	
	public static void release(ResultSet rs, Statement psmt,Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				//归还连接 不是真实的close
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
