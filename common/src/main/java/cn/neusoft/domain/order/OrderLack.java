package cn.neusoft.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLack {
    String o_id;
    String ol_id;
    String p_name;
    int p_number;
    String o_state;
}
