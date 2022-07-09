package br.com.valdircezar.petshop.controller;

import br.com.valdircezar.petshop.model.request.UserRequest;
import br.com.valdircezar.petshop.model.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserController {

    @PostMapping
    ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request);
}
