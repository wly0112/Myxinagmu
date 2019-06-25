package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ordersdao;
import com.itheima.domian.orders;
import com.itheima.service.ordersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("orderservice")
@Transactional
public class ordersserviceimpl implements ordersservice {
@Autowired
    private ordersdao ordersdao;
    @Override
    public List<orders> select(int page, int size) {
        PageHelper.startPage(page,size);
        List<orders> ordersList = ordersdao.select();
        return ordersList;
    }

    @Override
    public orders orderselect(String id) {


        orders orderselect = ordersdao.orderselect(id);
        return  orderselect;


    }

}
