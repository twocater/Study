package com.cpaladin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 缺省格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将时间转换为字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String toString(Date date, String format) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date.getTime());
        }
        return null;
    }

    /**
     * 将时间按缺省格式转换为字符串
     *
     * @param date
     * @return
     */
    public static String toString(Date date) {
        return toString(date, DEFAULT_FORMAT);
    }

    /**
     * 将日历转换为字符串
     *
     * @param calendar
     * @param format
     * @return
     */
    public static String toString(Calendar calendar, String format) {
        if (calendar != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(calendar.getTime());
        }
        return null;
    }

    /**
     * 将日历按缺省格式转换为字符串
     *
     * @param calendar
     * @return
     */
    public static String toString(Calendar calendar) {
        return toString(calendar, DEFAULT_FORMAT);
    }

    /**
     * 获取当前时间字符串
     *
     * @param format
     * @return
     */
    public static String currentString(String format) {
        Calendar calendar = Calendar.getInstance();
        return toString(calendar, format);
    }

    /**
     * 按缺省格式获取当前时间字符串
     *
     * @return
     */
    public static String currentString() {
        return currentString(DEFAULT_FORMAT);
    }

    /**
     * 将字符串转换为时间
     *
     * @param date
     * @param format
     * @return
     */
    public static Date toDate(String date, String format) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            try {
                return dateFormat.parse(date);
            } catch (ParseException e) {
                throw new IllegalStateException("format error.", e.getCause());
            }
        }
        return null;
    }

    /**
     * 将字符串按缺省格式转换为时间
     *
     * @param date
     * @return
     */
    public static Date toDate(String date) {
        return toDate(date, DEFAULT_FORMAT);
    }

    /**
     * 将字符串转换为日历
     *
     * @param calendar
     * @param format
     * @return
     */
    public static Calendar toCalendar(String calendar, String format) {
        if (calendar != null) {
            Date date = toDate(calendar, format);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return instance;
        }
        return null;
    }

    /**
     * 将字符串按缺省格式转换为日历
     *
     * @param calendar
     * @return
     */
    public static Calendar toCalendar(String calendar) {
        return toCalendar(calendar, DEFAULT_FORMAT);
    }

    /**
     * 下一天
     *
     * @param day
     * @param format
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String nextDay(String day, String format) {
        if (day != null) {
            Date date = toDate(day, format);
            date.setDate(date.getDate() + 1);
            return toString(date, format);
        }
        return null;
    }

    /**
     * 下一天
     *
     * @param format
     * @return
     */
    public static String nextDay(String day) {
        return nextDay(day, DEFAULT_FORMAT);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String date = "2010-10-10 11:11:11";
        System.out.println(currentString());
        System.out.println(toDate(date));
        System.out.println(toString(toDate(date)));
        System.out.println(toCalendar(date));
        System.out.println(toString(toCalendar(date)));
        String regex = ".*\\.(jpg|png|js)(\\?.+)?";
        System.out.println("http://misc.web.xunlei.com/www_5_7/js/userstatus_tips_history_lazy_0712.min.js?date=20110712"
                .matches(regex));
    }

}
