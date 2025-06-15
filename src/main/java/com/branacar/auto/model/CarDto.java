package com.branacar.auto.model;

import java.math.BigDecimal;
import java.util.UUID;

public record CarDto(
        UUID carId,
        String vin,
        String status,
        BigDecimal listPrice,
        String modelName,
        String brandName
) {
    public static CarDto from(Car car) {
        return new CarDto(
                car.getCarId(),
                car.getVin(),
                car.getStatus().name(),
                car.getListPrice(),
                car.getModel().getCommercialName(),
                car.getModel().getBrand().getName()
        );
    }
}