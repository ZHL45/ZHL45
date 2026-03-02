package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.service.imp.BillServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*
add(Bill bill):添加记录
delete(Bill bill)：删除记录
findbypage(Bill bill)：模糊搜索+分页查询，如什么不传就是分页查询
findbypage2(Bill bill)：发票联查+分页+模糊搜索，其中模糊搜索除了姓名外都能查找
 */
@RestController
@RequestMapping("/bill")
@Api(description = "发票相关功能")
public class BillController {
    @Autowired
    BillServiceImp billServiceImp;

    @PostMapping                 //Post +/bill
    @ApiOperation("添加一条记录 传入参数：开始号码startnum、结束号码endnum、批次batch、对应订单号did、操作类型opera、姓名hname")
    public ResultBean add(@RequestBody Bill bill)
    {
        bill.setDate(new Date());
        return ResultBean.success(billServiceImp.add(bill));
    }


    @PostMapping ("/delete")           //Post +/bill/delete
    @ApiOperation("删除一条记录 传入参数：开始号码startnum、结束号码endnum、批次batch")
    public ResultBean delete(@RequestBody Bill bill)
    {
        Integer integer= billServiceImp.delete(bill);
        if(integer==1)
            return ResultBean.success("删除成功",null);
        return ResultBean.fail(500,"没有该记录");
    }

    @PostMapping("/findbypage")         //Post +/bill/findbypage
    @ApiOperation("（没用到可忽略）发票信息列表： 分页查询+模糊搜索 传入参数：开始号码startnum、结束号码endnum、批次batch、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage(@RequestBody Bill bill)
    {
        return ResultBean.success(billServiceImp.findbypage(bill));
    }


//    @GetMapping("/findall")
//    public ResultBean findall()
//    {
//        return ResultBean.success(billServiceImp.findall());
//    }


//    @GetMapping                 //Get  +/bill
    @GetMapping("/findall2")
    public ResultBean findall2()
    {
        return ResultBean.success(billServiceImp.findall2());
    }

    @PostMapping("/findbypage2")        //Post +/bill/findbypage2
    @ApiOperation("发票信息查询：分页查询+模糊搜索+联查 传入参数：开始号码startnum、结束号码endnum、批次batch、当前页pageNow、每页大小pageSize")
    public ResultBean findbypage2(@RequestBody Bill bill)
    {

        System.out.println(bill);
        List<Bill> bill1=billServiceImp.findbypage2(bill);
        System.out.println(bill1);
        for(int i=0;i<bill1.size();i++)
        {
//            bill1.get(i).getBill_find().setO_receiver(bill.getHname());
            bill1.get(i).getBill_find().setO_receiver(bill1.get(i).getHname());
            if(bill1.get(i).getStartnum()!=null &bill1.get(i).getEndnum()!=null & bill1.get(i).getBatch()!=null)
            {
                bill1.get(i).setInvoiceId(bill1.get(i).getStartnum()+"-"+bill1.get(i).getEndnum()+"-"+bill1.get(i).getBatch());
            }

        }
        System.out.println(bill1);
        return ResultBean.success(bill1);
    }
}
