package com.itheima.dao;

import com.itheima.domian.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface Userdao {

    @Select("select * from users where username = #{username}")
    @Results({

            @Result (property = "id" ,column = "id"),
            @Result (property = "username" ,column = "username"),
            @Result (property = "email" ,column = "email"),
            @Result (property = "password" ,column = "password"),
            @Result (property = "phoneNum" ,column = "phoneNum"),
            @Result (property = "status" ,column = "status"),
            @Result(property = "roles",column = "id", javaType = java.util.List.class , many = @Many(select = "com.itheima.dao.roledao.findallbyid"))


    })
    public UserInfo findbyid(String username);
}
