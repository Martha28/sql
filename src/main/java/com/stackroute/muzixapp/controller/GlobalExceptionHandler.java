package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.exception.UserAlreadltExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Not all mandatory fields are filled")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handleEmptyFieldException(TrackNotFoundException e){
        System.out.println("Not all mandatory fields are filled");
    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="User already exists")
    @ExceptionHandler(UserAlreadltExistsException.class)
    public void handleUserAlreadyExistsException(UserAlreadltExistsException e){
        System.out.println("User already exists");
    }

}