package br.com.valdircezar.petshop.model.response;

import br.com.valdircezar.petshop.entity.Order;
import br.com.valdircezar.petshop.model.enumeration.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Set<ProfileEnum> profiles = new HashSet<>();
    private List<Order> orders = new ArrayList<>();
}
