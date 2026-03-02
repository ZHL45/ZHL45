package cn.neusoft.controller;

import cn.neusoft.domain.kufang.*;
import cn.neusoft.packaging.GoodChangeFind;
import cn.neusoft.packaging.Kf_change1_vo;
import cn.neusoft.service.imp.GoodsChangeServiceImp;
import cn.neusoft.service.imp.GoodsTotalServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/change")
@Api(description = "中心库房货物出入库")
public class GoodsChangeController {
    @Autowired
    GoodsChangeServiceImp goodsChangeServiceImp;

    @Autowired
    GoodsTotalController goodsTotalController;

    @Autowired
    GoodsTotalServiceImp goodsTotalServiceImp;

    @PostMapping("/add")//入库
    @ApiOperation("中心仓库入库，传入参数：调拨单号allocateid、商品代码cid、商品名称cname、计量单位measure_unit、入库数量cnum、任务号tid")
    public ResultBean add(@RequestBody Goods_Change goods_change)
    {
        Goods_Total goodsTotal=new Goods_Total(goods_change.getCid(),goods_change.getCnum());
        goodsTotalController.add(goodsTotal);
        goods_change.setDate(new Date());
        goodsChangeServiceImp.add_follow1(goods_change);
        goodsChangeServiceImp.add_follow2(goods_change.getAllocateid());
        return ResultBean.success(goodsChangeServiceImp.add(goods_change));
    }

    @PostMapping("/add2")//出库，出库前需用check检测库存量是否足够
    @ApiOperation("中心仓库出库（出库前必须用check（）函数检查库存量是否充足！！！），传入参数：调拨单号allocateid、商品代码cid、商品名称cname、计量单位measure_unit、出库数量cnum、任务号tid")
    public ResultBean add2(@RequestBody Goods_Change goods_change)
    {
        goodsChangeServiceImp.add2_follow1(goods_change);
        Goods_Total goodsTotal=new Goods_Total(goods_change.getCid(),goods_change.getCnum());
        goodsTotalController.add2(goodsTotal);
        goods_change.setDate(new Date());
        goods_change.setCnum(goods_change.getCnum()*-1);
        goodsChangeServiceImp.updatestate(goods_change.getTid());
        return ResultBean.success(goodsChangeServiceImp.add2(goods_change));
    }

    @PostMapping("/check")
    @ApiOperation("检查中心库房货量是否充足，不足不可出货！！传入参数：商品编码cid、需要数量cnum")
    public ResultBean check(@RequestBody Goods_Change goods_change)//检查库存量是否充足
    {
        Goods_Total goodsTotal=new Goods_Total(goods_change.getCid(),goods_change.getCnum());
        if(goodsTotalServiceImp.findbyid(goodsTotal)!=null)
        {
            Integer total=goodsTotalServiceImp.findbyid(goodsTotal).getCnum();
            if (total<goods_change.getCnum())
                return ResultBean.fail(500,"库存量不足",false);
            return ResultBean.success(true);
        }
        return ResultBean.fail(500,"无此商品",false);
    }
    @PostMapping("/findbypage")//查询入库情况，传入开始时间、结束时间、类型（购货入库）
    @ApiOperation("“预备数据”")
    public ResultBean findbypage(@RequestBody GoodChangeFind goodChangeFind)
    {
        List<KufangGoods1> list=goodsChangeServiceImp.findbypage(goodChangeFind);
        List<Goods_Change> goodsChanges = new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {
            Goods_Change goods_change=new Goods_Change();
            goods_change.setAllocateid(list.get(i).getO_id());
            goods_change.setTid(list.get(i).getO_id());
            goods_change.setCid(list.get(i).getCid().toString());
            goods_change.setCname(list.get(i).getCname());
            goods_change.setMeasure_unit(list.get(i).getMeasure_unit());
            goods_change.setCnum(Integer.valueOf(list.get(i).getJinhuo_num()));
            //读取时间
            String dateString = list.get(i).getPeriod();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
            int year = dateTime.getYear();
            int month = dateTime.getMonthValue();
            int day = dateTime.getDayOfMonth();
            int hour = dateTime.getHour();
            int minute = dateTime.getMinute();
            int second = dateTime.getSecond();

            System.out.println("Year: " + year);
            System.out.println("Month: " + month);
            System.out.println("Day: " + day);
            System.out.println("Hour: " + hour);
            System.out.println("Minute: " + minute);
            System.out.println("Second: " + second);
            goods_change.setDate(new Date(year-1900,month-1,day,hour,minute,second));
            goodsChanges.add(goods_change);

        }
        return ResultBean.success(goodsChanges);
//        return ResultBean.success(goodsChangeServiceImp.findbypage(goodChangeFind));
    }

