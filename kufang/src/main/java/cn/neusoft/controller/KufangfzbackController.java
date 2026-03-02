package cn.neusoft.controller;

import cn.neusoft.domain.kufang.Goods_Total;
import cn.neusoft.domain.kufang.Kufangfzback;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.service.imp.KufangfzbackServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/return")
@Api(description = "中心、分站退货登记")
public class KufangfzbackController {
    @Autowired
    KufangfzbackServiceImp kufangfzbackServiceImp;

    @Autowired
    GoodsTotalController goodsTotalController;

    @PostMapping("/add")
    @ApiOperation("”退货登记“ 传入参数：订单号allocateid（之前的o_id，下同）、商品名称cname、商品数量cnum、类型type=退货出库")
    public ResultBean add(@RequestBody Kufangfzback kufangfzback)//分站库房退货登记
    {
        kufangfzback.setCunit(kufangfzbackServiceImp.findcunit(kufangfzback.getCname()));
        kufangfzback.setCid(kufangfzbackServiceImp.findcid(kufangfzback.getCname()).toString());
        kufangfzbackServiceImp.add_follow(kufangfzback.getAllocateid().toString());
        if (kufangfzback.getDate()==null)
            kufangfzback.setDate(new Date());
        if (kufangfzback.getType()==null)
            kufangfzback.setType("退货出库");
        return ResultBean.success(kufangfzbackServiceImp.add(kufangfzback));
    }

    @PostMapping("/add2")
    @ApiOperation("分站库房退货登记 传入参数：订单号allocateid、商品名称cname、商品数量cnum、类型type=退货出库")
    public ResultBean add2(@RequestBody Kufangfzback kufangfzback)//中心库房退货入库登记
    {
        kufangfzback.setCunit(kufangfzbackServiceImp.findcunit(kufangfzback.getCname()));
        kufangfzback.setCid(kufangfzbackServiceImp.findcid(kufangfzback.getCname()).toString());
        kufangfzbackServiceImp.add2_follow(kufangfzback.getAllocateid());
        if (kufangfzback.getDate()==null)
            kufangfzback.setDate(new Date());
        if (kufangfzback.getType()==null)
            kufangfzback.setType("退货入库");
        Goods_Total goodsTotal=new Goods_Total(kufangfzback.getCid(),kufangfzback.getCnum());
        goodsTotalController.add(goodsTotal);
        return ResultBean.success(kufangfzbackServiceImp.add2(kufangfzback));
    }

    @PostMapping("/add3")
    @ApiOperation("中心库房退货入库登记 传入参数：订单号allocateid、商品名称cname、商品数量cnum、类型type=退货出库")
    public ResultBean add3(@RequestBody Kufangfzback kufangfzback)//中心库房退货给厂商登记
    {
        kufangfzback.setCunit(kufangfzbackServiceImp.findcunit(kufangfzback.getCname()));
        kufangfzback.setCid(kufangfzbackServiceImp.findcid(kufangfzback.getCname()).toString());
        kufangfzbackServiceImp.add3_follow(kufangfzback.getAllocateid());
        if (kufangfzback.getDate()==null)
            kufangfzback.setDate(new Date());
        if (kufangfzback.getType()==null)
            kufangfzback.setType("中心退货");
        Goods_Total goodsTotal=new Goods_Total(kufangfzback.getCid(),kufangfzback.getCnum());
        goodsTotalController.add2(goodsTotal);
        return ResultBean.success(kufangfzbackServiceImp.add3(kufangfzback));
    }

    @PostMapping("/add4")
    @ApiOperation("中心库房退货给厂商登记 传入参数：订单号allocateid、商品名称cname、商品数量cnum、类型type=退货出库")
    public ResultBean add4(@RequestBody Kufangfzback kufangfzback)//中心库房退货给厂商登记
    {

        kufangfzbackServiceImp.uptui(kufangfzback);
        kufangfzback.setCunit(kufangfzbackServiceImp.findcunit(kufangfzback.getCname()));
        kufangfzback.setCid(kufangfzbackServiceImp.findcid(kufangfzback.getCname()).toString());
        return ResultBean.success("sucess",1);
    }


    @PostMapping("/findbypage")
    @ApiOperation("在分站库房中分页查询+模糊搜索上述退货情况，传入参数开始时间start、结束时间end、类型type、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage(@RequestBody GoodChangeFind goodChangeFind)//在分站库房中分页查询+模糊搜索
    {

        List<Kufangfzback> list=kufangfzbackServiceImp.findbypage(goodChangeFind);
        for (int i=0;i<list.size();i++)
        {
            list.get(i).setC_class(kufangfzbackServiceImp.findclass(list.get(i).getCname()));
            list.get(i).setCid(kufangfzbackServiceImp.findcid(list.get(i).getCname()).toString());

        }
        return ResultBean.success(list);
    }

    @PostMapping("/findbypage2")
    @ApiOperation("在中心库房中分页查询+模糊搜索上述退货情况，传入参数开始时间start、结束时间end、类型type、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage2(@RequestBody GoodChangeFind goodChangeFind)//在中心库房中分页查询+模糊搜索
    {
        List<Kufangfzback> list=kufangfzbackServiceImp.findbypage2(goodChangeFind);
        for (int i=0;i<list.size();i++)
        {
            list.get(i).setC_class(kufangfzbackServiceImp.findclass(list.get(i).getCname()));
            list.get(i).setCid(kufangfzbackServiceImp.findcid(list.get(i).getCname()).toString());
        }
        return ResultBean.success(list);
    }

    @PostMapping("/findbypage3")
    @ApiOperation("在中心库房退货给厂商中分页查询+模糊搜索上述退货情况，传入参数开始时间start、结束时间end、类型type、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage3(@RequestBody GoodChangeFind goodChangeFind)//在中心库房退货给厂商中分页查询+模糊搜索
    {
        List<Kufangfzback> list=kufangfzbackServiceImp.findbypage3(goodChangeFind);
        for (int i=0;i<list.size();i++)
        {
            list.get(i).setC_class(kufangfzbackServiceImp.findclass(list.get(i).getCname()));
            list.get(i).setCid(kufangfzbackServiceImp.findcid(list.get(i).getCname()).toString());
        }
        return ResultBean.success(list);
    }


    @PostMapping("/findbypage4")
    @ApiOperation("在中心库房退货给厂商中分页查询+模糊搜索上述退货情况，传入参数开始时间start、结束时间end、类型type、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage4(@RequestBody GoodChangeFind goodChangeFind)//在中心库房退货给厂商中分页查询+模糊搜索
    {
        List<Kufangfzback> list=kufangfzbackServiceImp.findbypage4(goodChangeFind);
        for (int i=0;i<list.size();i++)
        {
            list.get(i).setC_class(kufangfzbackServiceImp.findclass(list.get(i).getCname()));
            list.get(i).setCid(kufangfzbackServiceImp.findcid(list.get(i).getCname()).toString());
        }
        return ResultBean.success(list);
    }
}
