package cn.neusoft.domain;

import cn.neusoft.domain.fenzhan.Bill_find;
import cn.neusoft.vo.PageBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
账单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jinhuodan  {
    String p_name;//商品名称
    String jinhuo_num;//进货量

}
