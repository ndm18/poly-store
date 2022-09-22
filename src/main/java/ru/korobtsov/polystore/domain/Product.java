package ru.korobtsov.polystore.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Positive
    @Column(name = "price", nullable = false, precision = 19, scale = 4)
    public BigDecimal price;

    @Length(min = 1, max = 1023)
    @Column(name = "description", length = 1023)
    public String description;
}



