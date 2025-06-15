package com.branacar.auto.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cars")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Car {

    @Id
    private UUID carId;

    private String vin;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private BigDecimal listPrice;
}