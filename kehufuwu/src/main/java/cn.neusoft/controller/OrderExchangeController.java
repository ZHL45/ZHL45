package cn.neusoft.controller;
import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.OrderExchangeQuery;
import cn.neusoft.service.impl.OrderExchangeServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;


@Api(value = "换货订单信息模块的API",description = "换货订单信息相关的CRUD功能")
@RestController
@RequestMapping("/orderExchange")
public class OrderExchangeController {
    @Autowired
    OrderExchangeServiceImpl orderExchangeServiceimpl;

    @PostMapping
    @ApiOperation(value = "换货订单信息的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody OrderExchangeQuery orderExchangeQuery)
    {
        PageQueryBean<OrderExchange> pageQueryBean = orderExchangeServiceimpl.findByPage(orderExchangeQuery);
        return ResultBean.success(pageQueryBean);
    }

    @PostMapping("/orderReturn")
    @ApiOperation(value = "换货订单进行退货")
    public ResultBean findById(@RequestBody OrderReturn orderReturn)
    {
        if(orderExchangeServiceimpl.orderReturn(orderReturn) == 1){
            return ResultBean.success("已生成退货单",null);
        }
        return ResultBean.fail(500,"生成退货单失败");
    }
}
