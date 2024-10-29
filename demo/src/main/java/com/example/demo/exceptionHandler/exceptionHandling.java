package com.example.demo.exceptionHandler;

public class exceptionHandling extends RuntimeException{

    private String msg;
    private String status;
    public exceptionHandling(String msg) {
        super(msg);
    }
}
