package cn.neusoft.service.serviceImplement;

import cn.neusoft.domain.*;
import cn.neusoft.mapper.ChukudiaohuoMapper;
import cn.neusoft.mapper.QuehuodiaohuoMapper;
import cn.neusoft.query.*;
import cn.neusoft.service.ChukudiaohuoService;
import cn.neusoft.service.QuehuojinhuoService;
import cn.neusoft.vo.PageQueryBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuehuojinuhoServiceImp implements QuehuojinhuoService {
    @Autowired
    QuehuodiaohuoMapper quehuodiaohuoMapper;
    @Override
    public PageQueryBean<Quehuojinhuo> lackFindByPage(QuehuoQuery quehuoQuery){
        // 1.根据order_infa_all来groupby商品，知道商品的累计数量，赋值到中心yujing表的yujing值里
        // 先删除中心yujing表里的所有数据，因为每次都重新插入
        quehuodiaohuoMapper.deleteyujing();
        quehuodiaohuoMapper.fuzhiyujing();

        // 2.根据预警值来更新lack表的缺货数量和状态。数量：库房值减去yujign值
        // 先删除order_info_lack的所有数据，再分两次填充，一次填id等，一次填缺货数量
        quehuodiaohuoMapper.deletelack();
        // 填充1
        quehuodiaohuoMapper.addlack1();
        // 填充2:将联查total，yujing并新增相减的缺货量字段的表的缺货量字段赋值
        quehuodiaohuoMapper.addlack2();
        // 修改lack表中的state状态，如果缺货量字段小于0，设置为缺货
        quehuodiaohuoMapper.setquehuo();

        //构建结果对象
        PageQueryBean<Quehuojinhuo> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(quehuoQuery.getPageNow(),quehuoQuery.getPageSize());
        //获得当页集合
        List<Quehuojinhuo> QuehuoijnhuoList = quehuodiaohuoMapper.lackFindByPage(quehuoQuery);

        //创建一个分页的实体PageInfo
        PageInfo<Quehuojinhuo> pageInfo = new PageInfo<>(QuehuoijnhuoList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;
    }

    // 进货操作
    public Integer jinhuodan(String o_id,String cname,String jinhuo_num){
        // 先联查，把jinhuoQuery的o_id，jinhuo_num属性赋全
        JinhuoQuery jinhuoQuery2 = quehuodiaohuoMapper.selectByName(cname);
        jinhuoQuery2.setO_id(o_id);
        jinhuoQuery2.setJinhuo_num(jinhuo_num);
        System.out.println(jinhuoQuery2);
        // 进货
        Integer a = quehuodiaohuoMapper.jinhuodan(jinhuoQuery2);
        System.out.println("成功向goods1生成进货单");

        if (a != null){
            // 还要把lack里的数字不再是负数，否则又刷新为缺货
            int cid = jinhuoQuery2.getCid();
            System.out.println(cid);
            int jinhuonum=Integer.parseInt(jinhuo_num);
            quehuodiaohuoMapper.setkufang(cid,jinhuonum);

            // 进货成功，将lack表里的字段设为已补货
            quehuodiaohuoMapper.set(o_id);
            System.out.println("成功修改lack中状态为已经补货");
        }
        return  a;
    }

    //   展示所有退货单
    public PageQueryBean<Tuihuodan> findByPage(TuihuodanQuery tuihuodanQuery){
        //构建结果对象
        PageQueryBean<Tuihuodan> pageQueryBean = new PageQueryBean<>();
        //开启分页
        PageHelper.startPage(tuihuodanQuery.getPageNow(),tuihuodanQuery.getPageSize());
        //获得当页集合
        List<Tuihuodan> TuihuodanList = quehuodiaohuoMapper.findByPage(tuihuodanQuery);
        for (int a=0;a<TuihuodanList.size();a++){
            System.out.println(TuihuodanList.get(a));
        }

        ArrayList<Tuihuodan> TuihuodanList2 = new ArrayList<>();
        // 去掉state为已完成的对象：


        //创建一个分页的实体PageInfo
        PageInfo<Tuihuodan> pageInfo = new PageInfo<>(TuihuodanList);

        pageQueryBean.setTotalRows(pageInfo.getTotal());
        pageQueryBean.setTotalPages(pageInfo.getPages());
        pageQueryBean.setRowData(pageInfo.getList());

        return pageQueryBean;

    }

    public Integer tuihuo(String o_id,String tuihuo_num){
        System.out.println("拖货单id和数量"+o_id+tuihuo_num);
        int a =quehuodiaohuoMapper.tuihuo(o_id,tuihuo_num);
        // 将return表中状态置为已完成
        if (a!=0){
            System.out.println("准备修改成已完成退货状态");
            quehuodiaohuoMapper.editState(o_id);
        }
        return a;

    }
}
