package cn.neusoft.domain.kufang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods_Total {
    String cid;//商品编号
    Integer cnum;//库存量
}
