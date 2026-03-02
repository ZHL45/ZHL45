package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaoduShowXiangqing {

    String  o_id;           // 订单号
    String p_type;         //订单类型               ?
    String c_name;          // 用户名
    String o_state;                 // 订单状态
    String o_date;                // 送货日期
    String luruyuan_id;            // 录入员编号              ?
    String p_name;            // 商品名称
    String p_number;                  //  商品数量
    String p_amount;             //   金额
    String o_receiver;               //   收货人
    String o_address;               // 地址
    String o_recPhone;               // 电话
    String o_postcode;               // 邮编
    String suoshufz;               // 所属分站        ?
    String o_invoice;               // 是否要发票
    String remark;                // 备注                  ?

}
