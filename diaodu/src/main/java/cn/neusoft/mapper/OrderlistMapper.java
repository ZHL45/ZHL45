package cn.neusoft.mapper;

import cn.neusoft.domain.Diaobo_order;
import cn.neusoft.domain.DiaoduShowXiangqing;
import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.query.DiaoduOrderQuery;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderlistMapper {
    DiaoduShowXiangqing search(String id);//  搜索

    DiaoduShowXiangqing show(String oid);//  展示

    List<DiaoduCulue> findByPage(DiaoduOrderQuery diaoduOrderQuery);

    Integer shoudong(String p_id,String fzname);

    Integer autoDiaodu();

    Integer autoDiaodu2();
    Integer autoeditO_state();
    Integer redoAutoeditO_state();
    Integer fuzhi();
    Integer shanchu();

    Diaobo_order get(String p_id);

    Integer insert(Diaobo_order diaoboOrder);
    Integer check2(String d_id);

    Integer deleteid(String d_id);

    Integer editO_state(String o_id);
}
