package cn.neusoft.service.imp;

import cn.neusoft.domain.kufang.KufangBack;
import cn.neusoft.domain.kufang.OrderReturn;
import cn.neusoft.mapper.KufangBackMapper;
import cn.neusoft.service.KufangBackService;
import cn.neusoft.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KufangBackServiceImp implements KufangBackService {
    @Autowired
    KufangBackMapper kufangBackMapper;
    @Override
    public Integer add(KufangBack kufangBack) {
        return kufangBackMapper.add(kufangBack);
    }

    @Override
    public List<OrderReturn> findbypage(PageBean pageBean) {
        return kufangBackMapper.findbypage(pageBean);
    }
}
