package cn.neusoft.controller;

import cn.neusoft.domain.Account;
import cn.neusoft.service.CaptchaService;
import cn.neusoft.service.impl.CaptchaServiceImpl;
import cn.neusoft.vo.ResultBean;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Api(value = "验证码模块的API",description="验证码相关的CRUD功能")
@RequestMapping
@RestController
public class CaptchaController {
    @Autowired
    CaptchaServiceImpl captchaServiceImpl;

    @PostMapping("/sendCaptcha/{phone}")
    @ApiOperation(value = "手机号登录/修改密码：发送验证码")
    public ResultBean sendCaptcha(@PathVariable("phone") String phoneNumber)
    {
//        System.out.println("测试配置notify=" + huanying);
//        Thread.sleep(10);
        return captchaServiceImpl.sendCaptcha(phoneNumber);
    }

//    // 限流与阻塞处理 : 参数要和 被降级的方法参数一样
//    public ResultBean exceptionHandler(@PathVariable("phone") String phoneNumber, BlockException ex) {
//        ex.printStackTrace();
//        System.out.println("限流");
//        return ResultBean.error(400,"访问次数太多，您已被限流");
//    }

    @PostMapping("/sendCaptchaReg/{phone}/{account}")
    @ApiOperation(value = "手机号注册账号：发送验证码")
    public ResultBean sendCaptchaReg(@PathVariable("phone") String phoneNumber,@PathVariable("account") String account)
    {
        return captchaServiceImpl.sendCaptchaReg(phoneNumber,account);
    }

    @PostMapping("/examineCaptchaLogin/{phone}/{captcha}")
    @ApiOperation(value = "手机号登录：验证验证码并登录")
    public ResultBean examineCaptchaLogin(@PathVariable("phone") String phoneNumber,@PathVariable("captcha") String captcha)
    {
        System.out.println("手机号:" + phoneNumber);
        System.out.println("验证码:" + captcha);
        return captchaServiceImpl.examineCaptchaLogin(phoneNumber,captcha);
    }

    @PostMapping("/examineCaptchaLookfor/{captcha}")
    @ApiOperation(value = "手机号修改密码：验证验证码并修改密码")
    public ResultBean examineCaptchaLookfor(@RequestBody Account account,@PathVariable("captcha") String captcha)
    {
        return captchaServiceImpl.examineCaptchaLookfor(account,captcha);
    }

    @PostMapping("/examineCaptchaReg/{captcha}")
    @ApiOperation(value = "手机号注册：验证验证码并注册账号")
    public ResultBean examineCaptchaReg(@RequestBody Account account,@PathVariable("captcha") String captcha)
    {
        return captchaServiceImpl.examineCaptchaReg(account,captcha);
    }


}
