package cn.neusoft.service.imp;

import cn.neusoft.domain.kufang.Kufangfzback;
import cn.neusoft.mapper.KufangfzbackMapper;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.service.KufangfzbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KufangfzbackServiceImp implements KufangfzbackService {
    @Autowired
    KufangfzbackMapper kufangfzbackMapper;
    @Override
    public Integer add(Kufangfzback kufangfzback) {
        return kufangfzbackMapper.add(kufangfzback);
    }

    @Override
    public Integer add2(Kufangfzback kufangfzback) {
        return kufangfzbackMapper.add2(kufangfzback);
    }

    @Override
    public Integer add3(Kufangfzback kufangfzback) {
        return kufangfzbackMapper.add3(kufangfzback);
    }

    @Override
    public Integer add4(String integer) {
        return kufangfzbackMapper.add4(integer);
    }

    @Override
    public List<Kufangfzback> findbypage(GoodChangeFind goodChangeFind) {
        return kufangfzbackMapper.findbypage(goodChangeFind);
    }

    @Override
    public List<Kufangfzback> findbypage2(GoodChangeFind goodChangeFind) {
        return kufangfzbackMapper.findbypage2(goodChangeFind);
    }

    @Override
    public List<Kufangfzback> findbypage3(GoodChangeFind goodChangeFind) {
        return kufangfzbackMapper.findbypage3(goodChangeFind);
    }

    @Override
    public List<Kufangfzback> findbypage4(GoodChangeFind goodChangeFind) {
        return kufangfzbackMapper.findbypage4(goodChangeFind);
    }

    @Override
    public Integer add_follow(String o_id) {
        return kufangfzbackMapper.add_follow(o_id);
    }

    @Override
    public Integer add2_follow(String test) {
        return kufangfzbackMapper.add2_follow(test);
    }

    @Override
    public Integer add3_follow(String test) {
        return kufangfzbackMapper.add3_follow(test);
    }

    @Override
    public Integer findcid(String cname) {
        System.out.println("找id");
        return kufangfzbackMapper.findcid(cname);
    }

    @Override
    public String findcunit(String cname) {
        return kufangfzbackMapper.findcunit(cname);
    }

    @Override
    public String findclass(String cname) {
        return kufangfzbackMapper.findclass(cname);
    }

    @Override
    public Date finddate(String o_l_id) {
        return kufangfzbackMapper.finddate(o_l_id);
    }

    @Override
    public Integer uptui(Kufangfzback kufangfzback) {
        return kufangfzbackMapper.uptui(kufangfzback);
    }
}
