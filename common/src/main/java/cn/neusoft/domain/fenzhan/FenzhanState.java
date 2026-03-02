package cn.neusoft.domain.fenzhan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
分站状态转换
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FenzhanState {
    String tid;//订单号
    String state;//状态
}
