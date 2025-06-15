package com.branacar.auto.model.catalog;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity @Table(name = "brands")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Brand {

    @Id
    private UUID brandId;

    @Column(nullable = false, unique = true)
    private String name;
}