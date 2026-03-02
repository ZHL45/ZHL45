package cn.neusoft.controller;

import cn.neusoft.domain.Account;
import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.service.impl.LoginServiceImpl;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "账号密码登录模块的API",description="登录相关的CRUD功能")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImpl loginServiceImpl;

    @PostMapping
    @ApiOperation(value = "通过账号密码登录")
    public ResultBean add(@RequestBody Account account)
    {
        Account account1 = loginServiceImpl.login(account);
        if(account1.getRole().equals("")){
            //说明没得到角色，没登录成功
            return ResultBean.fail(400,account1.getAccount());
        }else {
            //得到角色，登录成功
            return ResultBean.success("登录成功",account1);
        }
    }
}
