package cn.neusoft.controller;

import cn.neusoft.domain.fenzhan.Payment;
import cn.neusoft.domain.fenzhan.Payment1;
import cn.neusoft.domain.test.Optition;
import cn.neusoft.packaging.PaymentQuery;
import cn.neusoft.service.imp.PaymentServiceImp;
import cn.neusoft.vo.PageBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    PaymentServiceImp paymentServiceImp;

    @GetMapping("/class")
    @ApiOperation("找商品分类")
    public ResultBean findclass()
    {
        Set<String> set= paymentServiceImp.findclass();
        Object[] arr=set.toArray();
        List<Optition> list= new ArrayList<>(set.size());
        Optition optition=new Optition("1","2");
        for(int i=0;i<set.size();i++)
        {
            list.add(optition);
            list.set(i,new Optition(arr[i].toString(),arr[i].toString()));
        }
        System.out.println(list);
        String data1="";
        for(int i=0;i<list.size();i++)
        {
            data1+="{value:";
            data1+=list.get(i).getLabel();
            data1+=",label:";
            data1+=list.get(i).getValue();
            data1+="}";
            if(i!= list.size()-1)
            {
                data1+=",";
            }
        }
        return ResultBean.success(list);
//        return ResultBean.success("success","options:["+data1+"],value:''");
    }

    @GetMapping("/test")
    public ResultBean test()
    {
        List<Optition> list= new ArrayList<>(10);
        Optition optition=new Optition("1","2");
        for(int i=0;i<10;i++)
        {
            list.add(optition);
        }
        String s=list.toString();
        return ResultBean.success(s);
    }


    @PostMapping("/findbypage")
    @ApiOperation("查找那些退货的、送货的")
    public ResultBean findbypage(@RequestBody PaymentQuery paymentQuery)
    {
        Integer pagenow=paymentQuery.getPageNow();
        Integer pagesize=paymentQuery.getPageSize();
        paymentQuery.setPageNow(1);
        paymentQuery.setPageSize(100);
        Object [] objects=paymentServiceImp.findname(paymentQuery.getClass1()).toArray();
        List<Payment> list=new ArrayList<>();
        for(int i=0;i<objects.length;i++)
        {
            Payment payment=new Payment();
            payment.setClass1(paymentQuery.getClass1());
            payment.setCname(objects[i].toString());
            paymentQuery.setCname(objects[i].toString());
            //送货统计
            List<Payment> paymentList=paymentServiceImp.findbypage(paymentQuery);
            Integer totalcnum=0;
            Integer totalprice=0;
            for(int j=0;j<paymentList.size();j++)
            {
                totalcnum+=paymentList.get(j).getP_number();
                totalprice+=paymentList.get(j).getP_amount();
            }
            payment.setCnum(totalcnum);
            payment.setCmoney(totalprice);

            //退货统计
            List<Payment1> payment1List=paymentServiceImp.findbypage1(paymentQuery);
            Integer backcnum=0;
            Integer backprice=0;
            for(int j=0;j<payment1List.size();j++)
            {
                backcnum+=payment1List.get(j).getP_number();
                backprice+=payment1List.get(j).getP_amount();
            }
            payment.setBacknum(backcnum);
            payment.setBackmoney(backprice);
            list.add(payment);
        }

        return ResultBean.success(list.subList((pagenow-1)*pagesize> list.size()? list.size() :(pagenow-1)*pagesize ,(pagenow)*pagesize>= list.size()? list.size() :(pagenow)*pagesize));
    }

}
