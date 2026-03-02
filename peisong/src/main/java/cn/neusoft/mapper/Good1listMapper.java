package cn.neusoft.mapper;

import cn.neusoft.domain.Shangpin1;
import cn.neusoft.domain.Shangpin11;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Good1listMapper {
    Integer add(Shangpin1 shangpin1);
    Integer edit(Shangpin11 shangpin11);
    Integer delete(String cid);
    List<Shangpin1> findByPage(BaseQuery query);



//    public List<Bill> findbypage(Bill bill);//分页+模糊搜索功能
}
