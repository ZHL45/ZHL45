package cn.neusoft.domain.fenzhan;

import cn.neusoft.vo.PageBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskList2 extends PageBean {
    String o_id;//任务号
    String c_name;//客户姓名
    String o_address;//投递地址
    String p_name;//商品名称
    String p_number;//商品数量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建起始时间，格式 yyyy-MM-dd HH:mm:ss")
    Date o_date;//要求完成日期
    String o_afterSales;//任务类型
    String o_state;//任务状态
    String deliver;//联查快递员时使用


}
