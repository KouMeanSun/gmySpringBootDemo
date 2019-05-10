package com.gmy.springboot.exception;

import com.gmy.springboot.pojo.GmyJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GMYExceptionHandler {

    public static final String GAOMINGYANG_ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request,
//                               HttpServletResponse response,
//                               Exception e) throws Exception{
//        e.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception",e);
//        mav.addObject("url",request.getRequestURL());
//        mav.setViewName(GAOMINGYANG_ERROR_VIEW);
//        return mav;
//    }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,
                               Exception e) throws Exception{
        e.printStackTrace();
        if (isAjax(request)){
            return GmyJSONResult.errorException(e.getMessage());
        }else{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(GAOMINGYANG_ERROR_VIEW);
        return mav;
        }
    }

    /**
     *
     * @Title:
     * @Package
     * @Description: 判断是否是ajax请求
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author
     * @date 2017年12月3日 下午1:40:39
     * @version V1.0
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
