package com.example.exception;

public class IncorrectCountException  extends RuntimeException{
    public IncorrectCountException(String message){
        super((message));
    }
}
