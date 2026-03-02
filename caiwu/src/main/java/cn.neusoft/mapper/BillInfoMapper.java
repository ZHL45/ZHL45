package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.domain.BillInfo;
import cn.neusoft.query.BaseQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillInfoMapper {
    Integer add(BillInfo billInfo);//添加发票信息

    public List<Bill> findByBatch(int batch);

    public Integer findBatch(int batch);

    public List<BillInfo> findByPage(BaseQuery query);//分页+模糊搜索功能

}
