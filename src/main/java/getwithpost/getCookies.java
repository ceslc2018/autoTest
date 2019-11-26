package getwithpost;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Policy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "GET方法")
public class getCookies {

    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    @ApiOperation(value = "获取cookie信息成功",httpMethod = "GET")
    public String getcookies(HttpServletResponse response){
        Cookie cookie = new Cookie("id","1193");
        response.addCookie(cookie);
        return "获取cookie信息成功";
    }

    @RequestMapping(value = "/getwithcookies",method = RequestMethod.GET)
    @ApiOperation(value = "需cookies才能访问",httpMethod = "GET")
    public String getwithcookies(HttpServletRequest request) {
            Cookie[] cookies =  request.getCookies();
            if(Objects.isNull(cookies)){
                return "需cookies才能访问";
            }

            for(Cookie cookie:cookies){
                if(cookie.getName().equals("id") && cookie.getValue().equals("1193")){
                    return "访问成功";
                }
            }

        return "需cookies才能访问";
    }

    @RequestMapping(value = "/getparam",method = RequestMethod.GET)
    @ApiOperation(value = "通过@RequestParam获取数据",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("中国",500);
        myList.put("上海",400);
        myList.put("虹桥",300);

        return myList;

    }

    @RequestMapping(value = "getmyparam/{start}/{end}")
    @ApiOperation(value = "通过@RequestParam获取数据",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("中国",500);
        myList.put("上海",400);
        myList.put("虹桥",300);

        return myList;

    }
}
