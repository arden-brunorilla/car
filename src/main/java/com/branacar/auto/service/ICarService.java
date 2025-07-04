package com.branacar.auto.service;

import com.branacar.auto.controller.dto.NewCarRequest;
import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarDto;

import java.util.List;
import java.util.UUID;

public interface ICarService {
    List<CarDto> findByStock(UUID stockId);
    List<CarDto> findAll();
    void updateLocation(UUID carId, UUID stockId);
    Car createCar(NewCarRequest req);
    Car getCar(UUID id);
}