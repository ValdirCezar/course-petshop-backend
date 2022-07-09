package br.com.valdircezar.petshop.services;

import br.com.valdircezar.petshop.entity.User;
import br.com.valdircezar.petshop.model.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User create(UserRequest request);
}
