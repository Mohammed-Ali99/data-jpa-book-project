package com.spring.book.error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private LocalDateTime dateTime;
    private String message;
    private boolean success;
    private List<String> details;


    public ErrorResponse() {
    }

    public ErrorResponse(String message , List<String> details) {
        this.message = message;
        this.details = details;
        this.dateTime = LocalDateTime.now();
        this.success = Boolean.FALSE;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
