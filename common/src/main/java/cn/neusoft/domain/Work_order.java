package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work_order extends PageBean {
    // 订单号、任务单、客户姓名、投递地址、商品名称、商品数量、要求完成日期、任务类型、任务状态

    String order_num;           // 订单号
    String target;         //任务单
    String username;          // 客户姓名
    String address;                 // 投递地址
    String goods_name;                // 商品名称
    String goods_amount;            // 商品数量
    String accomplished_date;         // 要求完成日期
    String target_sort;                  //  任务类型
    String target_state;             //   任务状态

}
