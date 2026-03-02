package cn.neusoft.service.impl;

import cn.neusoft.domain.Account;
import cn.neusoft.mapper.LoginMapper;
import cn.neusoft.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Account login(Account account){
        Account account1 = new Account("","","","");
        if(account.getAccount() != ""){
            //检查是否有输入的账号
            System.out.println("检查账号");
            Integer account_examine = loginMapper.findByAccount(account.getAccount());
            if (account_examine == null){
                account1.setAccount("您输入的账号有误");
                return account1;
            }
        }
        //检测密码
        Account account2 = loginMapper.loginByPsd(account);
        System.out.println(account2);
        if(account2 == null){
            account1.setAccount("您输入的密码有误");
            return account1;
        }
        return account2;
    }
}
