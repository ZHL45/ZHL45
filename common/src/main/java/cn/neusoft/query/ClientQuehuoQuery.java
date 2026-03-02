package cn.neusoft.query;

import lombok.Data;

@Data
public class ClientQuehuoQuery extends BaseQuery{
    String client_name;
    String startdate;
    String finishdate;
}
