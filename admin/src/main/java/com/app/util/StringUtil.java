package com.app.util;

import java.util.UUID;

/**
 * string工具类
 * @author Administrator
 *
 */
public class StringUtil {

	public static String uuid(){
		UUID uu = UUID.randomUUID();
		return uu.toString();
	}
}
