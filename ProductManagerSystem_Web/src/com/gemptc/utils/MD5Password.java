package com.gemptc.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Password {
	public static String privateKey = "dfsafafafrq4524246246254rtwrtw";
	public static String myMD5(String orginString) {
		orginString = orginString + privateKey;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(orginString.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
