package com.itheima.dao;

import com.itheima.domian.traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface travellersdao {


     @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
     public List<traveller>  find(String id );





}
