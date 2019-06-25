package com.itheima.dao;

import com.itheima.domian.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface PermissionDao {



     @Select("select * from permission where id in (select  permissionId from role_permission where roleid=#{id})")
      public List<Permission> findall(String id);

     @Select("select * from permission")
     public  List<Permission> permissionfindall();
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void sava(Permission permission);
    @Select("select * from permission where id  in (select permissionid from role_permission where roleid=#{roleid})")
    public  List<Permission> findallbyId(String roleid);
}
