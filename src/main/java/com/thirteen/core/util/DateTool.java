package com.thirteen.core.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类 
 * 提供一些常用的日期时间操作方法，所有方法都为静态，不用实例化该类即可使用。
 *
 * 
 */

public class DateTool {

    /**
     * 缺省的日期显示格式： yyyyMMdd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 缺省的日期时间显示格式：yyyyMMdd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 私有构造方法，禁止对该类进行实例化
     */
    private DateTool() {
    }

    /**
     * 得到系统当前日期时间
     * 
     * @return 当前日期时间
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 得到用缺省方式格式化的当前日期
     * 
     * @return 当前日期
     */
    public static String getDate() {
        return getDateTime(DEFAULT_DATE_FORMAT);
    }

    /**
     * 得到用缺省方式格式化的当前日期及时间
     * 
     * @return 当前日期及时间
     */
    public static String getDateTime() {
        return getDateTime(DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 得到系统当前日期及时间，并用指定的方式格式化
     * 
     * @param pattern 显示格式
     * @return 当前日期及时间
     */
    public static String getDateTime(String pattern) {
        Date datetime = Calendar.getInstance().getTime();
        return getDateTime(datetime, pattern);
    }
    

    /**
     * 得到用指定方式格式化的日期
     * 
     * @param date 需要进行格式化的日期
     * @param pattern 显示格式
     * @return 日期时间字符串
     */
    public static String getDateTime(Date date, String pattern) {
        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 得到当前年份
     * 
     * @return 当前年份
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
        
    }

    /**
     * 得到当前月份
     * 
     * @return 当前月份
     */
    public static int getCurrentMonth() {
        //用get得到的月份数比实际的小1，需要加上
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * 得到当前日
     * 
     * @return 当前日
     */
    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /**
     * 取得当前日期以后若干天的日期。如果要得到以前的日期，参数用负数。 例如要得到上星期同一天的日期，参数则为-7
     * 
     * @param days 增加的日期数
     * @return 增加以后的日期
     */
    public static Date addDays(int days) {
        return add(getNow(), days, Calendar.DATE);
    }

    /**
     * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
     * 
     * @param date 基准日期
     * @param days 增加的日期数
     * @return 增加以后的日期
     */
    public static Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }

    /**
     * 取得当前日期以后某月的日期。如果要得到以前月份的日期，参数用负数。
     * 
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(int months) {
        return add(getNow(), months, Calendar.MONTH);
    }

    /**
     * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
     * 
     * @param date 基准日期
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(Date date, int months) {
        return add(date, months, Calendar.MONTH);
    }

    /**
     * 内部方法。为指定日期增加相应的天数或月数
     * 
     * @param date 基准日期
     * @param amount 增加的数量
     * @param field 增加的单位，年，月或者日
     * @return 增加以后的日期
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(field, amount);

        return calendar.getTime();
    }
    /**
     * 通过date对象取得格式为小时:分钟的实符串
     * @return
     */
    @SuppressWarnings("deprecation")
	public static String getHourMin(Date date){
         StringBuffer sf = new StringBuffer();
         sf.append(date.getHours());
         sf.append(":");
         sf.append(date.getMinutes());
         return sf.toString();
    }

    /**
     * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     * 
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffDays(Date one, Date two) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.clear();
        calendar.setTime(one);
        calendar.set(calendar.get(Calendar.YEAR),
        		calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date d1 = calendar.getTime();
        calendar.clear();
        calendar.setTime(two);
        calendar.set(calendar.get(Calendar.YEAR),
        		calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date d2 = calendar.getTime();
        BigDecimal r = new BigDecimal(
        		new Double((d1.getTime() - d2.getTime())) / (24 * 60 * 60 * 1000));
        return Math.round(r.doubleValue());
    }

    /**
     * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数
     * 
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差月份数
     */
    public static int diffMonths(Date one, Date two) {

        Calendar calendar = Calendar.getInstance();

        //得到第一个日期的年分和月份数
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        int monthOne = calendar.get(Calendar.MONDAY);
        //得到第二个日期的年份和月份
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);
        int monthTwo = calendar.get(Calendar.MONDAY);

        return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
    }
    
    /**
     * 获取某一个日期的年份
     * @param d
     * @return
     */
    public static int getYear(Date d) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 将一个字符串用给定的格式转换为日期类型。 <br>
     * 注意：如果返回null，则表示解析失败
     * 
     * @param datestr 需要解析的日期字符串
     * @param pattern 日期字符串的格式，默认为“yyyy-MM-dd”的形式
     * @return 解析后的日期
     */
    public static Date parse(String datestr, String pattern) {
        Date date = null;

        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATE_FORMAT;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 返回本月的最后一天
     * 
     * @return 本月最后一天的日期
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(getNow());
    }

    /**
     * 返回给定日期中的月份中的最后一天
     * 
     * @param date 基准日期
     * @return 该月最后一天的日期
     */
    public static Date getMonthLastDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //将日期设置为下一月第一天
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);

