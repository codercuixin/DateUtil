import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * * @Author: cuixin
 * * @Date: 2018/8/9 14:44
 */
public class TestMine {
    @Test
    public void test(){
//        BigDecimal bigDecimal = new BigDecimal(10);
//        System.out.println(bigDecimal.toString());
        PeFundCollectInfo peFundCollectInfo = new PeFundCollectInfo();
        peFundCollectInfo.setACTANYIECET("1");
        peFundCollectInfo.setACTUALLRAISE("2");
        peFundCollectInfo.setAPPLYRATE("3");
        Class clazz = peFundCollectInfo.getClass();
        Map<String, Object> map = new HashMap<>();
        for(Method method: clazz.getDeclaredMethods()){
            if(method.getName().startsWith("get")){
                try {
                    map.put(method.getName().substring(3).toUpperCase(), method.invoke(peFundCollectInfo));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();

    }

}
