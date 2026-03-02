package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offerer extends PageBean {

    String o_name;
    String address;
    String contact;
    String phone;
    String kaihuhang;
    int    bank_id;
    String fax;
    int    code;
    String faren;
    String remark;

}
