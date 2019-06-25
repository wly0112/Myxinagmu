package com.itheima.dao;

import com.itheima.domian.Syslog;
import org.apache.ibatis.annotations.Insert;

public interface SyslogDao {



    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
     public void  sava(Syslog syslog);
}
