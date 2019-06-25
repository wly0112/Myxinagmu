package com.itheima.service.impl;

import com.itheima.dao.SysDao;
import com.itheima.domian.Syslog;
import com.itheima.service.Sysservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysserviceImpl implements Sysservice {

    @Autowired
    private SysDao sysDao;
    @Override
    public List<Syslog> findall() {
        return sysDao.findall();
    }
}
