package com.branacar.auto.model.catalog;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity @Table(name = "models")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Model {

    @Id
    private UUID modelId;

    @Column(nullable = false)
    private String commercialName;      // ej. "Fiesta"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private String segment;             // B, C, SUV, etc.
    private Integer modelYear;          // 2025, 2024…
}
