package com.itheima.service.impl;

import com.itheima.dao.UsersDao;
import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import com.itheima.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserInfo> findall() {


        return usersDao.findall();
    }

    @Override
    public UserInfo findAllById(String id) {
        return usersDao.findAllById(id);

    }

    @Override
    public void sava(UserInfo userInfo) {
        //加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword())
        );
        usersDao.sava(userInfo);
    }

    @Override
    public List<Role> findallOther(String id) {

      return   usersDao.userAndRole(id);

    }

    @Override
    public void savarole(String userid, String[] roleid) {


        for (String role : roleid) {
              usersDao.savarole(userid,role);
        }
    }
}
