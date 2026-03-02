package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {
    Integer add(Bill bill);//添加记录
    Integer delete(Bill bill);//删除记录
    public List<Bill> findbypage(Bill bill);//分页+模糊搜索功能

//    List<Bill> findall();//联查测试

    List<Bill> findall2();//发票联查

    List<Bill> findbypage2(Bill bill);//联查+分页+模糊搜索
}
