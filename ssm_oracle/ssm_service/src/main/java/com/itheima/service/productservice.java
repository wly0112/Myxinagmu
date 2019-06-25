package com.itheima.service;

import com.itheima.domian.orders;
import com.itheima.domian.product;

import java.util.List;

public interface productservice {
     //查询产品信息
    public List<product> findall();
  //查询订单信息
    public   void sava(product product);

}
