
package com.hang.tudou.tudouware.exception;

import com.hang.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截Controller
 * 全局异常处理
 */

@ControllerAdvice(annotations = {Controller.class, RestController.class})
@ResponseBody
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public R<String> exceptionHandler(Exception e){
        return R.error(e.getMessage());
    }
}


