package br.com.valdircezar.petshop.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public enum ProfileEnum {

    ADMIN("ADMIN"), USER("USER"), CLIENT("CLIENT");

    @Getter
    private final String description;

    public static ProfileEnum toEnum(String description) {
        if(description == null) {
            return null;
        }

        for (ProfileEnum x : ProfileEnum.values()) {
            if(description.equals(x.getDescription())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid profile");
    }
}
