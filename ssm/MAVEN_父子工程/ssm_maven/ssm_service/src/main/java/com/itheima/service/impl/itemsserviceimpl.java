package com.itheima.service.impl;

import com.itheima.damian.items;
import com.itheima.dao.itemsdao;
import com.itheima.service.itemsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class itemsserviceimpl implements itemsservice {
    @Autowired
    private itemsdao  itemsdao;
    public items findall(int id) {
        items items = itemsdao.findall(id);
        return items;
    }
}
