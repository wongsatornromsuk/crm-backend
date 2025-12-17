package com.backend.crm.exception;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private String code;        
    private int status;         
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private String stackTrace;

    public ApiErrorResponse(String code, int status, String message, String path, String stackTrace) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
        this.stackTrace = stackTrace;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStackTrace() {
        return stackTrace;
    }

}