import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class httpClient {

    private String url,uri;
    private CookieStore store;
    private String testUrl;
    private String result;
    private String responsePost;

    @BeforeTest
    public void befoerTest(){
        ResourceBundle bundle = ResourceBundle.getBundle("config",Locale.CHINA);
        url = bundle.getString("test.url");
        uri = bundle.getString("uri");
        testUrl = this.url + this.uri;
    }

    @Test
    public void test() throws IOException{
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),Charset.defaultCharset());
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie:cookieList){
            String cookie_name = cookie.getName();
            String cookie_value = cookie.getValue();
            System.out.println("cookie_name=" + cookie_name + " cookie_value=" + cookie_value);
        }

    }

    @Test(dependsOnMethods = "test")
    public void withcookies() throws IOException{
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode=" + statusCode);

        if(statusCode == 200){
            result = EntityUtils.toString(response.getEntity(),Charset.defaultCharset());
            System.out.println(result);
        }
    }

//    @Test(dependsOnMethods = "test")
//    public void  testPost() throws IOException{
//        HttpPost post = new HttpPost(testUrl);
//        DefaultHttpClient client1 = new DefaultHttpClient();
//        HttpResponse response = client1.execute(post);
//        System.out.println(response);
//        JSONObject param = new JSONObject();
//        param.put("name","lc");
//        param.put("id","1193");
//        post.setHeader("content-type","application/json");
//        StringEntity entity = new StringEntity(param.toString(),Charset.defaultCharset());
//        post.setEntity(entity);
//        client1.setCookieStore(this.store);
//        client1.execute(post);
//
//        JSONObject resultjson = new JSONObject(response);
//        String success = (String) resultjson.get("name");
//        String id = (String) resultjson.get("id");
//        Assert.assertEquals("success",success);
//        Assert.assertEquals("1193",id);
//
//        }

}
