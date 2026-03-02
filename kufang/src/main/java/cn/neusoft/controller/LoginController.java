package cn.neusoft.controller;

import cn.neusoft.domain.User;
import cn.neusoft.service.imp.LoginServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
Login函数介绍：
add(User user)//注册功能，调用此函数可以注册账号，需要传递：id，psd，role
exist(String id)//判断账号是否已经存在，固定返回json数据，若存在在data中返回true，不存在在data中返回false
findbyid(String id)//通过id查找用户相关信息，固定返回json数据
check(String id,String psd)//检查用户名，密码是否匹配 ，固定返回json数据，若匹配在data中返回true，不匹配在data中返回false


注意！！！！！！！！！！！！
在使用findbyid或check函数前，一定要使用exist函数检测id是否有效，传入无效id会崩溃！！！！！！
 */
@RestController
@RequestMapping("/login")
@Api(description = "之前做的注册登录功能，现在可能用不到")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @GetMapping("/add")
    public ResultBean add(User user)//注册功能，调用此函数可以注册账号，需要传递：id，psd，role
    {
        return ResultBean.success(loginServiceImp.add(user));
    }


    @GetMapping("/exist")
    public ResultBean exist(String id)//判断账号是否已经存在，固定返回json数据，若存在在data中返回true，不存在在data中返回false
    {
        return ResultBean.success(loginServiceImp.exist(id));
    }


    @GetMapping("/findbyid")
    public ResultBean findbyid(String id)//通过id查找用户相关信息，固定返回json数据
    {
        return ResultBean.success(loginServiceImp.findbyid(id));
    }

    @GetMapping("/check")
    public ResultBean check(User user)//检查用户名，密码，用户类型是否匹配 ，固定返回json数据，若匹配在data中返回true，不匹配在data中返回false
    {
        String id=user.getId();
        boolean result=loginServiceImp.findbyid(id).getPsd().equals(user.getPsd())&&loginServiceImp.findbyid(id).getRole().equals(user.getRole());
        if(result)
        {
            return ResultBean.success(result);
        }
        return ResultBean.fail(500,"账号密码不匹配或用户选择错误",false);

    }


}
