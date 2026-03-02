package cn.neusoft.mapper;

import cn.neusoft.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public int add(User user);//注册功能，添加用户

    public int exist(User user);//判断账号是否已经存在，若存在返回1，不存在返回0

    public User findbyid(String id);//通过id查询用户信息

}
