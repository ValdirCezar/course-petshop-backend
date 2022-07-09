package br.com.valdircezar.petshop.controller.impl;

import br.com.valdircezar.petshop.controller.UserController;
import br.com.valdircezar.petshop.entity.User;
import br.com.valdircezar.petshop.mapper.UserMapper;
import br.com.valdircezar.petshop.model.request.UserRequest;
import br.com.valdircezar.petshop.model.response.UserResponse;
import br.com.valdircezar.petshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService service;
    private final UserMapper mapper;

    @Override
    public ResponseEntity<UserResponse> create(UserRequest request) {
        service.create(request);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public ResponseEntity<UserResponse> update(Long id, UserRequest request) {
        final User response = service.update(id, request);
        return ResponseEntity.ok().body(mapper.toResponse(response));
    }
}
