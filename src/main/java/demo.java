import org.testng.Assert;
import org.testng.annotations.Test;

public class demo {

    @Test
    public void Success(){
        System.out.println("演示1");
    }

    @Test
    public void Fail(){

        Assert.assertEquals(1,2);
    }


}
