package cn.neusoft.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
分页设计
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Integer pageNow=1;
    private Integer pageSize=5;
    private Integer startIndex;

    public Integer getStartIndex() {
        return (pageNow-1)*pageSize;
    }
}
