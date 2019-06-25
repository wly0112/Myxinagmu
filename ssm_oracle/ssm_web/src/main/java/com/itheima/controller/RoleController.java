package com.itheima.controller;

import com.itheima.domian.Permission;
import com.itheima.domian.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
  @Autowired
  private RoleService roleService;

    //角色查询

    @RequestMapping("/findall.do")
    public ModelAndView rolefindall(){
        List<Role> roleList = roleService.findall();
        ModelAndView mv = new ModelAndView();
       mv.addObject("roleList",roleList);
       mv.setViewName("role-list");
       return mv;





    }

    //角色详情
    @RequestMapping("/findById.do")
    public ModelAndView findbyidpermission(@RequestParam(name = "id") String roleid){
        Role role = roleService.findallid(roleid);
        ModelAndView mv  =new ModelAndView();
        mv.addObject("role",role);
                mv.setViewName("role-show");
        return mv;


    }

    //角色添加

@RequestMapping("/save.do")
    public String sava(Role role){

       roleService.sava(role);

        return  "redirect:findall.do";



    }


      //查询角色可以添加的权限
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView roleAndpermission(String id){
     Role role=   roleService.findallid(id);

       List<Permission>  permissions = roleService.roleAndpermission(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissionlist",permissions);
        mv.setViewName("role-permission-add");


        return  mv;




    }

    //把角色要添加的权限添加进role_permission中 并转到 查询角色列表
@RequestMapping("/addRoleAndpermission.do")
    public String savaRoleandPermission(@RequestParam(name = "roleid") String roleid ,@RequestParam(name = "permissionid") String []permissionid){

          roleService.savaRoleandPermission(roleid,permissionid);

          return "redirect:findall.do";


    }



}
