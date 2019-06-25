package com.itheima.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class datauntil {

    //  字符串转日期类型

    public  static  String date(  Date data , String str){

        SimpleDateFormat sim  = new SimpleDateFormat(str);
        String format = sim.format(data);
        return format;
    }

    //  日期转字符串类型
    public  static Date str(String stt, String str) throws ParseException {

        SimpleDateFormat sim  = new SimpleDateFormat(str);
        Date string = sim.parse(stt);
        return string;
    }


}
