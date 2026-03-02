package cn.neusoft.service;

import cn.neusoft.domain.User;

public interface LoginService {

    public int add(User user);//注册功能，调用此函数可以注册账号，需要传递：id，psd，role

    public boolean exist(User user);//判断账号是否已经存在，若存在返回true，不存在返回false

    public User findbyid(String id);//通过账号查找用户信息（方便接下来验证用户密码是否匹配）
}
