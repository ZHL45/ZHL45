package cn.neusoft.mapper;

import cn.neusoft.domain.kufang.KufangBack;
import cn.neusoft.domain.kufang.OrderReturn;
import cn.neusoft.vo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KufangBackMapper {
    Integer add(KufangBack kufangBack);//添加
    List<OrderReturn> findbypage(PageBean pageBean);//退货
}
