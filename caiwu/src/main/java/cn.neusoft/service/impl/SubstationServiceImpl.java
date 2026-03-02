package cn.neusoft.service.impl;

import cn.neusoft.domain.OperatorInfo;
import cn.neusoft.domain.Supplier;
import cn.neusoft.domain.order.OperatorJob;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.domain.order.OrderSub;
import cn.neusoft.mapper.SubstationMapper;
import cn.neusoft.mapper.SupplierMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.JobSubQuery;
import cn.neusoft.service.SubStationService;
import cn.neusoft.service.SupplierService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubstationServiceImpl implements SubStationService {
    @Autowired
    SubstationMapper substationMapper;


    @Override
    public Integer jiesuan(JobSubQuery jobSubQuery){
        return substationMapper.jiesuan(jobSubQuery);
    }

    @Override
    public List<OrderSub> findYiByPage(JobSubQuery query){
        //        Date date = operatorJobQuery.getStartTime();
        System.out.println("打印时间");
        //        System.out.println(date);

        List<OrderSub> orderSubList = substationMapper.findYiByPage(query);
        System.out.println("总共条数:"+orderSubList.size());

        List<OrderSub> orderSubList1 = new ArrayList<>();
        //前提：遍历列表中已经按分站名称和商品名称进行排序
        for(int i=0;i < orderSubList.size();i++){
            System.out.println(orderSubList.get(i).getIs_jiesuan());
            OrderSub orderSub = new OrderSub();
            orderSub.setO_substation(orderSubList.get(i).getO_substation());
            orderSub.setP_type(orderSubList.get(i).getP_type());
            orderSub.setP_subtype(orderSubList.get(i).getP_subtype());
            orderSub.setP_name(orderSubList.get(i).getP_name());
            System.out.println("开始循环啊");
            do{
                OrderSub orderSub2 = orderSubList.get(i);
                if(orderSub2.getO_afterSales().equals("退货")){
                    orderSub.setTui_num(orderSub.getTui_num()+orderSub2.getP_number());
                    orderSub.setTui_amount(orderSub.getTui_amount()+orderSub2.getP_amount());
                }
                orderSub.setSong_num(orderSub.getSong_num()+orderSub2.getP_number());
                orderSub.setSong_amount(orderSub.getSong_amount()+orderSub2.getP_amount());
                i++;
            }while (i < orderSubList.size() && orderSubList.get(i).getP_name().equals(orderSubList.get(i-1).getP_name())
            && orderSubList.get(i).getO_substation().equals(orderSubList.get(i-1).getO_substation()));
            i--;//回退，因为for循环中还要++
            orderSub.setYingjiao(orderSub.getSong_amount() - orderSub.getTui_amount());  //计算净收入
            orderSubList1.add(orderSub);  //将工作量添加到列表里
        }
        return orderSubList1;
    }

    @Override
    public List<OrderSub> findWeiByPage(JobSubQuery query){
        //        Date date = operatorJobQuery.getStartTime();
        System.out.println("打印时间");
        //        System.out.println(date);

        List<OrderSub> orderSubList = substationMapper.findWeiByPage(query);
        System.out.println("总共条数:"+orderSubList.size());

        List<OrderSub> orderSubList1 = new ArrayList<>();
        for(int i=0;i < orderSubList.size();i++){
            OrderSub orderSub = new OrderSub();
//            OrderAll orderAll = orderAllList.get(i);
            orderSub.setO_substation(orderSubList.get(i).getO_substation());
            orderSub.setP_type(orderSubList.get(i).getP_type());
            orderSub.setP_subtype(orderSubList.get(i).getP_subtype());
            orderSub.setP_name(orderSubList.get(i).getP_name());

            do{
                OrderSub orderSub2 = orderSubList.get(i);
                if(orderSub2.getO_afterSales().equals("退货")){
                    orderSub.setTui_num(orderSub.getTui_num()+orderSub2.getP_number());
                    orderSub.setTui_amount(orderSub.getTui_amount()+orderSub2.getP_amount());
                }
                orderSub.setSong_num(orderSub.getSong_num()+orderSub2.getP_number());
                orderSub.setSong_amount(orderSub.getSong_amount()+orderSub2.getP_amount());
                i++;

            }while (i < orderSubList.size() && orderSubList.get(i).getP_name().equals(orderSubList.get(i-1).getP_name())
                    && orderSubList.get(i).getO_substation().equals(orderSubList.get(i-1).getO_substation()));
            i--;//回退，因为for循环中还要++
            orderSub.setYingjiao(orderSub.getSong_amount() - orderSub.getTui_amount());  //计算净收入

            orderSubList1.add(orderSub);  //将工作量添加到列表里
        }
        return orderSubList1;
    }
}
