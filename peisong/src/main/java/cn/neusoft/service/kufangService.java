package cn.neusoft.service;

import cn.neusoft.domain.KucunTuihuo;
import cn.neusoft.domain.Peisong_ku;
import cn.neusoft.vo.PageBean;
import cn.neusoft.vo.PageQueryBean;

public interface kufangService {
    Integer add(Peisong_ku peisongKufang);

    Integer edit(Peisong_ku peisongKufang);

    Peisong_ku search(String cname);

    Integer delete(String cname);


}
