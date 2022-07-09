package br.com.valdircezar.petshop.model.request;

import br.com.valdircezar.petshop.model.enumeration.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotEmpty(message = "Field name is required")
    @Length(min = 3, max = 30, message = "Field name must have between 3 and 30 characters")
    private String name;

    @Email
    @NotEmpty(message = "Field email is required")
    private String email;

    @NotEmpty(message = "Field password is required")
    @Length(min = 3, max = 30, message = "Field password must have between 3 and 30 characters")
    private String password;

    @NotEmpty(message = "Field phone is required")
    private String phone;

    private Set<ProfileEnum> profiles = new HashSet<>();
}
