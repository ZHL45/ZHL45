package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorInfo {
    String op_name;
    String op_id;
    String op_tele;
    int op_income = 0;
}
