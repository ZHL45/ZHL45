package cn.neusoft.service.impl;


import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.OperatorInfo;
import cn.neusoft.domain.order.OperatorJob;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.mapper.OperatorMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.OperatorInfoQuery;
import cn.neusoft.query.OperatorJobQuery;
import cn.neusoft.query.OrderByOpQuery;
import cn.neusoft.service.OperatorService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorMapper operatorMapper;

    @Override
    public PageQueryBean<OperatorInfo> findByPage(BaseQuery query) {
        //构建结果对象
        PageQueryBean<OperatorInfo> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<OperatorInfo> operatorInfoList = operatorMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<OperatorInfo> pageInfo = new PageInfo<>(operatorInfoList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    @Override
    public List<OrderAll> findOrderInfo(OrderByOpQuery orderByOpQuery) {
        List<OrderAll> orderAllList = operatorMapper.findOrderInfo(orderByOpQuery);
        return orderAllList;
    }

    @Override
    public List<OperatorJob> findOperatorJobInfo(OperatorJobQuery operatorJobQuery){
//        Date date = operatorJobQuery.getStartTime();
        System.out.println("打印时间");
//        System.out.println(date);
        OperatorInfo operatorInfo = new OperatorInfo();
        operatorInfo.setOp_id(operatorJobQuery.getOp_id());

        List<OrderAll> orderAllList = operatorMapper.findOperatorJobInfo(operatorJobQuery);
        System.out.println("总共条数:"+orderAllList.size());

        List<OperatorJob> operatorJobList = new ArrayList<>();
        //前提，遍历的列表中已经按操作员和商品名称进行排序
        for(int i=0;i < orderAllList.size();i++){
            OperatorJob operatorJob = new OperatorJob();
            operatorJob.setP_name(orderAllList.get(i).getP_name());
            operatorJob.setP_type(orderAllList.get(i).getP_type());
            operatorJob.setP_subtype(orderAllList.get(i).getP_subtype());
            do{
                OrderAll orderAll = orderAllList.get(i);
                if(orderAll.getO_afterSales().equals("已取消")){
                    operatorJob.setC_orderNum(operatorJob.getC_orderNum()+1);
                    operatorJob.setC_orderAmount(operatorJob.getC_orderAmount()+orderAll.getP_amount());
                    operatorJob.setC_orderPNum(operatorJob.getC_orderPNum()+orderAll.getP_number());
                }else if (orderAll.getO_afterSales().equals("退货")){
                    operatorJob.setR_orderNum(operatorJob.getR_orderNum()+1);
                    operatorJob.setR_orderAmount(operatorJob.getR_orderAmount()+orderAll.getP_amount());
                    operatorJob.setR_orderPNum(operatorJob.getR_orderPNum()+orderAll.getP_number());
                }else if (orderAll.getO_afterSales().equals("换货")){
                    operatorJob.setE_orderNum(operatorJob.getE_orderNum()+1);
                    operatorJob.setE_orderAmount(operatorJob.getE_orderAmount()+orderAll.getP_amount());
                    operatorJob.setE_orderPNum(operatorJob.getE_orderPNum()+orderAll.getP_number());
                }else {  //正常+缺货  (暂时算合理收入)
                    operatorJob.setN_orderNum(operatorJob.getN_orderNum()+1);
                    operatorJob.setN_orderAmount(operatorJob.getN_orderAmount()+orderAll.getP_amount());
                    operatorJob.setN_orderPNum(operatorJob.getN_orderPNum()+orderAll.getP_number());
                }
                i++;
            }while (i < orderAllList.size() && orderAllList.get(i).getP_name().equals(orderAllList.get(i-1).getP_name()));
            i--;//回退，因为for循环中还要++
            operatorJob.setIncome(operatorJob.getN_orderAmount() + operatorJob.getE_orderAmount());  //计算净收入
            operatorInfo.setOp_income(operatorInfo.getOp_income() + operatorJob.getIncome());  //计算操作员总净收入
            //如果时间上满足全部为空，即计算的总净收入不只是某段时间内的总收入，才将总净收入加入操作员数据库中
            if(operatorJobQuery.getStartTime() == null && operatorJobQuery.getEndTime() == null){
                operatorMapper.setOpIncome(operatorInfo);  //更新操作员表
            }
            operatorJobList.add(operatorJob);  //将工作量添加到列表里
        }
        return operatorJobList;
    }
}
