package com.itheima.service.impl;

import com.itheima.dao.Userdao;
import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import com.itheima.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class userserviceimpl implements userservice {

    @Autowired
    private Userdao userdao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo =  userdao.findbyid(username);

        //处理自己的用户对象 封装成 UserDetails
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();

          for (Role role : roles){

              list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
          }

        return list;



    }

}
