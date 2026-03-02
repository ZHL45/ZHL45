package cn.neusoft.query;

import lombok.Data;

@Data
public class DiaoduOrderQuery extends BaseQuery{
    String startdate;
    String finishdate;
    String o_sort;
}
