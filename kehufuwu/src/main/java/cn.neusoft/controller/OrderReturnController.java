package cn.neusoft.controller;
import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.OrderReturnQuery;
import cn.neusoft.service.impl.OrderExchangeServiceImpl;
import cn.neusoft.service.impl.OrderReturnServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "退货订单信息模块的API",description = "退货订单信息相关的CRUD功能")
@RestController
@RequestMapping("/orderReturn")
public class OrderReturnController {
    @Autowired
    OrderReturnServiceImpl orderReturnServiceimpl;

    @PostMapping
    @ApiOperation(value = "退货订单信息的分页展示+条件查询")
    public ResultBean findByPage(@RequestBody OrderReturnQuery orderReturnQuery)
    {
        PageQueryBean<OrderReturn> pageQueryBean = orderReturnServiceimpl.findByPage(orderReturnQuery);
        return ResultBean.success(pageQueryBean);
    }
}
