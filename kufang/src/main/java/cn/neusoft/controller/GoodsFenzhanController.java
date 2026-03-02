package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.FenzhanState;
import cn.neusoft.domain.kufang.GoodsFenzhan;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Goods_find;
import cn.neusoft.service.imp.GoodsFenzhanServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/goodsfenzhan")
@Api(description = "分站库房货物出入货")
public class GoodsFenzhanController {
    @Autowired
    GoodsFenzhanServiceImp goodsFenzhanServiceImp;

    @Autowired
    FenzhanStateController fenzhanStateController;

    @PostMapping("/add")//入库
    @ApiOperation("分站仓库入库，传入参数：调拨单号allocateid、商品代码cid、商品名称cname、计量单位measure_unit、入库数量cnum、任务号tid")
    public ResultBean add(@RequestBody GoodsFenzhan goodsFenzhan){
        goodsFenzhanServiceImp.add_follow1(goodsFenzhan);
        goodsFenzhan.setDate(new Date());
        goodsFenzhanServiceImp.updatestate(goodsFenzhan.getTid());
        fenzhanStateController.update(new FenzhanState(goodsFenzhan.getTid().toString(),"可分配"));

        return ResultBean.success(goodsFenzhanServiceImp.add(goodsFenzhan));
    }

    @PostMapping("/add2")//出库
    @ApiOperation("分站仓库出库？？，传入参数：调拨单号allocateid、商品代码cid、商品名称cname、计量单位measure_unit、出库数量cnum、任务号tid")
    public ResultBean add2(@RequestBody GoodsFenzhan goodsFenzhan){
        goodsFenzhan.setCnum(-1* goodsFenzhan.getCnum());
        goodsFenzhan.setDate(new Date());
        return ResultBean.success(goodsFenzhanServiceImp.add2(goodsFenzhan));
    }

    @PostMapping("/findbypage")//查询入库情况，传入开始时间、结束时间
    @ApiOperation("查询入库情况 传入参数：开始时间start、结束时间end、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage(@RequestBody GoodChangeFind goodChangeFind)
    {
        return ResultBean.success(goodsFenzhanServiceImp.findbypage(goodChangeFind));
    }

    @PostMapping("/findbypage2")//查询入库情况，传入开始时间、结束时间
    @ApiOperation("查询出库情况 传入参数：开始时间start、结束时间end、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage2(@RequestBody GoodChangeFind goodChangeFind)
    {
        return ResultBean.success(goodsFenzhanServiceImp.findbypage2(goodChangeFind));
    }

    @PostMapping("/findbypage4")
    @ApiOperation("查询领货情况 传入参数：开始时间start、结束时间end、类型type=调拨出库、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage4(@RequestBody Goods_find goods_find)
    {
        return ResultBean.success(goodsFenzhanServiceImp.findbypage4(goods_find));
    }

    @GetMapping("/update/{integer}")
    @ApiOperation("将订单、任务单状态修改为已领货")
    public ResultBean update(@PathVariable("integer") String integer)
    {
        goodsFenzhanServiceImp.updatevo(integer);
        fenzhanStateController.update(new FenzhanState(integer.toString(),"已领货"));
        Integer integer1=goodsFenzhanServiceImp.updatestate2(integer);
        return ResultBean.success("修改成功");
    }


}
