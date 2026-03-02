package cn.neusoft.service.impl;

import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.mapper.OrderExchangeMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.service.OrderExchangeService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderExchangeServiceImpl implements OrderExchangeService {
    @Autowired
    OrderExchangeMapper orderExchangeMapper;

    @Override
    public Integer orderReturn(OrderReturn orderReturn){
        return orderExchangeMapper.orderReturn(orderReturn);
    }

    @Override
    public PageQueryBean<OrderExchange> findByPage(BaseQuery query) {
        //构建结果对象
        PageQueryBean<OrderExchange> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<OrderExchange> orderExchangeList = orderExchangeMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<OrderExchange> pageInfo = new PageInfo<>(orderExchangeList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }
}
