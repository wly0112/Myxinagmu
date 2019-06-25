package com.itheima.service.impl;


import com.itheima.dao.productdao;
import com.itheima.domian.orders;
import com.itheima.domian.product;
import com.itheima.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("service")
@Transactional
public class productserviceimpl implements productservice {
    @Autowired
    private productdao productdao;


    @Override
    public List<product> findall() {


        return productdao.findall();
    }

    @Override
    public void sava(product product) {
           productdao.sava(product);
    }

}
