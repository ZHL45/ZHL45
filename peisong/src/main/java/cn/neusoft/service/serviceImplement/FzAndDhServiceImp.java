package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.*;
import cn.neusoft.mapper.ChukudiaohuoMapper;
import cn.neusoft.mapper.FzAndDhMapper;
import cn.neusoft.query.BaseQuery;
import cn.neusoft.query.DingdanpaihangQuery;
import cn.neusoft.service.ChukudiaohuoService;
import cn.neusoft.service.FzAndDhService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FzAndDhServiceImp implements FzAndDhService {
    @Autowired
    FzAndDhMapper fzAndDhMapper;

    @Override
    public List<Dingdanpaihang> findByPage(DingdanpaihangQuery dingdanpaihangQuery){
        List<Dingdanpaihang> dingdanpaihangList = fzAndDhMapper.findByPage(dingdanpaihangQuery);
        List<Dingdanpaihang> dingdanpaihangList1 = new ArrayList<>();
        for(int i = 0;i < dingdanpaihangList.size();i++){
            Dingdanpaihang dingdanpaihang = new Dingdanpaihang();
            dingdanpaihang.setP_name(dingdanpaihangList.get(i).getP_name());
            do{
                Dingdanpaihang dingdanpaihang1 = dingdanpaihangList.get(i);
                dingdanpaihang.setCount(dingdanpaihang.getCount() + dingdanpaihang1.getCount());
                i++;
            }while (i<dingdanpaihangList.size() && dingdanpaihangList.get(i).getP_name().equals(dingdanpaihangList.get(i-1).getP_name()));
            i--;
            dingdanpaihangList1.add(dingdanpaihang);
        }
        //对list，根据订购量进行排序
        System.out.println(dingdanpaihangList1);
//        dingdanpaihangList1.sort(Comparator.comparing(Dingdanpaihang::getCount).reversed());
        List<Dingdanpaihang> dingdanpaihangList2 = dingdanpaihangList1.stream().sorted(Comparator.comparing(Dingdanpaihang::getCount).reversed()).collect(Collectors.toList());
        System.out.println(dingdanpaihangList2);

        // 给list中的每一个对象的paimng复制
        for (int a=0;a<dingdanpaihangList2.size();a++){
            dingdanpaihangList2.get(a).setPaiming(a+1);
        }

        return dingdanpaihangList2;

    }
}
