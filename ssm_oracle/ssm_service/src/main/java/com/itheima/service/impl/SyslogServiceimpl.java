package com.itheima.service.impl;

import com.itheima.dao.SyslogDao;
import com.itheima.domian.Syslog;
import com.itheima.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SyslogServiceimpl implements SyslogService {
 @Autowired
 private SyslogDao syslogDao ;

    @Override
    public void sava(Syslog syslog) {
        syslogDao.sava(syslog);

    }
}
