package com.itheima.service;

import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;

import java.util.List;

public interface UsersService {

      public List<UserInfo> findall();

      UserInfo findAllById(String id);
      //添加用户
    void sava(UserInfo userInfo);

    List<Role> findallOther(String id);

    void savarole(String userid, String[] roleid);
}
