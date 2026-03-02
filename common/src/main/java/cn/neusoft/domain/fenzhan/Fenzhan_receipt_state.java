package cn.neusoft.domain.fenzhan;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
分站状态转换
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fenzhan_receipt_state {
    String id;
    String state;
}
