package com.dakhniy.jamp.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sergiy_Dakhniy on 10/3/2016.
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    private static final String ERROR_500_MESSAGE = "Unknown server error";

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultError() {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("code", 500);
        mv.addObject("errorMessage", ERROR_500_MESSAGE);
        return mv;
    }

}
