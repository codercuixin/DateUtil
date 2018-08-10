import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

/**
 * * @Author: cuixin
 * * @Date: 2018/7/31 19:19
 */
public class JodaDateUtilTest {
    public static final String yyyy_MM = "2014-09";
    public static final String yyyyMM = "201409";
    public static final String yyyy_MM_dd = "2014-09-01";
    public static final String yyyyMMdd = "20140901";
    public static final String yyyy_MM_dd_HH_mm_ss = "2014-09-01 12:30:20";
    public static final String yyyy_MM_dd_HH_mm_ss_SSS = "2014-09-01 12:30:20.100";
    public static final DateTime dateTime;

    static {
        dateTime = new DateTime(2018, 8, 30,
                12, 30, 20, 200);
    }

    @Test
    public void str2date() throws Exception {
        Date date = JodaDateUtil.str2date(yyyy_MM, JodaDateUtil.Pattern.yyyy_MM);
        System.out.println(date);
        date = JodaDateUtil.str2date(yyyy_MM_dd, JodaDateUtil.Pattern.yyyy_MM_dd);
        System.out.println(date);
        date = JodaDateUtil.str2date(yyyyMM, JodaDateUtil.Pattern.yyyyMM);
        System.out.println(date);
        date = JodaDateUtil.str2date(yyyyMMdd, JodaDateUtil.Pattern.yyyyMMdd);
        System.out.println(date);
        date = JodaDateUtil.str2date(yyyy_MM_dd_HH_mm_ss, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss);
        System.out.println(date);
        date = JodaDateUtil.str2date(yyyy_MM_dd_HH_mm_ss_SSS, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS);
        System.out.println(date);
    }


    @Test
    public void date2str() throws Exception {
        String str = JodaDateUtil.date2str(dateTime.toDate(), JodaDateUtil.Pattern.yyyy_MM);
        System.out.println(str);
        str = JodaDateUtil.date2str(dateTime.toDate(), JodaDateUtil.Pattern.yyyy_MM_dd);
        System.out.println(str);
        str = JodaDateUtil.date2str(dateTime.toDate(), JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss);
        System.out.println(str);
        str = JodaDateUtil.date2str(dateTime.toDate(), JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS);
        System.out.println(str);
    }

    @Test
    public void strToStr() throws Exception {
        String str = JodaDateUtil.strToStr(yyyy_MM_dd_HH_mm_ss_SSS, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS,
                JodaDateUtil.Pattern.yyyy_MM);
        System.out.println(str);
        str = JodaDateUtil.strToStr(yyyy_MM_dd_HH_mm_ss_SSS, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS,
                JodaDateUtil.Pattern.yyyy_MM_dd_zh);
        System.out.println(str);
        str = JodaDateUtil.strToStr(yyyy_MM_dd_HH_mm_ss_SSS, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS,
                JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_zh);
        System.out.println(str);
        str = JodaDateUtil.strToStr(yyyy_MM_dd_HH_mm_ss_SSS, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS,
                JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_zh);
        System.out.println(str);

    }

    @Test
    public void getCuryyyy_MM_dd() throws Exception {
        String str = JodaDateUtil.getCuryyyy_MM_dd();
        System.out.println(str);
    }

    @Test
    public void getCuryyyyMMdd() throws Exception {
        String str = JodaDateUtil.getCuryyyyMMdd();
        System.out.println(str);
    }

    @Test
    public void getCuryyyyMMddInteger() throws Exception {
        Integer val = JodaDateUtil.getCuryyyyMMddInteger();
        System.out.println(val);
    }

    @Test
    public void getCuryyyyyyyyMMddHHmmssL() throws Exception {
        Long val = JodaDateUtil.getCuryyyyyyyyMMddHHmmssL();
        System.out.println(val);
    }

    @Test
    public void getCuryyyyMMddzh() throws Exception {
        String val = JodaDateUtil.getCuryyyyMMddzh();
        System.out.println(val);
    }

    @Test
    public void getCurDateTime() throws Exception {
        String val = JodaDateUtil.getCurDateTime();
        System.out.println(val);
    }

    @Test
    public void getCurDateTimezh() throws Exception {
        String val = JodaDateUtil.getCurDateTimezh();
        System.out.println(val);
    }

