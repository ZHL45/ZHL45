package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.*;
import cn.neusoft.domain.kufang.OrderReturn;
import cn.neusoft.service.imp.ReceiptServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/*
方法介绍：findall()：查找所有
add(Receipt receipt)：添加一条记录 注意：一定要确保tid是不存在的，否则会崩（可以用下面的方法先查找）
findbyid(String tid)：通过tid查找，找得到code返回200，找不到返回500
findbypage(PageBean pageBean)：分页+模糊搜索功能，需要传递参数：pageNow：当前页    pageSize：每页数据大小 pman：派送人员模糊查询 ttype：任务类型
total():根据tid查询数据总条数
total2(Receipt receipt):模糊查询后的条数，需要参数：pman：派送人员模糊查询 ttype：任务类型
 */

@RestController
@RequestMapping("/receipt")
@Api(description = "回执相关功能")
public class ReceiptController {
    @Autowired
    ReceiptServiceImp receiptServiceImp;

//    @GetMapping("/findall")
//    public ResultBean findall()
//    {
//        return ResultBean.success(receiptServiceImp.findall());
//    }

    @PostMapping("/add")
    @ApiOperation("任务类型=送货收款  传入参数：订单号tid、姓名hname、电话hphone、任务分站tstation、任务类型ttype、送货地址addr、送货员pman、商品名称cname、商品数量cnum、商品计量单位cunit、商品总额summoney、状态tstate、发票号billnum、备注note、满意度satisfaction")
    public ResultBean add(@RequestBody Receipt receipt)
    {

        System.out.println(receipt);
        String integer=receipt.getTid();
        System.out.println(integer);
        OrderAll orderAll =receiptServiceImp.add_follow(integer.toString());
        receiptServiceImp.set_state(new Fenzhan_receipt_state(orderAll.getO_id(),"已提交_下沉"));
        receipt.setHname(orderAll.getC_name());
        receipt.setHphone(orderAll.getO_recPhone());
        receipt.setTtype("送货收款");
        receipt.setTstation("沈阳站");
        receipt.setAddr(orderAll.getO_address());
        receipt.setCname(orderAll.getP_name());
        receipt.setCnum(orderAll.getP_number());
        receipt.setSummoney(orderAll.getP_amount());
        receipt.setTstate(orderAll.getO_state());
        receipt.setDate(orderAll.getO_date());
        receipt.setPrice((float) (receipt.getSummoney()/receipt.getCnum()));
        receipt.setPman(receiptServiceImp.getpman(integer));
        Bill bill=receiptServiceImp.findbill(integer);
        System.out.println(bill.getStartnum().toString()+"-"+bill.getEndnum()+"-"+bill.getBatch());
        receipt.setBillnum1(bill.getStartnum().toString()+"-"+bill.getEndnum()+"-"+bill.getBatch());
        if (receipt.getDate()==null)
            receipt.setDate(new Date());
        receiptServiceImp.add(receipt);
        return ResultBean.success(receipt);
    }

    @PostMapping("/add2")
    @ApiOperation("任务类型=换货||送货  传入参数：订单号tid、姓名hname、电话hphone、任务分站tstation、任务类型ttype、商品名称cname、商品数量cnum、状态tstate、备注note、满意度satisfaction")
    public ResultBean add2(@RequestBody Receipt receipt)
    {


        String integer=receipt.getTid();
        OrderAll orderAll =receiptServiceImp.add_follow(integer.toString());
        receiptServiceImp.set_state(new Fenzhan_receipt_state(orderAll.getO_id(),"已提交_下沉"));
        receipt.setHname(orderAll.getC_name());
        receipt.setHphone(orderAll.getO_recPhone());
        receipt.setTtype(orderAll.getO_afterSales());
        receipt.setTstation("沈阳站");
        receipt.setAddr(orderAll.getO_address());
        receipt.setCname(orderAll.getP_name());
        receipt.setCnum(orderAll.getP_number());
        receipt.setTstate(orderAll.getO_state());
        receipt.setPrice((float) (receipt.getSummoney()/receipt.getCnum()));
        receipt.setPman(receiptServiceImp.getpman(integer));
        if (receipt.getDate()==null)
            receipt.setDate(new Date());
        receiptServiceImp.add2(receipt);

        return ResultBean.success(receipt);
    }


