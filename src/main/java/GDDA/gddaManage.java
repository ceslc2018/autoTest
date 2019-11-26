package GDDA;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

@RestController
@Api(value = "/",description = "档案整理")
public class gddaManage {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    public String add(){
        return "新增成功";

    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ApiOperation(value = "删除")
    public String delete(){
        return "删除成功";
    }

}
