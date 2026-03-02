package cn.neusoft.service.imp;

import cn.neusoft.domain.fenzhan.FenzhanState;
import cn.neusoft.mapper.FenzhanStateMapper;
import cn.neusoft.service.FenzhanStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FenzhanStateServiceImp implements FenzhanStateService {
    @Autowired
    FenzhanStateMapper fenzhanStateMapper;
    @Override
    public Integer add(FenzhanState fenzhanState) {
        return fenzhanStateMapper.add(fenzhanState);
    }

    @Override
    public Integer exist(String tid) {
        return fenzhanStateMapper.exist(tid);
    }

    @Override
    public Integer update(FenzhanState fenzhanState) {
        return fenzhanStateMapper.update(fenzhanState);
    }
}
