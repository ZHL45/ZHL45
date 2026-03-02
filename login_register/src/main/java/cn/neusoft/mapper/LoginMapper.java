package cn.neusoft.mapper;

import cn.neusoft.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //检查是否有输入的账号
    Integer findByAccount(String account);
    //检查是否有输入的手机号
    Integer findByPhone(String phone);
    //账号/手机号检测通过，检测密码是否正确
    Account loginByPsd(Account account);
}
