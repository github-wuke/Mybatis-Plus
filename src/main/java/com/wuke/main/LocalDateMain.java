package com.wuke.main; /**
 * 支持 import Java 标准库 (JDK 1.8)
 */
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;



/*
  入门级小工具：常用日期时间工具类。
  介绍：在日常工作中，我们对日期时间处理是十分常见的操作。因此，本示例提供了一个参照。
*/
public class LocalDateMain {

    public static final DateTimeFormatter FORMATTER_FULL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+8"));
    public static final DateTimeFormatter DATE_STR = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("+8"));


    public static void main(String []args) {
        // 1. java8获取当前时间
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("+8"));
        // 2.将获取当前时间转化成特定格式
        System.out.println("dateTimeFormatter = " + now.format(dateTimeFormatter));

        // 3.字符串转成特定时间
        String strDateTime = "2022-04-04 11:50:53";
        LocalDateTime parse = LocalDateTime.parse(strDateTime, dateTimeFormatter);


        // 4.一天的开始/一天的结束
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        String startDay = start.format(dateTimeFormatter);
        String endDay = end.format(dateTimeFormatter);
        System.out.println("startDay = " + startDay + "endDay = " + endDay);

        // 5.获取当前月的第一天
        LocalDate currentMonthFirstDay = LocalDate.now().minusMonths(0).with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("with = " + currentMonthFirstDay);

        // 6.获取周几
        DayOfWeek dayOfWeek = currentMonthFirstDay.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        int value = dayOfWeek.getValue();
        System.out.println("value = " + value);

        // 7.获取一个月多少 //当月的天数
        int i = LocalDate.now().lengthOfMonth();

        // 8.获取当前月的最后一天
        LocalDate currentMonthEndDay = LocalDate.now().minusMonths(0).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("withEnd = " + currentMonthEndDay);

        // 9.一个月之前，一个月之后
        LocalDate currentNow = LocalDate.now();
        LocalDate minus = currentNow.minus(1, ChronoUnit.MONTHS);
        LocalDate plus = currentNow.plus(1, ChronoUnit.MONTHS);
        System.out.println("with = " + minus + plus);

        // 10.获取几天/几天后的日期
        LocalDate minus1 = currentNow.minus(1, ChronoUnit.DAYS);
        LocalDate plus1 = currentNow.plus(1, ChronoUnit.DAYS);
        System.out.println("minus1 = " + minus1);
        System.out.println("plus1 = " + plus1);

        // 11.java8指定年月日
        LocalDate of = LocalDate.of(2021, 11, 18);
        System.out.println("of = " + of);
    }


    /**
     * 将字符串 转成 LocalDateTime 示例："2016-04-04 11:50:53"
     *
     * @param dateTime 时间
     * @return LocalDateTime
     */
    public static LocalDateTime strTimeToLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, FORMATTER_FULL);
    }

    /**
     * date 转成 LocalDateTime
     *
     * @param date 日期
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * date 转成 LocalDate
     *
     * @param date 日期
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * date 转成 LocalTime
     *
     * @param date 日期
     */
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }

    /**
     * LocalDateTime 转成 Date
     *
     * @param localDateTime 时间
     * @return 结果集
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * localDate 转成 Date
     *
     * @param localDate 结果集
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalTime 转成 Date
     *
     * @param localTime 本地时间
     * @param localDate 时间
     */
    public static Date localTimeToDate(LocalTime localTime, LocalDate localDate) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }


    /**
     * 获取前一个月的第一天的时间
     *
     * @return 几号
     */
    public Integer getLastMonthEndDay() {
        LocalDate with = LocalDate.now().plusMonths(-1).with(TemporalAdjusters.firstDayOfMonth());
        return with.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }

    /**
     * 获取后一个月的第一天的时间
     *
     * @return 几号
     */
    public static Integer getNextMonthEndDay() {
        LocalDate with = LocalDate.now().plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        return with.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }



    /**
     * @param begin 开始日期
     * @param end   结束日期
     * @return 开始与结束之间的所以日期，包括起止
     */
    public static List<LocalDate> getMiddleAllDate(LocalDate begin, LocalDate end) {
        List<LocalDate> localDateList = new ArrayList<>();
        long length = end.toEpochDay() - begin.toEpochDay();
        for (long i = length; i >= 0; i--) {
            localDateList.add(end.minusDays(i));
        }
        return localDateList;
    }

    /**
     * 获取前几天或者后几天的时间
     *
     * @param offSet     负数代表前几天
     * @param timeFormat 时间格式化类型
     * @return 格式化后的结果
     */
    public static String getYesterdayByFormat(Integer offSet, String timeFormat) {
        return LocalDateTime.now().plusDays(offSet).format(DateTimeFormatter.ofPattern(timeFormat));
    }

}