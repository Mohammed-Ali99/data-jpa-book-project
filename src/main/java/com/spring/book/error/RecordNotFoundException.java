package com.spring.book.error;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
