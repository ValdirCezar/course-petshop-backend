package br.com.valdircezar.petshop.services.impl;

import br.com.valdircezar.petshop.entity.User;
import br.com.valdircezar.petshop.mapper.UserMapper;
import br.com.valdircezar.petshop.model.request.UserRequest;
import br.com.valdircezar.petshop.repository.UserRepository;
import br.com.valdircezar.petshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User create(UserRequest request) {
        validateIfEmailAlreadyExists(request);
        return repository.save(mapper.toEntity(request));
    }

    @Override
    public User update(Long id, UserRequest request) {
        var user = findById(id);
        user = mapper.toEntity(request, user);
        return repository.save(user);
    }

    private User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private void validateIfEmailAlreadyExists(UserRequest request) {
        if(repository.findByEmail(request.getEmail()).isPresent()) {
            throw new DataIntegrityViolationException("E-mail already exists");
        }
    }

}
