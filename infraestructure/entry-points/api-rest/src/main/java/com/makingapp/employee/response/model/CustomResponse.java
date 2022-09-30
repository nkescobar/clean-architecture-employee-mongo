package com.makingapp.employee.response.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomResponse<T> {
    private String message;
    private String error;
    private HttpStatus status;
    private T response;
}
