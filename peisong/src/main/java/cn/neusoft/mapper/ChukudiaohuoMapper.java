package cn.neusoft.mapper;

import cn.neusoft.domain.Chukumingxi;
import cn.neusoft.domain.ChukumingxiReturn;
import cn.neusoft.domain.Dingdanpaihang;
import cn.neusoft.domain.Zhongxin_yujing;
import cn.neusoft.query.ChurukuMinxiQuery;
import cn.neusoft.query.DingdanpaihangQuery;
import cn.neusoft.query.YujingQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChukudiaohuoMapper {
    Integer add(String p_name,String p_id,String num);
    List<ChukumingxiReturn> zxchukudan(ChurukuMinxiQuery churukuMinxiQuery);
    Integer editYujing(Zhongxin_yujing zhongxinYujing);
    List<Zhongxin_yujing> getYujing();

    List<Zhongxin_yujing> findByPage(YujingQuery yujingQuery);


}
