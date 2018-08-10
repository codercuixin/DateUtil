import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * * @Author: cuixin
 * joda工具类
 * * @Date: 2018/7/31 19:07
 */
public class JodaDateUtil {
    public static Date str2date(String strTime, Pattern pattern) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern.getPattern());
        DateTime dateTime = fmt.parseDateTime(strTime);
        return dateTime.toDate();
    }

    public static Date str2date(String time) {
        return str2date(time, Pattern.yyyy_MM_dd_HH_mm_ss);
    }

    public static String date2str(Date date, Pattern pattern) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern.getPattern());
        DateTime dateTime = new DateTime(date);
        return fmt.print(dateTime);
    }

    /**
     * 转换成yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static String date2str(Date date) {
        return date2str(date, Pattern.yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * 字符串在两种格式之间转换
     */
    public static String strToStr(String fromStr, Pattern fromPattern,
                                  Pattern toPattern) {
        Date d = str2date(fromStr, fromPattern);
        return date2str(d, toPattern);
    }

    /**
     * 获取当前日期yyyy-MM-dd的形式
     *
     * @return
     */
    public static String getCuryyyy_MM_dd() {
        return date2str(DateTime.now().toDate(), Pattern.yyyy_MM_dd);
    }

    /**
     * 获取当前日期yyyyMMdd的形式
     *
     * @return
     */
    public static String getCuryyyyMMdd() {
        return date2str(DateTime.now().toDate(), Pattern.yyyyMMdd);
    }

    public static int getCuryyyyMMddInteger() {
        return Integer.parseInt(date2str(DateTime.now().toDate(), Pattern.yyyyMMdd));
    }

    public static long getCuryyyyyyyyMMddHHmmssL() {
        return Long.parseLong(date2str(DateTime.now().toDate(), Pattern.yyyyMMddHHmmss));
    }

    /**
     * 获取当前日期yyyy年MM月dd日的形式
     *
     * @return
     */
    public static String getCuryyyyMMddzh() {
        return date2str(DateTime.now().toDate(), Pattern.yyyy_MM_dd_zh);
    }

    /**
     * 获取当前日期时间yyyy-MM-dd HH:mm:ss的形式
     *
     * @return
     */
    public static String getCurDateTime() {
        return date2str(DateTime.now().toDate(), Pattern.yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * 获取当前日期时间yyyy年MM月dd日HH时mm分ss秒的形式
     *
     * @return
     */
    public static String getCurDateTimezh() {
        return date2str(new Date(), Pattern.yyyy_MM_dd_HH_mm_ss_zh);
    }

    public static Date addYear(Date d, int years) {
        DateTime dateTime = new DateTime(d);
        dateTime = dateTime.plusYears(years);
        return dateTime.toDate();
    }

    public static Date addSeconds(Date d, int sec) {
        DateTime dateTime = new DateTime(d);
        dateTime = dateTime.plusSeconds(sec);
        return dateTime.toDate();
    }

    public static Date addMinutes(Date d, int min) {
        DateTime dateTime = new DateTime(d);
        dateTime = dateTime.plusMinutes(min);
        return dateTime.toDate();
    }

    public static Date addHours(Date d, int hours) {
        DateTime dateTime = new DateTime(d);
        dateTime = dateTime.plusHours(hours);
        return dateTime.toDate();
    }

    /**
     * 比较两个"yyyy-MM-dd HH:mm:ss"格式的日期，之间相差多少毫秒,time2-time1
     *
     * @param time1
     * @param time2
     * @return
     */
    public static long compareDateStr(String time1, String time2) {
        Date d1 = str2date(time1);
        Date d2 = str2date(time2);
        return d1.getTime() - d2.getTime();
    }

    /**
     * 比较两个"yyyy-MM-dd HH:mm:ss"格式的日期，之间相差多少毫秒,time2-time1
     *
     * @param time1
     * @param time2
     * @return
     */
    public static long compareDate(Date time1, Date time2) {
        DateTime t1 = new DateTime(time1);
        DateTime t2 = new DateTime(time2);
        return t1.getMillis() - t2.getMillis();
    }

    /**
     * 获取Date中的分钟
     *
     * @param d
     * @return
     */
    public static int getMinute(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getMinuteOfHour();
    }

    /**
     * 获取Date中的小时(24小时)
     *
     * @param d
     * @return
     */
    public static int getHour(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getHourOfDay();
    }

    /**
     * 获取Date中的秒
     *
     * @param d
     * @return
     */
    public static int getSecond(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getSecondOfMinute();
    }

    /**
     * 获取Date中的毫秒
     *
     * @param d
     * @return
     */
    public static int getMilliSecond(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getMillisOfSecond();
    }

    /**
     * 获取xxxx-xx-xx的日
     *
     * @param d
     * @return
     */
    public static int getDay(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getDayOfMonth();
    }

    /**
     * 获取月份，1-12月
     *
     * @param d
     * @return
     */
    public static int getMonth(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getMonthOfYear();
    }

    /**
     * 获取19xx,20xx形式的年
     *
     * @param d
     * @return
     */
    public static int getYear(Date d) {
        DateTime dateTime = new DateTime(d);
        return dateTime.getYear();
    }

    /**
     * 得到d 的年份+月份,如200505
     *
     * @return
     */
    public static String getYearMonthOfDate(Date d) {
        return date2str(d, Pattern.yyyyMM);
    }

    /**
     * 得到上个月的年份+月份,如200505
     *
     * @return
     */
    public static String getYearMonthOfPreviousMonth(Date date) {

        return date2str(addMonth(date, -1), Pattern.yyyyMM);
    }

    /**
     * 得到当前日期的年和月如200509
     *
     * @return String
     */
    public static String getCurYearMonth() {
        return date2str(DateTime.now().toDate(), Pattern.yyyyMM);
    }

    /**
     * 获得系统当前月份的天数
     *
     * @return
     */
    public static int getCurrentMonthDays() {
        return getMonthDays(DateTime.now().toDate());
    }

    /**
     * 获得指定日期月份的天数
     *
     * @return
     */
    public static int getMonthDays(Date date) {
        return new DateTime(date).dayOfMonth().withMaximumValue().getDayOfMonth();
    }

    /**
     * 在传入时间基础上加一定月份数
     *
     * @param oldTime Date
     * @param months  int
     * @return long
     */
    public static Date addMonth(Date oldTime, final int months) {
        DateTime dateTime = new DateTime(oldTime);
        dateTime = dateTime.plusMonths(months);
        return dateTime.toDate();
    }

    public static long addMonth(long oldTime, final int months) {
        DateTime dateTime = new DateTime(oldTime);
        dateTime = dateTime.plusMonths(months);
        return dateTime.getMillis();
    }

    /**
     * 在传入时间基础上加一定天数
     *
     * @param oldTime long
     * @param day     int
     * @return long
     */
    public static long addDay(final long oldTime, final int day) {
        DateTime dateTime = new DateTime(oldTime);
        dateTime = dateTime.plusDays(day);
        return dateTime.getMillis();
    }

    /**
     * 在传入时间基础上加一定天数
     *
     * @param oldTime Calendar
     * @param day     int
     * @return long
     */
    public static Date addDay(final Date oldTime, final int day) {
        DateTime dateTime = new DateTime(oldTime);
        dateTime = dateTime.plusDays(day);
        return dateTime.toDate();
    }

    /**
     * 获取当天零时时间戳
     *
     * @return
     */
    public static long getCurDayStartTime() {
        return str2date(getCuryyyy_MM_dd() + " 00:00:00").getTime();
    }

    /**
     * 获得周一的日期
     *
     * @param date
     * @return
     */
    public static Date getMonday(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.withDayOfWeek(DateTimeConstants.MONDAY);
        return dateTime.toDate();
    }

    /**
     * 获得周五的日期
     *
     * @param date
     * @return
     */
    public static Date getFriday(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.withDayOfWeek(DateTimeConstants.FRIDAY);
        return dateTime.toDate();

    }

    /**
     * 得到月的第一天
     */
    public static Date getMonthFirstDay(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfMonth().withMinimumValue();
        return dateTime.toDate();

    }

    /**
     * 得到月的最后一天
     */
    public static Date getMonthLastDay(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfMonth().withMaximumValue();
        return dateTime.toDate();

    }

    /**
     * 得到季度的第一天
     */
    public static Date getSeasonFirstDay(Date date) {
        DateTime dateTime = new DateTime(date);
        int curMonth = dateTime.getMonthOfYear();
        if (curMonth >= DateTimeConstants.JANUARY && curMonth <= DateTimeConstants.MARCH) {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.JANUARY);
        } else if (curMonth >= DateTimeConstants.APRIL && curMonth <= DateTimeConstants.JUNE) {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.APRIL);
        } else if (curMonth >= DateTimeConstants.JULY && curMonth <= DateTimeConstants.SEPTEMBER) {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.JULY);
        } else {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.OCTOBER);
        }
        dateTime = dateTime.dayOfMonth().withMinimumValue();
        return dateTime.toDate();
    }

    /**
     * 得到季度的最后一天
     */
    public static Date getSeasonLastDay(Date date) {
        DateTime dateTime = new DateTime(date);
        int curMonth = dateTime.getMonthOfYear();
        if (curMonth >= DateTimeConstants.JANUARY && curMonth <= DateTimeConstants.MARCH) {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.MARCH);
        } else if (curMonth >= DateTimeConstants.APRIL && curMonth <= DateTimeConstants.JUNE) {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.JUNE);
        } else if (curMonth >= DateTimeConstants.JULY && curMonth <= DateTimeConstants.SEPTEMBER) {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.SEPTEMBER);
        } else {
            dateTime = dateTime.withMonthOfYear(DateTimeConstants.DECEMBER);
        }
        dateTime = dateTime.dayOfMonth().withMaximumValue();
        return dateTime.toDate();
    }

    /**
     * 获取年第一天日期
     *
     * @return Date
     */
    public static Date getYearFirstDay(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfYear().withMinimumValue();
        return dateTime.toDate();
    }

    /**
     * 获取年最后一天日期
     *
     * @return Date
     */
    public static Date getYearLastDay(Date date) {
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.dayOfYear().withMaximumValue();
        return dateTime.toDate();
    }

    public enum Pattern {
        //如果不够用可以自己添加
        yyyy_MM("yyyy-MM"),
        yyyyMM("yyyyMM"),
        yyyy_MM_dd("yyyy-MM-dd"),
        yyyyMMdd("yyyyMMdd"),
        yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
        yyyyMMddHHmmss("yyyyMMddHHmmss"),
        yyyy_MM_dd_HH_mm_ss_zh("yyyy年MM月dd日HH时mm分ss秒"),
        yyyy_MM_dd_HH_mm_ss_SSS("yyyy-MM-dd HH:mm:ss.SSS"),
        yyyy_MM_dd_zh("yyyy年MM月dd日"),
        yyyy_MM_dd_HH_mm_zh("yyyy年MM月dd日HH时mm分");
        private String pattern;

        Pattern(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }
}
