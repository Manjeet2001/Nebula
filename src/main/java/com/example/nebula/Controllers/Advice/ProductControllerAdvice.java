package com.example.nebula.Controllers.Advice;

import com.example.nebula.Controllers.ProductController;
import com.example.nebula.Exceptions.ProductNotFoundException;
import com.example.nebula.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//@ControllerAdvice(assignableTypes = {ProductController.class}) // To assign Exception to a specific controller
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // It will set the status Not_Found instead of 200ok
    @ResponseBody
    // It will set the status which is present in the body. It is auto implemented in ResponseStatus but custom implementing is advisable.
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setStatus("Failure");

        return exceptionDto;
    }
}
