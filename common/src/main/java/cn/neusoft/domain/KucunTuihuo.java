package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KucunTuihuo extends PageBean {
    // 库房、商品名称、总库存量、退回数量、可分配量、已分配量
    String fzname;
    String cname;
    int    total;
    int    total_tuihuonum;
    int    cid;
    int    total_yifenpeiNum;
}
