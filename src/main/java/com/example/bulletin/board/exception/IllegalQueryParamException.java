package com.example.bulletin.board.exception;

public class IllegalQueryParamException extends RuntimeException{
    public IllegalQueryParamException(String message) {
        super(message);
    }
}
