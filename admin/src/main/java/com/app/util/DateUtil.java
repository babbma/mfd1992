/**
 * 
 */
package com.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chenmeng
 * 2015-11-10
 */
public class DateUtil {
	
	public String currentTimeString(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		return sdf.format(date);
	}
	/**
	 * 时间戳转换为Date
	 * */
	public Date toDate(long timestamp){
		Date date=new Date(timestamp);
		return date;
	} 
	/**
	 * 时间戳转换为String
	 * */
	public String toDateString(long timestamp){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Date date=new Date(timestamp);
		return sdf.format(timestamp);
	} 
	
	/**
	 * 时间戳转换为String
	 * */
	public static String toDateString(long timestamp,String formatter){
		SimpleDateFormat sdf=new SimpleDateFormat(formatter);
		//Date date=new Date(timestamp);
		return sdf.format(timestamp);
	} 
	/**
	 * date转换为时间戳long
	 * */
	public Long toLong(Date date){
		return date.getTime();
	}
	/**
	 * String转换为时间戳long
	 * @throws ParseException 
	 * */
	public static Long toLong(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(dateStr);
		return date.getTime();
	}
	
	public static void main(String args[]){
		try {
			
			Calendar calc = Calendar.getInstance();
			calc.setTime(new Date());
			calc.set(Calendar.HOUR_OF_DAY,0);
			calc.set(Calendar.MINUTE,0);
			calc.set(Calendar.SECOND,0);
			calc.set(Calendar.MILLISECOND,0);
			System.out.println(toDateString(calc.getTimeInMillis(),"yyyy-MM-dd HH:mm:ss"));
			
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			
//			System.out.println(sdf.format(1447257600000L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
