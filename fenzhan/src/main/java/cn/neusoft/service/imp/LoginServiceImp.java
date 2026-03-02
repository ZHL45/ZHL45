package cn.neusoft.service.imp;

import cn.neusoft.domain.User;
import cn.neusoft.mapper.LoginMapper;
import cn.neusoft.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    LoginMapper loginMapper;


    @Override
    public int add(User user) {
        return loginMapper.add(user);
    }

    @Override
    public boolean exist(User user) {
        return loginMapper.exist(user)==1;
    }

    @Override
    public User findbyid(String id) {
        return loginMapper.findbyid(id);
    }
}
