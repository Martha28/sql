package com.stackroute.muzixapp.exception;

public class UserAlreadltExistsException extends Exception {
    private String message;

    public UserAlreadltExistsException(){

    }
    public UserAlreadltExistsException(String message){
     this.message=message;
    }
}
