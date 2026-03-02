package cn.neusoft.service;

import cn.neusoft.domain.Offerer;

public interface OffererService {
    Integer add(Offerer offerer);

    Integer edit(Offerer offerer);

    Offerer search(String cname);

    Integer delete(String cid);
}
