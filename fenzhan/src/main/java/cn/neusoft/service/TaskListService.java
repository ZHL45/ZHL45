package cn.neusoft.service;

import cn.neusoft.domain.fenzhan.TaskList;
import cn.neusoft.domain.fenzhan.OrderAll;
import cn.neusoft.packaging.TaskFind;

import java.util.List;

public interface TaskListService {
    List<TaskList> findbypage(TaskFind taskFind);//分页搜索+模糊查询

    List<TaskList> findbypage2(TaskFind taskFind);//分页搜索+模糊查询+联查
    List<TaskList> findbypage3(TaskFind taskFind);//分页搜索+模糊查询+联查
    OrderAll print(String o_id);//打印

    OrderAll find12378(String o_id);//打印

    List<OrderAll> all();
}
