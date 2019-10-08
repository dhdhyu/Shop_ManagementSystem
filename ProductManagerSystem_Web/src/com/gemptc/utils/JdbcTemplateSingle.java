package com.gemptc.utils;

import org.springframework.jdbc.core.JdbcTemplate;


public class JdbcTemplateSingle {
	private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDateSource());
	public static JdbcTemplate getTemplate() {
		return template;
	}
}
