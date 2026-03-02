package cn.neusoft.service.impl;

import cn.neusoft.domain.fenzhan.Bill;
import cn.neusoft.domain.BillInfo;
import cn.neusoft.mapper.BillInfoMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.service.BillInfoService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillInfoServiceImpl implements BillInfoService {
    @Autowired
    BillInfoMapper billInfoMapper;
    @Override
    public Integer add(BillInfo billInfo) {
        //首先检查该批次是否已经存在
        Integer bill_examine = billInfoMapper.findBatch(billInfo.getIn_batch());
        if(bill_examine == null){
            return billInfoMapper.add(billInfo);
        }else {
            //存在，返回-1
            return -1;
        }
    }

    @Override
    public List<Bill> findByBatch(int batch){
        List<Bill> billList = billInfoMapper.findByBatch(batch);
        List<Bill> billSort = new ArrayList<>();
        String[]state = new String[]{"领用","退回","作废","丢失"};
        for(int i=0;i< state.length;i++){
            for(int j=0;j<billList.size();j++){
                if(billList.get(j).getOpera().equals(state[i])){
                    billSort.add(billList.get(j));
                }
            }
        }
        return billSort;
    }

    @Override
    public PageQueryBean<BillInfo> findByPage(BaseQuery query) {
        //构建结果对象
        PageQueryBean<BillInfo> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(query.getPageNow(),query.getPageSize());
        //获得当页集合
        List<BillInfo> billInfoList = billInfoMapper.findByPage(query);
        //创建一个分页的实体PageInfo
        PageInfo<BillInfo> pageInfo = new PageInfo<>(billInfoList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }
}
