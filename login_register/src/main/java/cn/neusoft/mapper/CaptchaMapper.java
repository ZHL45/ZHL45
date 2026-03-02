package cn.neusoft.mapper;

import cn.neusoft.domain.Account;
import cn.neusoft.domain.OperatorInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaptchaMapper {
    //检索手机号是否存在
    Account findByPhone(String phoneNumber);

    Integer register(Account account);

    Integer changePsd(Account account);

    //添加客服信息
    Integer addKefu(OperatorInfo operatorInfo);
}
