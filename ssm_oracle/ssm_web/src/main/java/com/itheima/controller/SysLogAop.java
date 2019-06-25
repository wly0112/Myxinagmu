package com.itheima.controller;

import com.itheima.dao.SyslogDao;
import com.itheima.domian.Syslog;
import com.itheima.service.SyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class SysLogAop {
   @Autowired
     private HttpServletRequest request;
   @Autowired
   private SyslogService syslogService;

    private Date startTime;  //访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方法

    // 主要获取访问时间、访问的类、访问的方法
    @Before("execution(* com.itheima.controller.*.*(..))")
    public void dobefore(JoinPoint jp) throws NoSuchMethodException {

        startTime = new Date();  // 访问的时间
        executionClass = jp.getTarget().getClass();  // 获取访问的类
        String merhodName = jp.getSignature().getName();//  获取访问的方法名称
        Object[] args = jp.getArgs();  // 获取访问的方法的参数

        if (args == null || args.length ==0 ){
            //表示 没有参数
    executionMethod  = executionClass.getMethod(merhodName);  // 只能获取无参的方法


        }else {
            //else {
            //// 有参数，就将args中所有元素遍历，获取对应的Class,装入到一个Class[]

            Class[] classArgs = new  Class[args.length];

            for (int i = 0; i <args.length ; i++) {
               classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(merhodName,classArgs); // 获取有参的方法



        }

    }

    /**
     * 主要获取 时长 ， ip  和 url
     *
     * @param jp
     */
    @AfterReturning("execution(* com.itheima.controller.*.*(..))")
    public  void  doafer(JoinPoint jp){

     Long  stoptime = new Date().getTime()-startTime.getTime(); // 获取时长

        if (executionClass !=null &&executionMethod!=null&& executionClass!=SysLogAop.class){

     String  url = "";
     // 获取类上的@RequestMapping的方法
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
    if (classAnnotation!= null){
        String[] classValue = classAnnotation.value();  //获取类上的RequestMapping的值

        // 获取方法上的@RequestMapping

        RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
        if (methodAnnotation!=null){

            String[] methodValue = methodAnnotation.value();

             url = classValue[0]+methodValue[0];

        }
    }

    // 获取访问的IP地址

            String  ip = request.getRemoteAddr();

   // 获取操作者
            String username  = SecurityContextHolder.getContext().getAuthentication().getName();


            Syslog syslog = new Syslog();
            syslog.setExecutionTime(stoptime); // 时长
            syslog.setIp(ip);  //ip
            syslog.setUrl(url); // url
            syslog.setUsername(username);  //操作者
            syslog.setVisitTime(startTime);  //访问的时间
            syslog.setMethod("[类名]"+executionClass.getName()+"[方法名]"+executionMethod.getName());  //访问的方法
  syslogService.sava(syslog);
        }







    }
}
