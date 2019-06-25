package com.itheima.service;

import com.itheima.domian.Permission;
import com.itheima.domian.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {

//角色查询
    public List<Role> findall();


      //角色添加
     void sava(Role role);


    List<Permission> roleAndpermission(String id);

    void savaRoleandPermission(String roleid, String[] permissionid);

    Role findallid(String id);
}
