package com.itheima.service;

import com.itheima.domian.orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface ordersservice {
    //查询订单信息

    public List<orders> select(int page, int size);


    //查询订单详情
    orders orderselect(String id);

}
