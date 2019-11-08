import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class dataTest {
    @Test(dataProvider = "data")
    public  void dataTest(int a ,int b ,int c){
        System.out.println("a*b*c=" + a*b*c);
//        System.out.printf("ThreadID:%s%n",Thread.currentThread().getId());
    }

    @DataProvider(name = "data")
    public  Object[][] data(){
        Object[][] o = new Object[][]{
                {1,2,3},
                {10,20,30},
                {100,200,300}

        };

        return o;

    }

    @Test(dataProvider = "info")
    public void test1(String name,int i){
        System.out.println("姓名是："+name + " 年龄是："+i);
//        System.out.printf("ThreadID:%s%n",Thread.currentThread().getId());
    }

    @Test(dataProvider = "info")
    public void test2(String name,int i){
        System.out.println("姓名是："+name + " 年龄是："+i);
//        System.out.printf("ThreadID:%s%n",Thread.currentThread().getId());
    }

    @DataProvider(name = "info")
    public Object[][] methodData(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"lc",20},
                    {"XXX",10}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"中文",20},
                    {"中信",10}
            };
        }
        return result;
    }



}
