package cn.neusoft.service;

import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.ChukumingxiReturn;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.query.ChurukuMinxiQuery;
import cn.neusoft.vo.PageQueryBean;

import java.util.List;

public interface ChukudiaohuoService {
    Integer add(String p_name,String p_id,String num);
    PageQueryBean<ChukumingxiReturn> zxchukudan(ChurukuMinxiQuery churukuMinxiQuery);

    Integer editYujing(Zhongxin_yujing zhongxinYujing);

    List<Zhongxin_yujing> getYujing();
}
