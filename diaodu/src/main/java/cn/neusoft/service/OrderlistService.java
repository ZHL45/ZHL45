package cn.neusoft.service;

import cn.neusoft.domain.DiaoduShowXiangqing;

public interface OrderlistService {
    DiaoduShowXiangqing search(String id);

    DiaoduShowXiangqing show(String id);

}
