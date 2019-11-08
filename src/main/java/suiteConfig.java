import org.testng.annotations.*;

public class suiteConfig {

    @BeforeTest
    public void beforeTest(){
        System.out.println("正式测试之前");
    }

    @AfterTest
    public  void afterTest(){
        System.out.println("正式测试结束");
    }

    @BeforeGroups("print")
    public void beforeGroups(){
        System.out.println("分组测试之前");
    }

    @AfterGroups("ces")
    public void afterGroups(){
        System.out.println("分组测试之后");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("测试套件开始");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("测试套件结束");
    }
}
