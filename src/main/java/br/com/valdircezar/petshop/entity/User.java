package br.com.valdircezar.petshop.entity;

import br.com.valdircezar.petshop.model.enumeration.ProfileEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_USER")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String phone;

    @ElementCollection
    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Set<ProfileEnum> profiles = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
}
