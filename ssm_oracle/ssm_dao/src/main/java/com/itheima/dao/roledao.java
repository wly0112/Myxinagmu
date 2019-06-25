package com.itheima.dao;

import com.itheima.domian.Permission;
import com.itheima.domian.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface roledao {

@Select("select  * from role where id in (select roleId from  users_role where userId = #{id})")
 @Results({

         @Result(id = true,property = "id",column = "id"),
         @Result(property = "roleName",column = "roleName"),
         @Result(property = "roleDesc",column = "roleDesc"),
         @Result(property ="permissions",column = "id",javaType = java.util.List.class,many = @Many(select ="com.itheima.dao.PermissionDao.findall" ))
 })
    public List<Role> findallbyid(String id);


@Select("select  * from role")
  public  List<Role> findall();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void sava(Role role);
   @Select("select * from permission where id not in (select permissionid from role_permission where roleid= #{id})")
    List<Permission> roleAndpermission(String id);

     @Insert("insert into role_permission  values (#{permission},#{roleid})")
    void savaRoleandPermission(@Param("roleid") String roleid,@Param("permission") String permission);


     @Select("select * from role where id = #{id}")
     @Results({
             @Result(id=true,property = "id",column = "id"),
             @Result(property = "roleName",column = "roleName"),
             @Result(property = "roleDesc",column = "roleDesc"),
             @Result(property = "permissions",column = "id",javaType = java.util.List.class,many =@Many(select = "com.itheima.dao.PermissionDao.findallbyId") )

     })
    Role findallid(String id);
}