    @PostMapping("/findbypage2")//查询出库情况，传入开始时间、结束时间、类型（调拨出库）
    @ApiOperation("查询入库情况 传入参数：开始时间start、结束时间end、类型type=购货入库、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage2(@RequestBody GoodChangeFind goodChangeFind)
    {
        return ResultBean.success(goodsChangeServiceImp.findbypage2(goodChangeFind));
    }

    @PostMapping("/findbypage3")//查询出库情况，传入开始时间、结束时间、商品名称
    @ApiOperation("查询出库情况 传入参数：开始时间start、结束时间end、类型type=调拨出库、当前页pageNow、每页大小pageSize")

    public ResultBean findbypage3(@RequestBody GoodChangeFind goodChangeFind)
    {
        return ResultBean.success(goodsChangeServiceImp.findbypage3(goodChangeFind));
    }
//    @ApiOperation("查询出库情况 传入参数：开始时间start、结束时间end、商品名称cname、当前页pageNow、每页大小pageSize")
//    @GetMapping("/find/{allocateid}")
//    @ApiOperation("打印出库单")
//    public ResultBean find(@PathVariable("allocateid") Integer allocateid)
//    {
//        //初始化、更改一些信息
//        ChuKuDan chuKuDan=goodsChangeServiceImp.find(allocateid);
//        chuKuDan.setDate(new Date());
//        Integer integer=goodsChangeServiceImp.find(allocateid).getCnum();
//        if(integer<0)
//        {
//            integer=integer*-1;
//            chuKuDan.setCnum(integer);
//        }
//        Integer money=goodsChangeServiceImp.find(allocateid).getGoods().getOriginal_price();
//        Goods goods=chuKuDan.getGoods();
//        goods.setCost(money*integer);
//        chuKuDan.setGoods(goods);
//        return ResultBean.success(chuKuDan);
//    }

    @PostMapping("/print")
    @ApiOperation("打印分发单")
    public ResultBean print(@RequestBody Kf_change1_vo kfChange1Vo)
    {
        //初始化、更改一些信息
        ArrayList<String> arrayList=new ArrayList<>();
        List<Kufang_change1> list=goodsChangeServiceImp.print(kfChange1Vo);
        for(int i=0;i<list.size();i++)
        {
            Integer integer=list.get(i).getCnum();
            list.get(i).setCnum(integer*-1);
            String c_cname=list.get(i).getCname();
            if(!arrayList.contains(c_cname))
                arrayList.add(c_cname);

            Goods goods=goodsChangeServiceImp.findgoods(list.get(i).getCid());
            list.get(i).setFactory(goods.getFactory());
            list.get(i).setPrice(goods.getOriginal_price());
            list.get(i).setNote(goods.getNote());
            list.get(i).setOperator("侯某");
            list.get(i).setFactory("天云有限公司");
            list.get(i).setNote("无");
            list.get(i).setPman("李四");
            if(goodsChangeServiceImp.findc(list.get(i).getTid())!=null)
            {
                list.get(i).setReceiver(goodsChangeServiceImp.findc(list.get(i).getTid()));
            }else {
                list.get(i).setReceiver("朱海邻");
            }
        }
        ArrayList<Integer> total=new ArrayList<>();
        ArrayList<Integer> sum=new ArrayList<>();
        for(int i=0;i<arrayList.size();i++)
        {
            total.add(0);
            sum.add(0);
        }
        for(int i=0;i<list.size();i++)
        {
            String c_cname=list.get(i).getCname();
            for(int j=0;j<arrayList.size();j++)
            {
                if(arrayList.get(j).equals(c_cname))
                {
                    Integer cum=list.get(i).getCnum()+ total.get(j);
                    Integer price=list.get(i).getPrice()*list.get(i).getCnum()+sum.get(j);
                    total.set(j,cum);
                    sum.set(j,price);
                }
            }
        }

        for(int i=0;i<list.size();i++)
        {
            String c_cname=list.get(i).getCname();
            for(int j=0;j<arrayList.size();j++)
            {
                if(arrayList.get(j).equals(c_cname))
                {
                    list.get(i).setTotal(total.get(j));
                    list.get(i).setSum(sum.get(j));
                }
            }
        }
        return ResultBean.success(list);
    }
    @PostMapping("/print1")
    @ApiOperation("打印出库单")
    public ResultBean print1(@RequestBody Kf_change1_vo kfChange1Vo)
    {
        //初始化、更改一些信息
        ArrayList<String> arrayList=new ArrayList<>();
        List<ChuKuDan> list=goodsChangeServiceImp.print1(kfChange1Vo);
        for(int i=0;i<list.size();i++)
        {
            Integer integer=list.get(i).getCnum();
            list.get(i).setCnum(integer*-1);
            String c_cname=list.get(i).getCname();
            if(list.get(i).getCnum()<0)
                list.get(i).setCnum(list.get(i).getCnum()*-1);
            if(!arrayList.contains(c_cname))
                arrayList.add(c_cname);
            Goods goods=goodsChangeServiceImp.findgoods(list.get(i).getCid());
            list.get(i).setGoods(goods);
        }
        ArrayList<Integer> total=new ArrayList<>();
        ArrayList<Integer> sum=new ArrayList<>();
        for(int i=0;i<arrayList.size();i++)
        {
            total.add(0);
            sum.add(0);
        }
        for(int i=0;i<list.size();i++)
        {
            String c_cname=list.get(i).getCname();
            for(int j=0;j<arrayList.size();j++)
            {
                if(arrayList.get(j).equals(c_cname))
                {
                    Integer cum=list.get(i).getCnum()+ total.get(j);
                    Integer price=list.get(i).getGoods().getOriginal_price()*list.get(i).getCnum()+sum.get(j);
                    total.set(j,cum);
                    sum.set(j,price);
                }
            }
        }

        for(int i=0;i<list.size();i++)
        {
            String c_cname=list.get(i).getCname();
            for(int j=0;j<arrayList.size();j++)
            {
                if(arrayList.get(j).equals(c_cname))
                {
                    list.get(i).setTotal(total.get(j));
                    list.get(i).setSum(sum.get(j));
                }
            }
            list.get(i).getGoods().setNote("无");
        }
        System.out.println(list);
        return ResultBean.success(list);
    }

}
