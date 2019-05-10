package com.gmy.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneInterceptor  implements HandlerInterceptor {

    /*
    * 在请求之前进行调用(Controller方法调用之前)
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object) throws  Exception{
            System.out.println("被one拦截，放行...");
            return true;
            /*
            * 具体业务根据判断返回是否放行*/
    }
}
