package com.itheima.dao;

import com.itheima.domian.member;
import com.itheima.domian.orders;
import com.itheima.domian.product;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;


import java.util.List;

public interface ordersdao {

    @Select("select * from orders")
    @Results({
            @Result(id=true ,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = product.class,one = @One(select = "com.itheima.dao.productdao.select"))

    })
    public List<orders> select();

    @Select(" select * from orders where id = #{id} ")
    @Results({
            @Result(id=true ,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = product.class,one = @One(select = "com.itheima.dao.productdao.select")),
            @Result(property = "member" ,column = "memberid",javaType = member.class,one = @One(select = "com.itheima.dao.memberdao.memberfindall")),
            @Result( property = "travellers", column = "id", javaType = java.util.List.class , many =  @Many(select = "com.itheima.dao.travellersdao.find"))

    })
   public orders orderselect(String id);
}
