package cn.neusoft.mapper;

import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.domain.EditOrderStatus;
import cn.neusoft.domain.Quehuofanhui;
import cn.neusoft.domain.Wuquehuo;
import cn.neusoft.query.ClientQuehuoQuery;
import cn.neusoft.query.DiaoduOrderQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderStatusMapper {
    Integer edit(String o_id);
    EditOrderStatus search(String o_id);
    Integer check(String clientname);

    List<Quehuofanhui> show();

    // 有缺货的客户
    List<Quehuofanhui> findByPage1(ClientQuehuoQuery clientQuehuoQuery);

    //  无缺货的客户
    List<Wuquehuo> findByPage2(ClientQuehuoQuery clientQuehuoQuery);

//    public List<Bill> findbypage(Bill bill);//分页+模糊搜索功能
}
