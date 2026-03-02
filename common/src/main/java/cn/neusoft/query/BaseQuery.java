package cn.neusoft.query;

import lombok.Data;

@Data
public class BaseQuery {
    private Integer pageNow = 1;
    private Integer pageSize = 5;
}
