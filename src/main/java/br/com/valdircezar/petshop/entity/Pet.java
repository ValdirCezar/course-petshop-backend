package br.com.valdircezar.petshop.entity;

import br.com.valdircezar.petshop.model.enumeration.PortEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_PET")
public class Pet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthDate;

    @Column(length = 30)
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PortEnum port;

    private String description;

    @ToString.Exclude
    @OneToMany(mappedBy = "pet")
    private List<Order> orders = new ArrayList<>();
}
