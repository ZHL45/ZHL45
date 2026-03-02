package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillInfo {
    int in_batch;
    int in_startNumber;
    int in_endNumber;
}
