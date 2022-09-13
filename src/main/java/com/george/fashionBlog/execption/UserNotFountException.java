package com.george.fashionBlog.execption;

public class UserNotFountException extends RuntimeException{
    public UserNotFountException(String message){
        super(message);
    }
}
