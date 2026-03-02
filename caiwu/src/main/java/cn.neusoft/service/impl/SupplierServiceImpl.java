package cn.neusoft.service.impl;

import cn.neusoft.domain.Supplier;
import cn.neusoft.mapper.SupplierMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.service.SupplierService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public Integer delete(String id){
        return supplierMapper.delete(id);
    }

    @Override
    public Integer jiesuan(String id){
        return supplierMapper.jiesuan(id);
    }

    @Override
    public PageQueryBean<Supplier> findByPage(BaseQuery query){
        //构建结果对象
        PageQueryBean<Supplier> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<Supplier> SupplierList = supplierMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<Supplier> pageInfo = new PageInfo<>(SupplierList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }
}
