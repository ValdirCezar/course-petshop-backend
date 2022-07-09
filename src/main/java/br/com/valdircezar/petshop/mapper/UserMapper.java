package br.com.valdircezar.petshop.mapper;

import br.com.valdircezar.petshop.entity.User;
import br.com.valdircezar.petshop.model.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequest request);
}
