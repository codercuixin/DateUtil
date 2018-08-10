import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * * @Author: cuixin
 * * @Date: 2018/8/1 15:19
 */
public class CompareTest {
    @Test
    public void compareTest(){
        System.out.println("--------ThreadLocal start -------");
        long start = System.currentTimeMillis();
        for(int i=0; i< testNum; i++){
            String date = "2014-09-01 12:30:20.100";
//            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM);
//            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM_dd);
            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM_dd_HH_mm_ss_SSS);
        }
        System.out.println(String.format("----ThreadLocal spend %d ms", System.currentTimeMillis()-start));
        System.out.println("--------ThreadLocal end -------");

        System.out.println("--------Joda start -------");
        start = System.currentTimeMillis();
        for(int i=0; i< testNum; i++){
            String date = "2014-09-01 12:30:20.100";
//            JodaDateUtil.str2date(date, JodaDateUtil.Pattern.yyyy_MM);
//            JodaDateUtil.str2date(date, JodaDateUtil.Pattern.yyyy_MM_dd);
            JodaDateUtil.str2date(date, JodaDateUtil.Pattern.yyyy_MM_dd_HH_mm_ss_SSS);
        }
        System.out.println(String.format("----Joda spend %d ms", System.currentTimeMillis()-start));
        System.out.println("--------Joda end -------");
    }
    private int testRound = 3;
    private int testNum = 100000000;
    private ExecutorService executorService = Executors.newFixedThreadPool(testRound);

    public void compareTestWithMutipleThread() throws InterruptedException {
        System.out.println("--------ThreadLocal start -------");
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for(int i=0; i<testRound; i++ )
        executorService.submit(()->{
            for(int j=0; j< testNum; j++){
                String date = "2014-09-01 12:30:20.100";
//            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM);
//            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM_dd);
                LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM_dd_HH_mm_ss_SSS);
            }
            countDownLatch.countDown();
        });
        countDownLatch.await();
        System.out.println(String.format("----ThreadLocal spend %d ms", System.currentTimeMillis()-start));
        System.out.println("--------ThreadLocal end -------");

        System.out.println("--------Joda start -------");
        start = System.currentTimeMillis();
        CountDownLatch countDownLatch1 = new CountDownLatch(3);
        for(int i=0; i<testRound; i++ )
            executorService.submit(()->{
                for(int j=0; j< testNum; j++){
                    String date = "2014-09-01 12:30:20.100";
//            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM);
//            LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM_dd);
                    LocalThreadDateUtil.strToDate(date, LocalThreadDateUtil.yyyy_MM_dd_HH_mm_ss_SSS);
                }
                countDownLatch1.countDown();
            });
        countDownLatch1.await();
        System.out.println(String.format("----Joda spend %d ms", System.currentTimeMillis()-start));
        System.out.println("--------Joda end -------");
    }

}
