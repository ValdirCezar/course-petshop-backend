package br.com.valdircezar.petshop.services.impl;

import br.com.valdircezar.petshop.entity.User;
import br.com.valdircezar.petshop.mapper.UserMapper;
import br.com.valdircezar.petshop.model.request.UserRequest;
import br.com.valdircezar.petshop.repository.UserRepository;
import br.com.valdircezar.petshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User create(UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }
}
