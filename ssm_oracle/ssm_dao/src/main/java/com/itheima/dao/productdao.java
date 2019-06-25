package com.itheima.dao;


import com.itheima.domian.orders;
import com.itheima.domian.product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface productdao {

  @Select("select * from product where id = #{id} ")
      public  product select(String id);

    @Select("select * from product")
    public List<product> findall();
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public  void sava(product product);


}
