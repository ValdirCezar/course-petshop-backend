package br.com.valdircezar.petshop.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public enum StatusEnum {

    OPEN("OPEN"), PROGRESS("PROGRESS"), CLOSE("CLOSE");

    @Getter
    private final String description;

    public static StatusEnum toEnum(String description) {
        if(description == null) {
            return null;
        }

        for (StatusEnum x : StatusEnum.values()) {
            if(description.equals(x.getDescription())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid status");
    }
}
