package com.gmy.springboot.exception;

import com.gmy.springboot.pojo.GmyJSONResult;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GMYAjaxExceptionHandler {

    public GmyJSONResult defaultErrorHandler(HttpServletRequest request,
                                             Exception e) throws Exception{
        e.printStackTrace();
        return GmyJSONResult.errorException(e.getMessage());
    }
}
