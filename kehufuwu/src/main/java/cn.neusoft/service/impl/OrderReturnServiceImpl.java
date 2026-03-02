package cn.neusoft.service.impl;


import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.mapper.OrderReturnMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.service.OrderReturnService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderReturnServiceImpl implements OrderReturnService {
    @Autowired
    OrderReturnMapper orderReturnMapper;

    @Override
    public PageQueryBean<OrderReturn> findByPage(BaseQuery query) {
        //构建结果对象
        PageQueryBean<OrderReturn> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<OrderReturn> orderReturnList = orderReturnMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<OrderReturn> pageInfo = new PageInfo<>(orderReturnList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }
}
