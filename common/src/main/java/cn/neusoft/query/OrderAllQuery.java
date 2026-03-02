package cn.neusoft.query;

import lombok.Data;

@Data
public class OrderAllQuery extends BaseQuery{
    String c_name;
    String p_name;
    String o_id;
}
