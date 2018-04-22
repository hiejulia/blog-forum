package com.project.blogforum.exception;



import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ModelAndView allExceptions(Exception exception) {


        String message = exception.getMessage();
        if (StringUtils.isEmpty(message))
            message = "Article is not available!";

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", message);
        mav.setViewName("error");
        return mav;
    }

}
