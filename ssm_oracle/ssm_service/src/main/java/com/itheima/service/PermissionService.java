package com.itheima.service;

import com.itheima.domian.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findall();

    void sava(Permission permission);
}
