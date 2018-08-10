import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * * @Author: cuixin
 * * @Date: 2018/7/31 17:57
 */
public class Java8DateUtilTest {
    @Test
    public void teststr2date(){

       DateTimeFormatterBuilder builder =  new DateTimeFormatterBuilder().appendPattern("yyyy-MM");
        YearMonth yearMonth = YearMonth.parse("2017-03", builder.toFormatter());
        LocalDateTime localDateTime = LocalDateTime.from(yearMonth);
        System.out.println(localDateTime);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String str = "2014-01-31";
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//        System.out.println(DateUtil.Pattern.yyyy_MM_dd.getPattern());
//        Date date = DateUtil.str2date(str, DateUtil.Pattern.yyyy_MM_dd);
//        System.out.println(date.toString());
    }
}