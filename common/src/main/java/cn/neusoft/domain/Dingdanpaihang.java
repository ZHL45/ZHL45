package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dingdanpaihang {
    int paiming;
    String p_name;
    int count = 0;
}
