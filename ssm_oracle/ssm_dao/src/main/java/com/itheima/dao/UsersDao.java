package com.itheima.dao;

import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import org.apache.ibatis.annotations.*;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface UsersDao {


     @Select("select * from users")
     public List<UserInfo> findall();


      @Select("select * from users where id = #{id}")
      @Results({
               @Result(id= true,property = "id",column = "id"),
               @Result(property = "username",column = "username"),
               @Result(property = "email",column = "email"),
               @Result(property = "password",column = "password"),
               @Result(property = "phoneNum",column = "phoneNum"),
               @Result(property = "status",column = "status"),
              @Result(property = "roles", column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.roledao.findallbyid"))



      })
     UserInfo findAllById(String id);
  @Insert("insert into users (username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void sava(UserInfo userInfo);
  @Select("select * from role where id not in (select roleid from users_role where userid = #{id})")
    List<Role> userAndRole(String id);


  @Insert("insert into users_role (userid,roleid) values(#{userid},#{role})")
    void savarole(@Param("userid") String userid, @Param("role") String role);
}
