package cn.neusoft.service;

import cn.neusoft.domain.Account;
import cn.neusoft.vo.ResultBean;

public interface CaptchaService {
    //登录、修改密码：发送验证码
    ResultBean sendCaptcha(String phoneNumber);
    //注册：发送验证码
    ResultBean sendCaptchaReg(String phoneNumber,String account);
    //登录：判别验证码
    ResultBean examineCaptchaLogin(String phoneNumber,String captcha);
    //修改密码：判别验证码
    ResultBean examineCaptchaLookfor(Account account,String captcha);
    //注册账号：判别验证码
    ResultBean examineCaptchaReg(Account account, String captcha);
}
