package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChukumingxiReturn{
    // 入/出库单号、仓库名、商品代码、商品名称、单价、商品数量、金额、任务号、出入库日期
    String allocateid;
    String fzname;
    String p_name;
    String p_id;
    String price;
    String num;
    String totalPrice;
    String tid;
    Date date;

}
