package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaoduCulue  {
    // 订单号、订单类型、用户名、订单状态、送货日期、录入员、商品名称、商品数量、金额、收货人、地址、电话、邮编、执行任务分站、是否要发票、备注、分站}

    String  o_id;           // 订单号
    String order_sort;         //订单类型
    String o_state;                 // 订单状态
    String keyboarder;            // 录入员              ?
    String p_name;            // 商品名称
    String p_number;                  //  商品数量
    String fenzhan;             // 所属分站

}
