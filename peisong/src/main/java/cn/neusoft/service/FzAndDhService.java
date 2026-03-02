package cn.neusoft.service;

import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.ChukumingxiReturn;
import cn.neusoft.domain.Dingdanpaihang;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.query.DingdanpaihangQuery;

import java.util.List;

public interface FzAndDhService {
    public List<Dingdanpaihang> findByPage(DingdanpaihangQuery dingdanpaihangQuery);
}
