package com.itheima.dao;

import com.itheima.domian.Syslog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysDao {



    @Select("select * from syslog")
    List<Syslog> findall();
}