    @PostMapping("/add3")
    @ApiOperation("任务类型=送货收款  传入参数：订单号tid、姓名hname、电话hphone、任务分站tstation、任务类型ttype、商品总额summoney、状态tstate、备注note、满意度satisfaction、退货地址backaddr、退货商品名称backcname、退货商品数量backcnum、退货金额backmoney")
    public ResultBean add3(@RequestBody Receipt receipt)
    {

        String integer=receipt.getTid();
        System.out.println(integer);
        OrderReturn orderReturn=receiptServiceImp.add_follow3(integer.toString());
        System.out.println(orderReturn);
        OrderAll orderAll=receiptServiceImp.add_follow(orderReturn.getO_l_id());
        receiptServiceImp.set_state(new Fenzhan_receipt_state(String.valueOf(orderReturn.getO_l_id()),"已提交_下沉"));
        receipt.setHname(orderReturn.getC_name());
        receipt.setHphone(orderAll.getO_recPhone());
        receipt.setTtype(orderAll.getO_afterSales());
        receipt.setTstation("沈阳站");
        receipt.setBackaddr(orderReturn.getO_address());
        receipt.setBackcname(orderReturn.getP_name());
        receipt.setBackcnum(orderReturn.getP_number());
        receipt.setTstate(orderAll.getO_state());
        receipt.setBackmoney(orderReturn.getP_amount());
        receiptServiceImp.add3(receipt);
        return ResultBean.success(receipt);
    }

//    @GetMapping("/{tid}")
//    @ApiOperation("通过id查找")
//    public ResultBean findbyid(@PathVariable("tid") String tid)
//    {
//        Receipt receipt=receiptServiceImp.findbyid(tid);
//        if(receipt==null)
//        {
//            return ResultBean.fail(500,"未找到相关用户");
//        }
//        return ResultBean.success(receipt);
//    }

    @PostMapping ("/findbypage")
    @ApiOperation("分页+模糊搜索 传入参数：任务类型ttype=送货收款、查询起始时间start、查询终止时间end、当前页pageNow、每页数据数量pageSize")
    public ResultBean findbypage(@RequestBody Receipt receipt)
    {
        List<OrderAll> list = receiptServiceImp.findbypage(receipt);
        for(int i=0;i<list.size();i++)
        {
            String integer=list.get(i).getO_id();
            if(receiptServiceImp.check(integer)!=0)
            {
                list.get(i).setState(receiptServiceImp.get_state(integer).getState());
            }
            else {
                list.get(i).setState("未添加");
            }
        }
        return ResultBean.success(list);
    }
    @PostMapping ("/findbypage2")
    @ApiOperation("分页+模糊搜索 传入参数：任务类型ttype=换货||送货、查询起始时间start、查询终止时间end、当前页pageNow、每页数据数量pageSize")
    public ResultBean findbypage2(@RequestBody Receipt receipt)
    {
        List<OrderAll> list = receiptServiceImp.findbypage2(receipt);
        for(int i=0;i<list.size();i++)
        {
            String integer=list.get(i).getO_id();
            if(receiptServiceImp.check(integer)!=0)
            {
                list.get(i).setState(receiptServiceImp.get_state(integer).getState());
            }
            else {
                list.get(i).setState("未添加");
            }
        }
        return ResultBean.success(list);
    }
    @PostMapping ("/findbypage3")
    @ApiOperation("分页+模糊搜索 传入参数：任务类型ttype==退货||退款、查询起始时间start、查询终止时间end、当前页pageNow、每页数据数量pageSize")
    public ResultBean findbypage3(@RequestBody Receipt receipt)
    {
        List<OrderAll> list=receiptServiceImp.findbypage3(receipt);
        System.out.println(list);
        for(int i=1;i<list.size();i++)
        {
            String integer=list.get(i).getO_id();
            System.out.println(integer);
            if(receiptServiceImp.check(integer)!=0)
            {
                list.get(i).setState(receiptServiceImp.get_state(integer).getState());
                System.out.println(receiptServiceImp.get_state(integer).getState());
            }
            else {
                list.get(i).setState("未添加");
            }

        }
        return ResultBean.success(list);
    }

    @GetMapping("/total")
    @ApiOperation("（内部接口，可忽略）查询数据总数")
    public ResultBean total()
    {
        return ResultBean.success(receiptServiceImp.total());
    }


    @PostMapping("/total2")
    @ApiOperation("（内部接口，可忽略）查询数据总数（带有限制条件） 传入参数：任务类型ttype、送货员pman")
    public ResultBean total2(@RequestBody Receipt receipt)
    {
        return ResultBean.success(receiptServiceImp.total2(receipt));
    }


//    @GetMapping("/condition")
//    public ResultBean findbycondition(Receipt receipt)
//    {
//        return ResultBean.success(receiptServiceImp.findbycondition(receipt));
//    }
}
