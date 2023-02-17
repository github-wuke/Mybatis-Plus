package com.wuke.utils;

import org.springframework.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtil {

    /**
     * 日期的默认格式
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd";

    public final static String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    public final static String DATE_FORMAT_MMDD = "MMdd";

    public final static String TIME_FORMAT = "HH:mm:ss";

    public final static String DATE_FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_FORMAT_YYYYMMDD_HHMMSSSSS = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public static Date getTimeAddHour(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        return cal.getTime();
    }

    /**
     * @title:取当前时间 0点
     * @description:
     * @author: 赵
     * @date:
     * @version V1.0
     */
    public static Date getTodayBeginTime(Date date) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(date);
        begin.set(11, 0);
        begin.set(12, 0);
        begin.set(13, 0);
        begin.set(14, 0);
        return begin.getTime();
    }

    /**
     * @Title: 时间转Unix 10位
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static long dateToUnixLong(Date date) {
        return date.getTime() / 1000L;
    }

    public static String dateToUnix16HEx(Date date) {
        Long ab = date.getTime() / 1000;
        return Long.toHexString(ab);
    }

    /**
     * @Title: 获得传入时间的后一天
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);// +1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

    /**
     * @Title: 获得传入时间的第几天
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static Date getNextOtherDay(Date date, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +day);// +day今天的时间加day天
        date = calendar.getTime();
        return date;
    }

    /**
     * @Title: 获得传入时间前第几天
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static String getBeforeOtherDay(Date date, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -day);// -day今天的时间减day天
        date = calendar.getTime();
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }


    /**
     * @Title: 获得传入时间前第几天
     */
    public static String getBeforeOtherDayByFormat(Date date, Integer day, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -day);// -day今天的时间减day天
        date = calendar.getTime();
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(format);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }


    public static String getBeforeOtherDayYmDhms(Date date, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -day);// -day今天的时间减day天
        date = calendar.getTime();
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSS);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 把时间转化为"yyyy-MM-dd"格式字符串返回, 转化失败返回""。
     *
     * @param date 待处理时间
     * @return String 转化失败返回""
     */
    public static String getDateToString(Date date) {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    public static String getNowTimeToString() {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSSSSS);
            result = formater.format(new Date());
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 把时间转化为"yyyy-MM-dd"格式字符串返回, 转化失败返回""。
     *
     * @param date 待处理时间
     * @return String 转化失败返回""
     */
    public static String getTimeToString(Date date) {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSS);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * @Title: 获得当前时间的前一天 yyyy-MM-dd
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static String getDateYesterday() {
        String result = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
            result = new SimpleDateFormat(DATE_FORMAT).format(calendar.getTime());
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 获获取传入时间的前一天
     *
     * @return
     */
    public static String getDateYesterdayByDate(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();
        localDate = localDate.plusDays(-1);
        return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));

    }

    /**
     * @Title: 获得当天日期 yyyy-MM-dd
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static String getDateDay() {
        String result = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE));
            result = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * @Title: 获得当前时间的前一小时 yyyy-MM-dd HH
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static String getDateLastHour() {
        String result = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - 1);// 让时间-1
            result = new SimpleDateFormat("yyyy-MM-dd HH").format(calendar.getTime());
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * @Title: 获得当前时间的前一周 yyyy-MM-dd lastBeginDate 周一开始 lastEndDate 周天结束
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static Map<String, Object> getDateLastWeek() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
            int offset1 = 1 - dayOfWeek;
            int offset2 = 7 - dayOfWeek;
            calendar1.add(Calendar.DATE, offset1 - 7);
            calendar2.add(Calendar.DATE, offset2 - 7);
            String lastBeginDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar1.getTime());
            String lastEndDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar2.getTime());
            map.put("lastBeginDate", lastBeginDate);
            map.put("lastEndDate", lastEndDate);
            return map;
        } catch (Exception e) {
            map.put("lastBeginDate", null);
            map.put("lastEndDate", null);
            return map;
        }
    }

    /**
     * @Title: 获得当前时间的一周 yyyy-MM-dd beginDate 周一开始 endDate 周天结束
     * @Description:
     * @author: 赵
     * @time: 2018\12\19 0019
     * @version V1.0.0
     */
    public static Map<String, Object> getDateWeek() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayofweek == 1) {
                dayofweek += 7;
            }
            cal.add(Calendar.DATE, 2 - dayofweek);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(cal.getTime());
            cal2.add(Calendar.DAY_OF_WEEK, 6);
            String beginDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            String endDate = new SimpleDateFormat("yyyy-MM-dd").format(cal2.getTime());
            map.put("beginDate", beginDate);
            map.put("endDate", endDate);
            return map;
        } catch (Exception e) {
            map.put("beginDate", null);
            map.put("endDate", null);
            return map;
        }
    }

    /**
     * 把时间转化为指定格式字符串返回, 转化失败返回""。
     *
     * @param date 待处理时间
     * @return String 转化失败返回""
     */
    public static String getFormatDateToString(Date date, String format) {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(format);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 得到当前系统时间关转化为批定的串返回""。
     *
     * @param format 待处理时间
     * @return String 转化失败返回""
     */
    public static String getSystemDateToString(String format) {
        String result = "";
        try {
            // 设置日期格式
            SimpleDateFormat formater = new SimpleDateFormat(format);
            result = formater.format(new Date());
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;
    }

    public static String stampToDate(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSS);
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;
    }

    public static Date stampToDateTime(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSS);
        String time_Date = sdf.format(new Date(time));
        try {
            Date date = sdf.parse(time_Date);
            return date;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 把时间转化为"yyyy-MM-dd HH:mm:ss"格式字符串返回, 转化失败返回""。
     *
     * @param date 待处理时间
     * @return String 转化失败返回""
     */
    public static String getFullDateToString(Date date) {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT + " " + TIME_FORMAT);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 把时间转化为指定格式字符串返回, 转化失败返回""。
     * <p>
     * </p>
     *
     * @param date   待处理时间
     * @param format 指定返回的时间格式
     * @return String
     */
    public static String getDateToString(Date date, String format) {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(format);
            result = formater.format(date);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 把"yyyy-MM-dd"格式的字符串转化为时间类型返回。
     * <p>
     * </p>
     *
     * @param source 待处理字符串
     * @return Date 转化失败返回null
     */
    public static Date formatDate(String source) {
        SimpleDateFormat formator = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date date = formator.parse(source);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把"yyyy-MM-dd HH:mm:ss"格式的字符串转化为时间类型返回。
     * <p>
     * </p>
     *
     * @param source 待处理字符串
     * @return Date 转化失败返回null
     */
    public static Date formatFullDate(String source) {
        SimpleDateFormat formator = new SimpleDateFormat(DATE_FORMAT + " " + TIME_FORMAT);
        try {
            Date date = formator.parse(source);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public static Date dateToISODate(Date date) {
        //T代表后面跟着时间，Z代表UTC统一时间
        try {
            SimpleDateFormat format =
                    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            String isoDate = format.format(date);

            return format.parse(isoDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把字符串转化为指定时间格式的时间类型返回。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source 待处理字符串
     * @param format 时间格式
     */
    public static Date formatDate(String source, String format) {
        SimpleDateFormat formator = new SimpleDateFormat(format);
        try {
            Date date = formator.parse(source);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 返回date增加或减少days天的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date 待处理时间
     * @param days
     * @return
     */
    public static Date getDateAddDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    /**
     * 返回date增加或减少days天的日期。 返回时间2019：08：06 23：59：59
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date 待处理时间
     * @param days
     * @return
     */
    public static Date getDateEndDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 返回date增加或减少days天的日期。 返回时间2019：08：06 23：59：59
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date 待处理时间
     * @param days
     * @return
     */
    public static Date getDateStartDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取传入时间 x 个月后的1号
     */
    public static Date getDateStartMonty(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }


    /**
     * 返回source对应日期增加或减少days天的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source 待处理字符串
     * @param days
     * @return
     */
    public static Date getDateAddDays(String source, int days) {
        Date date = formatDate(source, DATE_FORMAT + " " + TIME_FORMAT);
        return getDateAddDays(date, days);
    }

    /**
     * 返回source对应日期增加或减少days天的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source 待处理字符串
     * @param days
     * @return
     */
    public static Date getDateAdd(String source, int days) {
        Date date = formatDate(source, DATE_FORMAT + " 23:59:59");
        return getDateAddDays(date, days);
    }


    /**
     * 返回date增加或减少hours小时的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date getDateAddHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * 返回source对应时间增加或减少hours小时的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source
     * @param hours
     * @return
     */
    public static Date getDateAddHours(String source, int hours) {
        Date date = formatDate(source, DATE_FORMAT + " " + TIME_FORMAT);
        return getDateAddHours(date, hours);
    }

    /**
     * 返回date增加或减少mins分钟的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date
     * @param mins
     * @return
     */
    public static Date getDateAddMins(Date date, int mins) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, mins);
        return calendar.getTime();
    }

    /**
     * 返回source对应时间增加或减少mins分钟的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source
     * @param mins
     * @return
     */
    public static Date getDateAddMins(String source, int mins) {
        Date date = formatDate(source, DATE_FORMAT + " " + TIME_FORMAT);
        return getDateAddMins(date, mins);
    }

    /**
     * 返回date增加或减少seconds秒的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date
     * @param seconds
     * @return
     */
    public static Date getDateAddSeconds(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    /**
     * 返回source对应日期增加或减少seconds秒的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source
     * @param seconds
     * @return
     */
    public static Date getDateAddSeconds(String source, int seconds) {
        Date date = formatDate(source, DATE_FORMAT + " " + TIME_FORMAT);
        return getDateAddSeconds(date, seconds);
    }

    /**
     * 返回date增加或减少 days天、hours小时、mins分钟、seconds秒的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date
     * @param days
     * @param hours
     * @return
     */
    public static Date getDateAddAll(Date date, int days, int hours, int mins, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        calendar.add(Calendar.MINUTE, mins);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    /**
     * 返回source对应时间增加或减少 days天、hours小时、mins分钟、seconds秒的日期。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source
     * @param days
     * @param hours
     * @param mins
     * @param seconds
     * @return
     */
    public static Date getDateAddAll(String source, int days, int hours, int mins, int seconds) {
        Date date = formatDate(source, DATE_FORMAT + " " + TIME_FORMAT);
        return getDateAddAll(date, days, hours, mins, seconds);
    }

    /**
     * 返回两个时间相差的毫秒数。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getCompare(Date date1, Date date2) {
        return date1.getTime() - date2.getTime();
    }

    public static int differentDays(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days+1;
    }

    /**
     * @param date1 日期1
     * @param date2 日期2
     * @return
     * @title: dateCompare
     * @description: 比较日期大小
     */
    public static int dateCompare(Date date1, Date date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateFirst = dateFormat.format(date1);
        String dateLast = dateFormat.format(date2);
        int dateFirstIntVal = Integer.parseInt(dateFirst);
        int dateLastIntVal = Integer.parseInt(dateLast);
        if (dateFirstIntVal > dateLastIntVal) {
            return 1;
        } else if (dateFirstIntVal < dateLastIntVal) {
            return -1;
        }
        return 0;
    }

    /**
     * 比较2时间打小，返回小的
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Date compareDateResultMin(Date date1, Date date2) {
        return date1.compareTo(date2) >=  0? date2 : date1;
    }


    /**
     * 返回两个时间相差的毫秒数。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source1
     * @param source2
     * @return
     */
    public static long getCompare(String source1, String source2) {
        Date date1 = formatDate(source1, DATE_FORMAT + " " + TIME_FORMAT);
        Date date2 = formatDate(source2, DATE_FORMAT + " " + TIME_FORMAT);
        return getCompare(date1, date2);
    }

    /**
     * 返回某个月份的天数。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source "yyyy-MM"
     * @return
     */
    public static int getDaysByMonth(String source) {
        String[] temp;
        int result = 0;
        if (source.contains("-")) {
            temp = source.split("-");
            result = days(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        return result;
    }

    /**
     * 返回某天星期几。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param source "yyyy-MM-dd"
     * @return 返回0代表星期日, 1代表星期一, 2代表星期二...依次类推到6代表星期六
     */
    public static int getWeekByDay(String source) {
        Date date = formatDate(source, DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    /**
     * 返回某天星期几。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @return 返回1代表星期日, 2代表星期一, 3代表星期二...依次类推到7代表星期六
     */
    public static int getWeekByDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    /**
     * 返回某月的天数。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    private static int days(int year, int month) {
        int days = 0;
        if (month != 2) {
            switch (month) {
                case 1:
                    days = 31;
                    break;
                case 3:
                    days = 31;
                    break;
                case 5:
                    days = 31;
                    break;
                case 7:
                    days = 31;
                    break;
                case 8:
                    days = 31;
                    break;
                case 10:
                    days = 31;
                    break;
                case 12:
                    days = 31;
                    break;
                case 4:
                    days = 30;
                    break;
                case 6:
                    days = 30;
                    break;
                case 9:
                    days = 30;
                    break;
                case 11:
                    days = 30;
                    break;
                default:
                    days = 30;
                    break;
            }
        } else {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                days = 29;
            } else {
                days = 28;
            }
        }
        return days;
    }

    /**
     * 获取当前年。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @return
     */
    public static String getCurrentYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * 获取当前月。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @return
     */
    public static String getCurrentMonth() {
        return String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1);
    }

    /**
     * 获取当前天。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @return
     */
    public static String getCurrentDay() {
        return String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 获取当前是上半年还是下半年。
     * <p>
     * 上半年返回6，下半年返回12。
     * </p>
     *
     * @return
     */
    public static String getCurrentHarfYear() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        if (month <= 6) {
            return "6";
        } else {
            return "12";
        }
    }

    /**
     * 获取当前季度。
     * <p>
     * 一、二、三、四季度对应的值分别为3、6、9、12。
     * </p>
     *
     * @return
     */
    public static String getCurrentQuarter(String value) {
        String freq = null;
        Integer month = null;
        if (StringUtils.isEmpty(value)) {
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        } else {
            month = Integer.valueOf(value);
        }
        if (month <= 3) {
            freq = "3";
        } else if (month <= 6) {
            freq = "6";
        } else if (month <= 9) {
            freq = "9";
        } else if (month <= 12) {
            freq = "12";
        }
        return freq;
    }

    /**
     * 获取当前季度。
     * <p>
     * 一、二、三、四季度对应的值分别为3、6、9、12。
     * </p>
     *
     * @return
     */
    public static String formatQuarter(String value) {
        String freq = null;
        Integer month = null;
        if (StringUtils.hasText(value)) {
            try {
                month = Integer.valueOf(value);
            } catch (NumberFormatException e) {
                month = Calendar.getInstance().get(Calendar.MONTH) + 1;
            }
        } else {
            month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        }
        if (month <= 3) {
            freq = "一";
        } else if (month <= 6) {
            freq = "二";
        } else if (month <= 9) {
            freq = "三";
        } else if (month <= 12) {
            freq = "四";
        }
        return freq;
    }

    /**
     * 获取当前日期是本年的第几周。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        return g.get(Calendar.WEEK_OF_YEAR);// 获得周数
    }

    /**
     * 获取一年有多少周。
     * <p>
     * 方法详述（简单方法可不必详述）。
     * </p>
     *
     * @param year
     * @return
     */
    public static int getWeeks(int year) {
        int week = 0;
        int days = 365;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {// 判断是否闰年，闰年366天
            days = 366;
        }
        week = days / 7;// 得到多少周
        return week;
    }

    /**
     * 是否周末
     * <p>
     * 周六和周日返回true,周一到周五返回false。
     * </p>
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        return week == Calendar.SUNDAY || week == Calendar.SATURDAY;
    }

    /**
     * 获取几个月前的时间
     */
    public static String backMonth(Date date, int month, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -month);
        Date dBefore = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(dBefore);

    }


    /**
     * 获取几个月前的最后一天
     *
     * @param date
     */
    public static String backMonthLastDay(Date date, int month, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date dBefore = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(dBefore);
    }

    /**
     * 获取当前月的最后一天
     *
     * @param date
     * @param format
     * @return
     */
    public static String monthLastDay(Date date, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date dBefore = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(dBefore);
    }

    /**
     * 获取某年某月最后一天,如year="2018-6"
     * @param yearMonth
     * @return String
     */
    public static String getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
        int month = Integer.parseInt(yearMonth.split("-")[1]); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.MONTH, month); //设置当前月的上一个月
        // 获取某月最大天数
        //int lastDay = cal.getActualMaximum(Calendar.DATE);
        int lastDay = cal.getMinimum(Calendar.DATE); //获取月份中的最小值，即第一天
        // 设置日历中月份的最大天数
        //cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1); //上月的第一天减去1就是当月的最后一天
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 本月第一天
     * @param date
     * @param format
     * @return
     */
    public static String getMonthFirstDay(Date date,String format){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String data = simpleDateFormat.format(calendar.getTime());
        return data;
    }



    /**
     * 获取本周欧第一天
     */
    public static String getWeekOfDayFirst(Date localDate, String format) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(localDate);
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(currentDate.getTime());
    }

    /**
     * 本周最后一天
     */
    public static String getWeekOfDayLast(Date localDate, String format) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(localDate);
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(currentDate.getTime());
    }

    /**
     * 计算年龄，不符合算不出来返回0
     * @param birthday
     * @return
     */
    public static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            if(birthday == null){
                return age;
            }
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }
    public static Integer getMonthDiff(String startDate, String endDate){
        Integer monthday;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = null;
        try {
            startDate1 = fmt.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar starCal = Calendar.getInstance();
        starCal.setTime(startDate1);
        int sYear = starCal.get(Calendar.YEAR);
        int sMonth = starCal.get(Calendar.MONTH);
        int sDay = starCal.get(Calendar.DAY_OF_MONTH);
        Date endDate1 = null;
        try {
            endDate1 = fmt.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate1);
        int eYear = endCal.get(Calendar.YEAR);
        int eMonth = endCal.get(Calendar.MONTH);
        int eDay = endCal.get(Calendar.DAY_OF_MONTH);
        monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));
        //这里计算零头的情况，根据实际确定是否要加1 还是要减1
        if (sDay < eDay) {
            monthday = monthday + 1;
        }
        return monthday;
    }


    public static String getNowTimeHourString() {
        String result = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat("HH");
            result = formater.format(new Date());
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 当前时间 时分数据 转换为 秒数
     * @return
     */
    public static Long getConvertByHMToLong(){
        Calendar calendar = Calendar.getInstance();
        long h = calendar.get(Calendar.HOUR_OF_DAY);
        long m = calendar.get(Calendar.MINUTE);
        long s = calendar.get(Calendar.SECOND);
        return h*3600+m*60+s;
    }

    /**
     * 时分 转换为当前日期的date
     * @param time
     * @return
     */
    public static Date getTimeConvertDate(String source,String time) {
        SimpleDateFormat formator = new SimpleDateFormat(DATE_FORMAT);
        try{
            String[] split = time.split(":");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formator.parse(source));
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(split[0]));
            calendar.set(Calendar.MINUTE, Integer.parseInt(split[1]));
            calendar.set(Calendar.SECOND, 00);
            return calendar.getTime();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 把时间转化为"yyyy-MM-dd"格式字符串返回, 转化失败返回""。
     *
     * @param
     * @return String 转化失败返回""
     */
    public static String getTimeConvertString(String source,String time) {
        String result = "";
        try {
            Date timeConvertDate = getTimeConvertDate(source,time);
            if(timeConvertDate == null)return null;
            SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD_HHMMSS);
            result = formater.format(timeConvertDate);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    public static String getDatePoor(Date startDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒
        long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
    }
}
