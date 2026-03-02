package cn.neusoft.query;

import lombok.Data;

@Data
public class ChurukuMinxiQuery extends BaseQuery{
    String fzname;
    String p_name;
    String  date1;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty("创建起始时间，格式：yyyy-MM-dd HH:mm:ss")
    String  date2;
}
