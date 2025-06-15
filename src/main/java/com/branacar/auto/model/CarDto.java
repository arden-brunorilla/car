package com.branacar.auto.model;

import java.math.BigDecimal;
import java.util.UUID;

public record CarDto(
        UUID carId,
        String vin,
        CarStatus status,
        BigDecimal listPrice
) {
    public static CarDto from(Car car) {
        return new CarDto(
                car.getCarId(),
                car.getVin(),
                car.getStatus(),
                car.getListPrice()
        );
    }
}