package com.itheima.controller;

import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import com.itheima.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.lang.reflect.Member;
import java.util.List;

@RequestMapping("/Users")
@Controller
public class UsersController {
    @Autowired
  private UsersService usersService;
    //查询所有用户
    @PermitAll  // 所有的角色都可以访问
    @RequestMapping("/findall.do")
    public ModelAndView findall(){

         ModelAndView mv = new ModelAndView();
        List<UserInfo> findall = usersService.findall();
        mv.addObject("userList",findall);
  mv.setViewName("user-list");
         return mv;


     }




     // 用户详情查询 根据id
   /* @RolesAllowed("司令")*/
    @RolesAllowed("主席")
     @RequestMapping("/findById.do")
    public  ModelAndView findallbyId(String id){

       UserInfo userInfo =  usersService.findAllById(id);
         ModelAndView  mv  =  new ModelAndView();
         mv.addObject("user",userInfo);
          mv.setViewName("user-show");
          return mv;


    }



    //用户添加
 /*   @RolesAllowed("主席")*/
    @RequestMapping("/save.do")

    public  String  sava(UserInfo userInfo){

            usersService.sava(userInfo);

            //重定向到查询所有用户
            return "redirect:findall.do";


    }

    // 查询该用户可以添加的角色信息
    @RequestMapping("/findUserByIdAndAllRole.do")
      public ModelAndView userAndRole(String id){
           //根据id 查询出需要添加角色的用户
          UserInfo userInfo = usersService.findAllById(id);

          //根据用户的id 查询出该用户不具有的角色
          List<Role> rolelist =   usersService.findallOther(id);

          ModelAndView mv = new ModelAndView();
          mv.addObject("user",userInfo);
          mv.addObject("roleList",rolelist);
          mv.setViewName("user-role-add");
          return mv;

    }


   //用户添加完毕点击保存 就把数据添加进去users_role中  然后跳转到 用户列表页面
    @RequestMapping("/addRoleToUser.do")
    public String savarole(@RequestParam(name = "userId") String userid, @RequestParam(name = "roleId") String[] roleid){

          usersService.savarole(userid,roleid);

          return "redirect:findall.do";
    }
}
