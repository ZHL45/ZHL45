package cn.neusoft.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
配送单
 */
@Data
public class Deliver {
    Integer taskid;
    String postman;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date taskdate;
}
