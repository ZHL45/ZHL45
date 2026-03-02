package cn.neusoft.vo;


import lombok.Data;

import java.util.List;

@Data
public class PageQueryBean<T> {
    private Integer totalPages;
    private Long totalRows;
    private List<T> rowData;
}
