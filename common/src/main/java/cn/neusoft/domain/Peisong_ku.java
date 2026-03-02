package cn.neusoft.domain;

import cn.neusoft.vo.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peisong_ku extends PageBean {
// 库房名称、库房地址、库管员、库房级别（中心or分站）、预警值、最高储存量
    String ku_name;
    String address;
    String administer;
    String jibie;
    String yujing;
    int    maxStore;

}
