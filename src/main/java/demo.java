import org.testng.Assert;
import org.testng.annotations.Test;

public class demo {

    @Test
    public void TestSuccess(){
        System.out.println("演示1");
    }

    @Test
    public void TestFail(){

        Assert.assertEquals(1,2);
    }


}
