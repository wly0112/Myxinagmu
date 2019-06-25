package com.itheima.controller;

import com.itheima.domian.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
  @Autowired
  private PermissionService permissionService;
    //资源权限查询
    @RequestMapping("/findAll.do")
    public ModelAndView findall(){
        List<Permission> permissionList = permissionService.findall();
        ModelAndView mv = new ModelAndView();
          mv.addObject("perssionlist",permissionList);
          mv.setViewName("premission-list");
         return  mv;




    }

    //权限添加
    @RequestMapping("/save.do")
    public String  sava(Permission permission){

          permissionService.sava(permission);

        return "redirect:findAll.do";
    }
}
