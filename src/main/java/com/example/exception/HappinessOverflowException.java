package com.example.exception;

public class HappinessOverflowException extends RuntimeException{
    public HappinessOverflowException(String message){
        super((message));
    }
}
