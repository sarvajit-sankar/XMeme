package com.xmeme.starter.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String errorCode;
    
    public static ErrorResponse of(String message) {
        return new ErrorResponse(message, null);
    }
}

