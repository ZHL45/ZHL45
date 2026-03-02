package cn.neusoft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
测试类，模拟其他人的表，进行联查
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    Integer tid;//主键id
    String information;//信息
}
