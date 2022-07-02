package br.com.valdircezar.petshop.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public enum PortEnum {

    SMALL("SMALL"), MEDIUM("MEDIUM"), LARGE("LARGE");

    @Getter
    private final String description;

    public static PortEnum toEnum(String description) {
        if(description == null) {
            return null;
        }

        for (PortEnum x : PortEnum.values()) {
            if(description.equals(x.getDescription())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid port");
    }
}
