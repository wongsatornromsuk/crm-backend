package com.backend.crm.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiErrorResponse> handleAppException(
            AppException ex,
            HttpServletRequest request
    ) {
        ErrorCode code = ex.getErrorCode();
        ApiErrorResponse body = new ApiErrorResponse(
                code.name(),
                code.getHttpStatus().value(),
                ex.getMessage(),
                request.getRequestURI(),
                ExceptionUtils.getStackTrace(ex)
        );
        return ResponseEntity.status(code.getHttpStatus()).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneric(
            Exception ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse body = new ApiErrorResponse(
                ErrorCode.INTERNAL_ERROR.name(),
                500,
                "Internal server error",
                request.getRequestURI(),
                ExceptionUtils.getStackTrace(ex)
        );
        return ResponseEntity.status(500).body(body);
    }

}