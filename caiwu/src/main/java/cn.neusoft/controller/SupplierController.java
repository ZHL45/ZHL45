package cn.neusoft.controller;


import cn.neusoft.domain.Supplier;
import cn.neusoft.query.SupplierQuery;
import cn.neusoft.service.impl.SupplierServiceImpl;
import cn.neusoft.vo.PageQueryBean;
import cn.neusoft.vo.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "供货商信息模块的Api",description = "供货商信息相关的CRUD功能")
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierServiceImpl supplierService;

    @DeleteMapping("/{id}")
    @ApiOperation(value = "供货商信息删除")
    public ResultBean delete(@PathVariable("id") String id){
        return ResultBean.success("删除成功",supplierService.delete(id));
    }

    @PutMapping("/jiesuan/{id}")
    @ApiOperation(value = "供货商信息结算")
    public ResultBean jiesuan(@PathVariable("id") String id){
        return ResultBean.success("结算成功",supplierService.jiesuan(id));
    }

    @PostMapping("/findByPage")
    @ApiOperation(value = "供货商信息的分页展示+模糊条件查询")
    public ResultBean findByPage(@RequestBody SupplierQuery supplierQuery)
    {
        String date = supplierQuery.getStartTime();
        if(date != null){
            System.out.println("时间：" + date);
            String time1 = date.substring(0,10);
            String time2 = date.substring(11,19);
            String time3 = time1 + " " + time2;
//        System.out.println(time1 + " " + time2);
            supplierQuery.setStartTime(time3);
        }

        String date2 = supplierQuery.getEndTime();
        if(date2 != null){
            System.out.println("时间：" + date);
            String time4 = date2.substring(0,10);
            String time5 = date2.substring(11,19);
            String time6 = time4 + " " + time5;
//        System.out.println(time1 + " " + time2);
            supplierQuery.setEndTime(time6);
        }

        PageQueryBean<Supplier> pageQueryBean = supplierService.findByPage(supplierQuery);
        return ResultBean.success(pageQueryBean);
    }
}
