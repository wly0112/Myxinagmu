package com.itheima.service.impl;

import com.itheima.dao.roledao;
import com.itheima.domian.Permission;
import com.itheima.domian.Role;
import com.itheima.service.RoleService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private roledao  roledao;
    @Override
    public List<Role> findall() {
        return roledao.findall();
    }

    @Override
    public void sava(Role role) {
        roledao.sava(role);
    }

    @Override
    public List<Permission> roleAndpermission(String id) {
      return   roledao.roleAndpermission(id);

    }

    @Override
    public void savaRoleandPermission(String roleid, String[] permissionid) {
        for (String permission : permissionid) {
            roledao.savaRoleandPermission(roleid,permission);

        }
    }

    @Override
    public Role findallid(String id) {

        return roledao.findallid(id);
    }
}
