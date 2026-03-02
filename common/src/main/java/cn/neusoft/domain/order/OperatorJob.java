package cn.neusoft.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorJob {
    String p_type;          //一级分类
    String p_subtype;       //二级分类
    String p_name;          //商品名称
    // n:正常（包括商品是缺货状态的订单，反正是没有退换货取消的订单）   r:退货   e:换货   c:退订（取消的订单）
    int n_orderNum = 0;       //订单数
    int n_orderPNum = 0;      //商品数
    int n_orderAmount = 0;    //订单金额
    int r_orderNum = 0;
    int r_orderPNum = 0;
    int r_orderAmount = 0;
    int e_orderNum = 0;
    int e_orderPNum = 0;
    int e_orderAmount = 0;
    int c_orderNum = 0;
    int c_orderPNum = 0;
    int c_orderAmount = 0;
    int income;             //净收入
}
