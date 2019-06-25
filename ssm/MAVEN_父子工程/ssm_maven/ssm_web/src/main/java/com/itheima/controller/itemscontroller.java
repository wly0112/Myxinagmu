package com.itheima.controller;

import com.itheima.damian.items;
import com.itheima.service.itemsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class itemscontroller {
    @Autowired
    private itemsservice  itemsservice;
    @RequestMapping("/show.do")
    public  String findall(int id , Model model){
        items items = itemsservice.findall(id);
        model.addAttribute("item",items);

        return "itemDetail";


    }
}
