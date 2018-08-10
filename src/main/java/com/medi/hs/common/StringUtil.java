package com.medi.hs.common;

public class StringUtil {

	public static String replaceOfIndex(int index, String str, String replacement) {
		
		StringBuilder replaceStr = new StringBuilder(str);
		replaceStr.setCharAt(index, '*');
		return replaceStr.toString();
	}
}
