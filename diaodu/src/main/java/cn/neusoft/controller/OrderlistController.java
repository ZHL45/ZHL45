package cn.neusoft.controller;

import cn.neusoft.domain.DiaoduCulue;
import cn.neusoft.query.DiaoduOrderQuery;
import cn.neusoft.service.serviceImplement.OrderlistServiceImp;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderlist")
@Api(value = "调度模块的API",description="订单的自动手动调度")
public class OrderlistController {

    @Autowired
    OrderlistServiceImp orderlistServiceImp;

    @PostMapping("/findByPage")
    @ApiOperation(value = "订单列表展示粗略所有+模糊查询")
    public ResultBean findByPage(@RequestBody DiaoduOrderQuery diaoduOrderQuery)
    {
        PageQueryBean<DiaoduCulue> pageQueryBean = orderlistServiceImp.findByPage(diaoduOrderQuery);
        return ResultBean.success(pageQueryBean);
    }

    @PostMapping("/findByPageXiangqing/{oid}")
    @ApiOperation(value = "详情展示某个订单")
    public ResultBean findByPage(@PathVariable("oid")String oid)
    {
        return ResultBean.success(orderlistServiceImp.show(oid));

    }


    @PostMapping("/shoudongFz/{o_id}/{fzname}")
    @ApiOperation(value = "手动选择某个订单的分站")
    public ResultBean shoudong(@PathVariable("o_id")String o_id,@PathVariable("fzname")String fzname)
    {
        return ResultBean.success(orderlistServiceImp.shoudong(o_id,fzname));

    }

    // 只把可调度的来选择分站
    @PostMapping("/zidongFz}")
    @ApiOperation(value = "自动调度所有订单的分站")
    public ResultBean autoDiaodu()
    {
        return ResultBean.success(orderlistServiceImp.autoDiaodu());

    }
    // 只把可调度的置为空
    @PostMapping("/zidongFz2}")
    @ApiOperation(value = "自动调度所有订单的分站--置为空")
    public ResultBean autoDiaodu2()
    {
        return ResultBean.success(orderlistServiceImp.autoDiaodu2());

    }
}
