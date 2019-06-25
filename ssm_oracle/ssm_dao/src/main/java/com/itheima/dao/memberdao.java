package com.itheima.dao;

import com.itheima.domian.member;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Member;

public interface memberdao {
    @Select("select * from member where id  = #{id}")
     public member memberfindall(String  id );
}
