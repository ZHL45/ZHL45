package cn.neusoft.query;

import lombok.Data;

@Data
public class TuihuodanQuery extends BaseQuery{
    // 供 应 商 、进 货 日 期 段 、商 品 号
    String offerer;
    String startdate;
    String finishdate;
    String p_id;
}
