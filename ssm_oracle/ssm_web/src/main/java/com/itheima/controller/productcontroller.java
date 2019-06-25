package com.itheima.controller;

import com.itheima.domian.orders;
import com.itheima.domian.product;
import com.itheima.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import java.util.List;

@Controller
@RequestMapping("/product")
public class productcontroller {
    @Autowired
     private productservice productservice;

    /**
     * 产品查询
     * @return
     */

     @RequestMapping("/findall.do")
     public ModelAndView findall(){

          ModelAndView mv= new ModelAndView();

         List<product> findall = productservice.findall();

         mv.addObject("productList", findall);
         mv.setViewName("product-list");
         return mv;


     }

@RequestMapping("save.do")
       public  String   sava(product product){


           productservice.sava(product);

           return"redirect:findall.do";



       }






}
