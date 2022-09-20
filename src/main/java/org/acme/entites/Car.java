package org.acme.entites;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Table
@Entity
public class Car extends PanacheEntity {
    @Id
    @SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "car_id_seq")
    private Long id;
    private String brand;
    private String name;
    @Column(name="model_year")
    private LocalDate modelYear;
    @Column(name="is_available_sale")
    private Boolean isAvailableSale;
    private BigDecimal price;
}
