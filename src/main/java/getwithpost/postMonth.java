package getwithpost;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.cookie.SetCookie;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Parameters;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RestController
@Api(value = "/",description = "POST方法")
@RequestMapping(value = "/post")
public class postMonth {

    public static Cookie cookie;

    private HttpServletRequest request;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){
        if (username.equals("lc") && password.equals("1193")){
            cookie = new Cookie("id","1193");
            response.addCookie(cookie);
            return "登录成功";
        }

        return "用户名或密码错误";

    }



    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取user数据",httpMethod = "POST")

    public String getUserList(HttpServletRequest request,
                            @RequestBody user user) {

        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies){
            if (c.getName().equals("id") && c.getValue().equals("1193"))
            {

                return user.toString();
            }

        }

        return "参数错误";
    }


}
