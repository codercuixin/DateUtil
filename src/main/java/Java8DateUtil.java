import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * * @Author: cuixin
 * * @Date: 2018/7/31 17:28
 */
public class Java8DateUtil {
    public  enum Pattern{
        //如果不够用可以自己添加
        yyyy_MM_dd("yyyy-MM-dd"),
        yyyy1MM1dd("yyyy/MM/dd"),
        yyyyMMdd("yyyyMMdd"),
        yyyy_MM("yyyy-MM"),
        yyyy1MM("yyyy/MM"),
        yyyyMM("yyyyMM"),
        yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
        yyyy_MM_dd_HH_mm_ss_SSS("yyyy-MM-dd HH:mm:ss.SSS"),
        yyyyMMddHHmmss("yyyyMMddHHmmss"),
        yyyy_MM_dd_zh("yyyy年MM月dd日"),
        yyyy_MM_dd_HH_mm_ss_zh("yyyy年MM月dd日HH时mm分ss秒"),
        yyyy_MM_dd_HH_mm_zh("yyyy年MM月dd日HH时mm分");
        private String pattern;
        Pattern(String pattern){
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }

    public static Date str2date(String strTime, Pattern pattern){
        LocalDateTime localDateTime =  str2LocalDateTime(strTime, pattern);
        ZoneId zoneId = ZoneId.systemDefault();
//        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }
    public static String date2str(Date date, Pattern pattern){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
//        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTim2str(localDateTime, pattern);
    }
    public static LocalDateTime str2LocalDateTime(String strTime, Pattern pattern) {
        return LocalDateTime.parse(strTime, DateTimeFormatter.ofPattern(pattern.getPattern()));
    }

    public static String localDateTim2str(LocalDateTime dateTime, Pattern pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern.getPattern()));
    }
}