    @Test
    public void addYear() throws Exception {
        Date val = JodaDateUtil.addYear(DateTime.now().toDate(), 2);
        System.out.println(JodaDateUtil.date2str(val, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss));
    }

    @Test
    public void addSeconds() throws Exception {
        Date val = JodaDateUtil.addSeconds(DateTime.now().toDate(), 90);
        System.out.println(JodaDateUtil.date2str(val, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss));
    }

    @Test
    public void addMinutes() throws Exception {
        Date val = JodaDateUtil.addMinutes(DateTime.now().toDate(), 90);
        System.out.println(JodaDateUtil.date2str(val, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss));
    }

    @Test
    public void addHours() throws Exception {
        Date val = JodaDateUtil.addHours(DateTime.now().toDate(), 90);
        System.out.println(JodaDateUtil.date2str(val, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss));
    }

    @Test
    public void compareDateStr() throws Exception {
        long val = JodaDateUtil.compareDateStr("2014-09-02 03:04:05", "2014-09-01 00:00:00");
        System.out.println(val);
    }

    @Test
    public void compareDate() throws Exception {
        long val = JodaDateUtil.compareDate(DateTime.now().toDate(), dateTime.toDate());
        System.out.println(val);
    }

    @Test
    public void getMinute() throws Exception {
        int val = JodaDateUtil.getMinute(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getHour() throws Exception {
        int val = JodaDateUtil.getHour(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getSecond() throws Exception {
        int val = JodaDateUtil.getSecond(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getMilliSecond() throws Exception {
        int val = JodaDateUtil.getMilliSecond(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getDay() throws Exception {
        int val = JodaDateUtil.getDay(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getMonth() throws Exception {
        int val = JodaDateUtil.getMonth(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getYear() throws Exception {
        int val = JodaDateUtil.getYear(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getYearMonthOfDate() throws Exception {
        String val = JodaDateUtil.getYearMonthOfDate(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getYearMonthOfLastMonth() throws Exception {
        String val = JodaDateUtil.getYearMonthOfPreviousMonth(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void getCurYearMonth() throws Exception {
        String val = JodaDateUtil.getCurYearMonth();
        System.out.println(val);
    }

    @Test
    public void getCurrentMonthDays() throws Exception {
        int val = JodaDateUtil.getCurrentMonthDays();
        System.out.println(val);
    }

    @Test
    public void getMonthDays() throws Exception {
        int val = JodaDateUtil.getMonthDays(DateTime.now().toDate());
        System.out.println(val);
    }

    @Test
    public void addMonth() throws Exception {
        Date val = JodaDateUtil.addMonth(DateTime.now().toDate(), 2);
        System.out.println(JodaDateUtil.date2str(val));
    }

    @Test
    public void addMonth1() throws Exception {
        long val = JodaDateUtil.addMonth(DateTime.now().toDate().getTime(), 2);
        System.out.println(new DateTime(val));
    }

    @Test
    public void addDay() throws Exception {
        Date val = JodaDateUtil.addDay(DateTime.now().toDate(), 2);
        System.out.println(JodaDateUtil.date2str(val));
    }

    @Test
    public void addDay1() throws Exception {
        long val = JodaDateUtil.addDay(DateTime.now().toDate().getTime(), 2);
        System.out.println(new DateTime(val));
    }


    @Test
    public void getCurDayStarttime() throws Exception {
        long val = JodaDateUtil.getCurDayStartTime();
        System.out.println(new DateTime(val));
    }

    @Test
    public void getMonday() throws Exception {
        Date val = JodaDateUtil.getMonday(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getFriday() throws Exception {
        Date val = JodaDateUtil.getFriday(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getMonthFirstDay() throws Exception {
        Date val = JodaDateUtil.getMonthFirstDay(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getMonthLastDay() throws Exception {
        Date val = JodaDateUtil.getMonthLastDay(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getSeasonFirstDay() throws Exception {
        Date val = JodaDateUtil.getSeasonFirstDay(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getSeasonLastDay() throws Exception {
        Date val = JodaDateUtil.getSeasonLastDay(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getYearFirstDay() throws Exception {
        Date val = JodaDateUtil.getYearFirstDay(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }

    @Test
    public void getYearLastDay() throws Exception {
        Date val = JodaDateUtil.getYearLastDay(DateTime.now().toDate());
        System.out.println(new DateTime(val));
    }


}