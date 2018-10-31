package com.dl.common.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * 日期工具类
 * @author Levi.Liu
 */
public class DateUtils {
	
	/**
	 * 后去两个时间之间间隔的小时列表
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static List<String> betweenHourList(Date beginDate,Date endDate){
		List<String> hourList = new ArrayList<>();
		Calendar start = dateToCalendar(beginDate);
		String endStr = formatDate(endDate, DateFormat.FORMAT_yyyyMMddHH);
		String beginStr = "";
		do{
			beginStr = formatDate(calendarToData(start), DateFormat.FORMAT_yyyyMMddHH);
			hourList.add(beginStr);
			start.add(Calendar.HOUR_OF_DAY, 1);
		}while(!beginStr.equals(endStr));
		return 	hourList;
	}
	
	/**
	 * 返回当前时间指定的日期格式
	 * @param pattern
	 * @return
	 */
	public static String getNow(String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}
	
	public static String formatDate(Date date,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	
	/**
	 * Calendar转Date
	 * @param calendar
	 * @return
	 */
	public static Date calendarToData(Calendar calendar) {
        Date date = calendar.getTime(); // 从一个 Calendar 对象中获取 Date 对象
        return date;
    }
	
	/**
	 * Date转Calendar
	 * @param date
	 * @return
	 */
	public static Calendar dateToCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static Date strToDate(String dateStr,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Date beginDate = strToDate("20180917000000",DateFormat.FORMAT_YYYYMMDDHHMMSS);
		Date endDate = strToDate("20180919232756",DateFormat.FORMAT_YYYYMMDDHHMMSS);
		System.out.println(JSONUtils.toJSONString(betweenHourList(beginDate, endDate)));
	}
}
