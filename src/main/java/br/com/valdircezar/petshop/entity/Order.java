package br.com.valdircezar.petshop.entity;

import br.com.valdircezar.petshop.model.enumeration.StatusEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_ORDER")
@EntityListeners(AuditingEntityListener.class)
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 500)
    private String description;

    @CreatedDate
    private Date startDate;
    private LocalDateTime finishDate;

    @NotNull(message = "Price is required")
    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
