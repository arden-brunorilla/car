package com.branacar.auto.service;
import com.branacar.auto.controller.dto.NewCarRequest;
import com.branacar.auto.exception.CarNotFoundException;
import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarStatus;
import com.branacar.auto.model.catalog.Model;
import com.branacar.auto.repository.CarRepository;
import com.branacar.auto.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepo;
    private final ModelRepository modelRepo;

    public Car createCar(NewCarRequest req) {

        Model model = modelRepo.findById(req.modelId())
                .orElseThrow(() -> new IllegalArgumentException("Model not found"));

        Car car = Car.builder()
                .carId(UUID.randomUUID())
                .vin(req.vin())
                .status(CarStatus.IN_STOCK)
                .listPrice(req.listPrice())
                .model(model)
                .build();

        return carRepo.save(car);
    }

    public Car getCar(UUID id) {
        return carRepo.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

}