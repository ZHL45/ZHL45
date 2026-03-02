package cn.neusoft.service;

import cn.neusoft.domain.EditOrderStatus;

public interface OrderStatusService {
    EditOrderStatus search(String o_id);

    Integer edit(String o_id);

}
