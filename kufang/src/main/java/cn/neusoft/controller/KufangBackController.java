package cn.neusoft.controller;

import cn.neusoft.domain.kufang.KufangBack;
import cn.neusoft.domain.kufang.OrderReturn;
import cn.neusoft.service.imp.KufangBackServiceImp;
import cn.neusoft.service.imp.KufangfzbackServiceImp;
import cn.neusoft.vo.PageBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/back")
@Api(description = "退货登记表")
public class KufangBackController {
    @Autowired
    KufangBackServiceImp kufangBackServiceImp;

    @Autowired
    KufangfzbackServiceImp kufangfzbackServiceImp;


    @PostMapping("/find")
    @ApiOperation("查询 （进行退货操作）")
    public ResultBean find(@RequestBody PageBean pageBean)
    {
        List<OrderReturn> list=kufangBackServiceImp.findbypage(pageBean);
        System.out.println(list);
        for (int i=0;i<list.size();i++)
        {
            System.out.println("1." + kufangfzbackServiceImp.findclass(list.get(i).getP_name()));
            System.out.println("list" + list.get(i).getP_name());
            list.get(i).setC_class(kufangfzbackServiceImp.findclass(list.get(i).getP_name()));

            System.out.println("2." + kufangfzbackServiceImp.finddate(list.get(i).getO_l_id()));
            list.get(i).setDate(kufangfzbackServiceImp.finddate(list.get(i).getO_l_id()));

            System.out.println("3." + kufangfzbackServiceImp.findcid(list.get(i).getP_name()).toString());
            list.get(i).setCid(kufangfzbackServiceImp.findcid(list.get(i).getP_name()).toString());
        }
        return ResultBean.success(list);
    }
}
