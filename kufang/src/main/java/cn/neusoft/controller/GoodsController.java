package cn.neusoft.controller;

import cn.neusoft.domain.kufang.Goods;
import cn.neusoft.packaging.Goods_find;
import cn.neusoft.service.imp.GoodsServiceImp;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/goods")
@Api(description = "测试接口，不用管")
public class GoodsController {
    @Autowired
    GoodsServiceImp goodsServiceImp;

    @GetMapping("/add")
    public ResultBean add(Goods goods)
    {
        if(goods.getType()==null)
            goods.setType("购货入库");
        if(goods.getTime()==null)
            goods.setTime(new Date());
        return ResultBean.success(goodsServiceImp.add(goods));
    }


    @GetMapping("/findbyid")
    public ResultBean findbyid(Goods goods)
    {
        ResultBean resultBean=ResultBean.success(goodsServiceImp.findbyid(goods));
        if(resultBean.getData()==null)
            return ResultBean.fail(200,"未查询到相关结果",null);
        return resultBean;
    }

    @GetMapping("/exist")
    public ResultBean exist(Goods goods)
    {
        ResultBean resultBean=ResultBean.success(goodsServiceImp.findbyid(goods));
        if(resultBean.getData()==null)
            return ResultBean.fail(200,"未查询到相关结果",false);
        return ResultBean.success(true);
    }

    @GetMapping("/update")
    public ResultBean update(Goods goods)
    {
       Integer newadd=goods.getCnum();
       Integer total=goodsServiceImp.findbyid(goods).getCnum()+newadd;
       goods.setCnum(total);
       return ResultBean.success(goodsServiceImp.update(goods));
    }


    @GetMapping("/findbypage")
    public ResultBean findbypage(Goods_find goods_find)
    {
        System.out.println(goods_find);
        System.out.println(goods_find.getStart().getClass());
        return ResultBean.success(goodsServiceImp.findbypage(goods_find));
    }

}
