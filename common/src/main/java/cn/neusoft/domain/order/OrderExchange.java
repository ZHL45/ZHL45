package cn.neusoft.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderExchange {
    String o_id;
    String o_l_id;
    String c_name;
    String p_name;
    int p_number;
    int p_amount;
    String o_reason;
    String o_remark;
    String o_address;
    String o_receiver;
    String o_recPhone;
    String o_state;
}
