package cn.neusoft.service.impl;


import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderLack;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.mapper.OrderAllMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.service.OrderAllService;
import cn.neusoft.utils.OrderUtils;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAllServiceImpl implements OrderAllService {
    @Autowired
    OrderAllMapper orderAllMapper;
    @Override
    public Integer add(OrderAll orderAll) {
        orderAll.setO_afterSales("正常");
        return orderAllMapper.add(orderAll);
    }

    @Override
    public Integer delete(String id) {
        return orderAllMapper.delete(id);
    }

    @Override
    public Integer update(OrderAll orderAll) {
        return orderAllMapper.update(orderAll);
    }

    @Override
    public Integer changeAfterSales(OrderAll orderAll){
        orderAll.setO_afterSales("已取消");
        return orderAllMapper.changeAfterSales(orderAll);
    }

    @Override
    public PageQueryBean<OrderAll> findByPage(BaseQuery query) {
        //构建结果对象
        PageQueryBean<OrderAll> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<OrderAll> orderAllList = orderAllMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<OrderAll> pageInfo = new PageInfo<>(orderAllList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    @Override
    public Integer orderExchange(OrderExchange orderExchange) {
        return orderAllMapper.orderExchange(orderExchange);
    }

    @Override
    public Integer orderReturn(OrderReturn orderReturn) {
        return orderAllMapper.orderReturn(orderReturn);
    }

    @Override
    public Integer orderLack(OrderLack orderLack){
        return orderAllMapper.orderLack(orderLack);
    }

    //根据客户id生成订单编号
    @Override
    public String getOrderId(String c_id,String type){
        Integer user_id = Integer.parseInt(c_id);
        if(type.equals("退货")){
            return OrderUtils.getReturnCode(user_id);
        }else if(type.equals("换货")){
            return OrderUtils.getExchangeCode(user_id);
        }else {
            return OrderUtils.getOrderCode(user_id);
        }
    }

}
