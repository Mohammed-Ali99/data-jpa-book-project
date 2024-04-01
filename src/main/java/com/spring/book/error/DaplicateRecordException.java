package com.spring.book.error;

public class DaplicateRecordException extends RuntimeException{

    public DaplicateRecordException() {
    }

    public DaplicateRecordException(String message) {
        super(message);
    }
}
