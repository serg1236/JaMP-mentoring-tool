package com.dakhniy.jamp.handler;

import com.dakhniy.jamp.exception.ItemExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Sergiy_Dakhniy on 9/29/2016.
 */
@ControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageConversionException.class, ItemExistsException.class})
    public ResponseEntity<String> validationErrorHandler(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Cannot handle request.Wrong format.");
    }
}
