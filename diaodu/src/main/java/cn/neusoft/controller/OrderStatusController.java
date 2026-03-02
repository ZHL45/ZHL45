package cn.neusoft.controller;

import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.domain.Quehuofanhui;
import cn.neusoft.domain.Wuquehuo;
import cn.neusoft.query.ClientQuehuoQuery;
import cn.neusoft.query.DiaoduOrderQuery;
import cn.neusoft.service.serviceImplement.OrderStatusServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OrderStatus")
@Api(value = "调度模块的API",description="订单的状态修改")
public class OrderStatusController {
    int is_quehuoClient=0;
    @Autowired
    OrderStatusServiceImp orderStatusServiceImp;

    // 修改
    @PostMapping("/edit/{o_id}")
    @ApiOperation(value = "修改订单状态")
    public ResultBean edit(@PathVariable("o_id") String o_id)
    {

        return ResultBean.success(orderStatusServiceImp.edit(o_id));
    }

//    @PostMapping("/search")
//    public ResultBean search(String o_id)
//    {
//        return ResultBean.success(orderStatusServiceImp.search(o_id));
//    }

    @PostMapping("/check")
    @ApiOperation(value = "检查是否是缺货客户")
    public ResultBean check(@RequestBody ClientQuehuoQuery clientQuehuoQuery)
    {
        String clientname = clientQuehuoQuery.getClient_name();
        int result = orderStatusServiceImp.check(clientname);
        System.out.println("检查sql语句的返回值是"+result);
        if (result!=0){
            // 是缺货客户
            is_quehuoClient=1;
            System.out.println(is_quehuoClient);
            return ResultBean.success(is_quehuoClient);
        }
        else {
            // 非缺货客户
            is_quehuoClient=0;
            System.out.println(is_quehuoClient);
            return ResultBean.success(is_quehuoClient);
        }
    }

    @GetMapping("/show")
    @ApiOperation(value = "初始页面")
    public ResultBean show()
    {
        return ResultBean.success(orderStatusServiceImp.show());
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "两种展示该客户是否有取货订单+模糊查询")
    public ResultBean findByPagestatus(@RequestBody ClientQuehuoQuery clientQuehuoQuery)
    {
        // 先查是否为缺货客户，返回值
        // 若有缺货，返回List<Quehuofanhui>
        if (is_quehuoClient==1){
            PageQueryBean<Quehuofanhui> pageQueryBean = orderStatusServiceImp.findByPage1(clientQuehuoQuery);
            return ResultBean.success(pageQueryBean);
        }
        else {
            // 若无缺货，返回List<Wuquehuo>
            PageQueryBean<Wuquehuo> pageQueryBean = orderStatusServiceImp.findByPage2(clientQuehuoQuery);
            return ResultBean.success(pageQueryBean);
        }
    }


}
