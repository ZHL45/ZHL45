package cn.neusoft.mapper;

import cn.neusoft.domain.fenzhan.TaskList;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.packaging.TaskFind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskListMapper {
    List<TaskList> findbypage(TaskFind taskFind);//分页搜索+模糊查询
    List<TaskList> findbypage2(TaskFind taskFind);//分页搜索+模糊查询+联查
    List<TaskList> findbypage3(TaskFind taskFind);//分页搜索+模糊查询+联查
//    List<TaskList> findbypage4(String o_id);//分页搜索+模糊查询+联查
    OrderAll print(String o_id);//打印
    OrderAll find12378(String o_id);//打印

    List<OrderAll> all();
}
