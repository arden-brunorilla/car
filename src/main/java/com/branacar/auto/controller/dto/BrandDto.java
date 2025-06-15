package com.branacar.auto.controller.dto;

import com.branacar.auto.model.catalog.Brand;

import java.util.UUID;

public record BrandDto(UUID brandId, String name) {
    public static BrandDto from(Brand b) {
        return new BrandDto(b.getBrandId(), b.getName());
    }
}
