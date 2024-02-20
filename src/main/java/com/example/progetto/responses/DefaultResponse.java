package com.example.progetto.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
@Data
public class DefaultResponse {
    private String message;
    private Object response;
    private LocalDateTime dateResponse;

    public DefaultResponse(String message, Object response) {
        this.message = message;
        this.response = response;
        dateResponse=LocalDateTime.now();
    }
    public DefaultResponse(String message) {
        this.message = message;
        dateResponse=LocalDateTime.now();
    }
    public static ResponseEntity<DefaultResponse> noObject(String message, HttpStatus status){
        DefaultResponse dr=new DefaultResponse(message);
        return new ResponseEntity<>(dr,status);
    }
    public static ResponseEntity<DefaultResponse> noMessage(Object obj,HttpStatus status){
        DefaultResponse dr=new DefaultResponse(status.toString(),obj);
        return new ResponseEntity<>(dr,status);
    }
    public static ResponseEntity<DefaultResponse> customMessage(String message,Object obj,HttpStatus status){
        DefaultResponse dr=new DefaultResponse(message,obj);
        return new ResponseEntity<>(dr,status);
    }
}
