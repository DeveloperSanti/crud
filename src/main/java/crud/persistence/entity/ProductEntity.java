package crud.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(unique = true, nullable = false)
    private String name;

    private double price;

    private LocalDate date;

    private int antiquity;
}
