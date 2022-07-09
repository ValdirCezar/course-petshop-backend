package br.com.valdircezar.petshop.mapper;

import br.com.valdircezar.petshop.entity.User;
import br.com.valdircezar.petshop.model.request.UserRequest;
import br.com.valdircezar.petshop.model.response.UserResponse;
import org.mapstruct.*;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequest request);

    User toEntity(UserRequest request, @MappingTarget User user);

    UserResponse toResponse(User response);
}
