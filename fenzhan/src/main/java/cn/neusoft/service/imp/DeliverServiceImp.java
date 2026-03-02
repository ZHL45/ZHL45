package cn.neusoft.service.imp;

import cn.neusoft.domain.fenzhan.Deliver;
import cn.neusoft.mapper.DeliverMapper;
import cn.neusoft.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverServiceImp implements DeliverService {
    @Autowired
    DeliverMapper deliverMapper;
    @Override
    public Integer add(Deliver deliver) {
        return deliverMapper.add(deliver);
    }

    @Override
    public Integer update(String string) {
        return deliverMapper.update(string);
    }
}
