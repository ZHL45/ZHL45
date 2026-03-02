package cn.neusoft.service.impl;

import cn.neusoft.domain.CustomerInfo;
import cn.neusoft.domain.order.OrderAll;
import cn.neusoft.mapper.CustomerMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.CustomerInfoQuery;
import cn.neusoft.service.CustomerService;
import cn.neusoft.utils.OrderUtils;
import cn.neusoft.vo.PageBean;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public Integer add(CustomerInfo customerInfo) {
        return customerMapper.add(customerInfo);
    }

    @Override
    public Integer delete(String id) {
        return customerMapper.delete(id);
    }

    @Override
    public Integer update(CustomerInfo customerInfo) {
        return customerMapper.update(customerInfo);
    }

    @Override
    public String getC_id(){
        String result = "";
        int i = 0;
        while (i == 0){
            long c_id = OrderUtils.getRandom(8);
            result = c_id + "";
            //检查该客户编号是否已在数据库当中
            CustomerInfo customerInfo = customerMapper.findId(result);
            if(customerInfo == null){
                i = 1;
            }
        }
        return result;
    }

    @Override
    public PageQueryBean<CustomerInfo> findByPage(BaseQuery query) {
        //构建结果对象
        PageQueryBean<CustomerInfo> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<CustomerInfo> customerInfoList = customerMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<CustomerInfo> pageInfo = new PageInfo<>(customerInfoList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    @Override
    public List<OrderAll> findById(String c_id) {
        return customerMapper.findById(c_id);
    }
}
