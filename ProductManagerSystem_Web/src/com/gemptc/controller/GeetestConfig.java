package com.gemptc.controller;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	//填写自己的key和id 可以知道我的网站被验证了多少次
	private static final String geetest_id = "48a6ebac4ebc6642d68c217fca33eb4d";
	private static final String geetest_key = "4f1c085290bec5afdc54df73535fc361";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}
	
	public static final boolean isnewfailback() {
		return newfailback;
	}

}
