import org.testng.annotations.*;


public class demo {

    @Test
    public void Success(){
        System.out.println("演示");
//        throw new RuntimeException();

    }

    @Test
    @Parameters({"a","b"})
    public  void Fail(int a,int b){

        if (a > b){
            System.out.println("a>b" + " 其中 a=" + a + " b=" + b);
        }else if (a < b){
            System.out.println("a<b" + " 其中 a=" + a + " b=" + b);
            }else{
            System.out.println("a=b" + " 其中 a=" + a + " b=" + b);
        }
//        System.out.printf("ThreadID:%s%n",Thread.currentThread().getId());

    }

    }
