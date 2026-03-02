package cn.neusoft.query;

import lombok.Data;

/*
客户信息的分页条件查询
 */
@Data
public class CustomerInfoQuery extends BaseQuery{
    String c_name;
    String c_identity;
    String c_mTele;
}
