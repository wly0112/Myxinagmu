package com.itheima.service.impl;

import com.itheima.dao.PermissionDao;
import com.itheima.domian.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findall() {


        return permissionDao.permissionfindall();
    }

    @Override
    public void sava(Permission permission) {
        permissionDao.sava(permission);
    }
}