        //减去1天，得到的即本月的最后一天
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }
    
    /**
     * 计算两个具体日期之间的秒差，第一个日期-第二个日期
     * @param date1	
     * @param date2
     * @param onlyTime	是否只计算2个日期的时间差异，忽略日期，true代表只计算时间差
     * @return
     */
    public static long diffSeconds(Date date1, Date date2, boolean onlyTime) {
    	if (onlyTime) {
    		Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            calendar.set(1990, 1, 1);
            long t1 = calendar.getTimeInMillis();
            calendar.setTime(date2);
            calendar.set(1990, 1, 1);
            long t2 = calendar.getTimeInMillis();
        	return (t1-t2)/1000;
    	} else {
    		return (date1.getTime()-date2.getTime())/1000;
    	}
    }
    
    /**
     * @param date1
     * @param date2
     * @return
     */
    public static long diffSeconds(Date date1, Date date2) {
    	return diffSeconds(date1,date2,false);
    }
    
    /**
     * 根据日期确定星期几:1-星期日，2-星期一.....s
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date){
    	   Calendar cd = Calendar.getInstance();
           cd.setTime(date);
           int mydate = cd.get(Calendar.DAY_OF_WEEK);
           return mydate;
    }
    
    /**
     * 得到上月月份
     * 
     * @return 上月月份 yyyyMM
     */
    public static String getLastMonth() {
    	Calendar cd = Calendar.getInstance();
		int year = cd.get(Calendar.YEAR);
		int month = cd.get(Calendar.MONTH);
		if (month == 0) {
			year = year - 1;
			month = 12;
		}
		
		String lastMonth  = String.valueOf(year);
		lastMonth += (( month<10)?"0":"") + String.valueOf(month);
		return lastMonth;
    }
    /**
     * 时间戳转换成固定时间格式的字符串
     * @return
     */
    public static String getTimestAmp(String timestAmp, String pattern){
    	if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    	Long time=Long.decode(timestAmp);
    	String d = dateFormat.format(time);
    	   return d;
    }
    /**
     * 字符串日期去掉“-”
     * @return
     */
    public static String getTimeString(String time){
    	if (null ==  time || "".equals( time)) {
    		return time;
        }
    	time = time.replaceAll("-", "");
    	return time;
    }
    /**
     * 将日期格式化
     * @return
     */
    public static String getDateFormate(String pattern, Date date){
    	if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT;
        }
    	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    	return dateFormat.format(date);
    }
    /**
     * 将日期格式化
     * @return
     */
    public static String getStrFormate(String date){
    	
    	if (null == date || "".equals(date)) {
            return date;
        }
    	date = date.substring(0,4) +"-"+ date.substring(4,6) +"-"+date.substring(6,8);
    	return date;
    }
    /**
     * 判断平年闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) { 

        boolean cond1 = year % 4 == 0;  //条件1：年份必须要能被4整除搜索 

        boolean cond2 = year % 100 != 0;  //条件2：年份不能是整百数 

        boolean cond3 = year % 400 ==0;  //条件3：年份是400的倍数 

        //当条件1和条件2同时成立时，就肯定是闰年，所以条件1和条件2之间为“与”的关系。 

        //如果条件1和条件2不能同时成立，但如果条件3能成立，则仍然是闰年。所以条件3与前2项为“或”的关系。 

        //所以得出判断闰年的表达式： 
        boolean cond = cond1 && cond2 || cond3; 
        if(cond) { 
            return true; 
        } else { 
            return false; 
        } 
    }
    /**
     * yyyymmdd +1
     * @param date
     * @param days
     * @return
     */
    public static String dateAdd(String date, int days){
        String year = date.substring(0,4);
		String month = date.substring(4,6);
		String day = date.substring(6);
		if("01".equals(month) || "03".equals(month) || "05".equals(month) ||"07".equals(month) || "08".equals(month) || "10".equals(month) ||"12".equals(month)){
			if((Integer.parseInt(day)+days)>31){
				if(month.equals("12")){
					year = (Integer.parseInt(year)+1)+"";
					month = "01";
					day = "01";
				 }else{
				 	month =	 (Integer.parseInt(month)+1)+"";
				 	day = days+"";
				 }
			}else{
				day = (Integer.parseInt(day)+days)+"";
			}
		}else{
			boolean flag = isLeapYear(Integer.parseInt(year));
			if(month.equals("02")){
					if(flag){
						if((Integer.parseInt(day)+days)>29){
							month =	 (Integer.parseInt(month)+1)+"";
							day = days+"";
						}else{
							day = (Integer.parseInt(day)+days)+"";
						}
					}else{
						if(Integer.parseInt(day)+days>28){
							month =	 (Integer.parseInt(month)+1)+"";
							day = days+"";
						}else{
							day = (Integer.parseInt(day)+days)+"";
						}
					}
			}else{
				if((Integer.parseInt(day)+days)>30){
					month =	 (Integer.parseInt(month)+1)+"";
					day = days+"";
				}else{
					day = (Integer.parseInt(day)+days)+"";
				}
		}
	}
	return year+(Integer.parseInt(month)>9?Integer.parseInt(month):"0"+Integer.parseInt(month))+(Integer.parseInt(day)>9?Integer.parseInt(day):"0"+Integer.parseInt(day));
}


    public static Date future(long l) {
        long l1 = getNow().getTime() + l;
        return new Date(l1);
    }
}