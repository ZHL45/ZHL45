package cn.neusoft.query;

import lombok.Data;

@Data
public class OrderExchangeQuery extends BaseQuery{
    String c_name;
    String p_name;
    String o_id;
}
