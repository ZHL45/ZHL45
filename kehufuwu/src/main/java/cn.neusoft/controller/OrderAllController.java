package cn.neusoft.controller;

import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.domain.order.OrderExchange;
import cn.neusoft.domain.order.OrderLack;
import cn.neusoft.domain.order.OrderReturn;
import cn.neusoft.query.OrderAllQuery;
import cn.neusoft.service.impl.OrderAllServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "正常订单信息模块的API",description = "正常订单信息相关的CRUD功能")
@RestController
@RequestMapping("/orderAll")
public class OrderAllController {
    @Autowired
    OrderAllServiceImpl orderAllServiceimpl;

    @GetMapping("/getOrderId/{id}/{type}")
    @ApiOperation(value = "获取订单编号信息")
    public ResultBean add(@PathVariable("id") String c_id,@PathVariable("type") String type)
    {
        return ResultBean.success(orderAllServiceimpl.getOrderId(c_id,type));
    }

    @PostMapping
    @ApiOperation(value = "新增订单信息")
    public ResultBean add(@RequestBody OrderAll orderAll)
    {
        String date = orderAll.getO_date();
        System.out.println("时间：" + date);
        String time1 = date.substring(0,10);
        String time2 = date.substring(11,19);
        String time3 = time1 + " " + time2;
//        System.out.println(time1 + " " + time2);
        orderAll.setO_date(time3);
        System.out.println("时间：" + time3);
        return ResultBean.success(orderAllServiceimpl.add(orderAll));
    }

    @PutMapping
    @ApiOperation(value = "修改订单信息")
    public ResultBean update(@RequestBody OrderAll orderAll)
    {
        return ResultBean.success(orderAllServiceimpl.update(orderAll));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "通过id删除订单信息")
    public ResultBean delete(@PathVariable("id") String id)
    {
        Integer integer= orderAllServiceimpl.delete(id);
//        if(integer==1)
        return ResultBean.success("删除成功",integer);
//        return ResultBean.fail(500,"没有该记录");
    }

    @PutMapping("/changeAfterSales")
    @ApiOperation(value = "通过id修改订单售后类型为 已取消")
    public ResultBean change(@RequestBody OrderAll orderAll)
    {
        Integer integer= orderAllServiceimpl.changeAfterSales(orderAll);
//        if(integer==1)
        return ResultBean.success("取消成功",integer);
//        return ResultBean.fail(500,"没有该记录");
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "订单信息的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody OrderAllQuery orderAllQuery)
    {
        PageQueryBean<OrderAll> pageQueryBean = orderAllServiceimpl.findByPage(orderAllQuery);
        return ResultBean.success(pageQueryBean);
    }

    @PostMapping("/orderExchange")
    @ApiOperation(value = "生成换货订单")
    public ResultBean orderExchange(@RequestBody OrderExchange orderExchange){
        if(orderAllServiceimpl.orderExchange(orderExchange) == 1){
            return ResultBean.success("已生成换货单",null);
        }
        return ResultBean.fail(500,"生成换货单失败");
    }

    @PostMapping("/orderReturn")
    @ApiOperation(value = "生成退货订单")
    public ResultBean orderReturn(@RequestBody OrderReturn orderReturn){
        if(orderAllServiceimpl.orderReturn(orderReturn) == 1){
            return ResultBean.success("已生成退货单",null);
        }
        return ResultBean.fail(500,"生成退货单失败");
    }

    @PostMapping("/orderLack")
    @ApiOperation(value = "生成缺货单")
    public ResultBean orderLack(@RequestBody OrderLack orderLack){
        if(orderAllServiceimpl.orderLack(orderLack) == 1){
            return ResultBean.success("已生成缺货单",null);
        }
        return ResultBean.fail(500,"生成缺货单失败");
    }

}
