package cn.neusoft.domain.fenzhan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill_find {
    String o_id;//订单号
    Integer p_amount;//订单金额
    String o_receiver;//使用人姓名
}
