package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domian.orders;
import com.itheima.service.ordersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RequestMapping("/order")
@Controller
public class orderscontroller {
  @Autowired
  private ordersservice  ordersservice;

/*
  @RequestMapping("/select.do")
    public ModelAndView select(){

        ModelAndView mv = new ModelAndView();

        List<orders> ordersList =ordersservice.select(page, size);
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return  mv;
    }
*/


    @RequestMapping("/selectpage.do")
    public ModelAndView selectpage(@RequestParam(value = "page" , defaultValue ="1") Integer page,@RequestParam(value = "size",defaultValue = "3") Integer size){


        ModelAndView mv = new ModelAndView();
        List<orders> ordersList = ordersservice.select(page, size);


        PageInfo info = new PageInfo(ordersList);
          mv.addObject("info",info);
          mv.setViewName("orders-page-list");

        return  mv;
    }
 @RequestMapping("/orders.do")
    public  ModelAndView ordelfindall( String id ) {

     ModelAndView mv = new ModelAndView();

     orders order = ordersservice.orderselect(id);

     mv.addObject("orders", order);
     mv.setViewName("orders-show");
     return mv;
 }
    }


