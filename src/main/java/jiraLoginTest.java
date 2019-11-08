import org.testng.annotations.Test;

@Test(timeOut = 1000)
public class jiraLoginTest {

    public void Login() throws InterruptedException {
        System.out.println("测试演示");
        Thread.sleep(2000);
        System.out.printf("ThreadID:%s%n",Thread.currentThread().getId());

    }
}

