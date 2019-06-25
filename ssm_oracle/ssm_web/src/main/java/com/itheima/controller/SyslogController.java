package com.itheima.controller;

import com.itheima.domian.Syslog;
import com.itheima.service.Sysservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SyslogController {
     @Autowired
      private Sysservice sysservice;
    //查询日志信息
    @RequestMapping("/findAll.do")
    public ModelAndView findall(){
      List<Syslog> syslogs =  sysservice.findall();
        ModelAndView mv= new ModelAndView();
        mv.addObject("sysLogs",syslogs);
         mv.setViewName("syslog-list");
        return mv;


    }
}
