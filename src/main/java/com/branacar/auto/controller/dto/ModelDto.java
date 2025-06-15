package com.branacar.auto.controller.dto;

import com.branacar.auto.model.catalog.Model;

import java.util.UUID;

public record ModelDto(
        UUID modelId,
        String commercialName,
        String brandName,
        String segment,
        Integer modelYear
) {
    public static ModelDto from(Model m) {
        return new ModelDto(
                m.getModelId(),
                m.getCommercialName(),
                m.getBrand().getName(),
                m.getSegment(),
                m.getModelYear()
        );
    }
}
