package br.com.valdircezar.petshop.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private String error;
    private LocalDateTime timestamp;
    private String message;
    private String path;
}
