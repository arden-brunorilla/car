package com.branacar.auto.service;
import com.branacar.auto.controller.dto.NewCarRequest;
import com.branacar.auto.exception.CarNotFoundException;
import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarDto;
import com.branacar.auto.model.CarStatus;
import com.branacar.auto.model.catalog.Model;
import com.branacar.auto.repository.CarRepository;
import com.branacar.auto.repository.ModelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final CarRepository carRepo;
    private final ModelRepository modelRepo;

    public List<CarDto> findByStock(UUID stockId) {
        return carRepo.findByStockId(stockId).stream()
                .map(CarDto::from)
                .toList();
    }

    public List<CarDto> findAll() {
        return carRepo.findAll().stream()
                .map(CarDto::from)
                .toList();
    }

    @Transactional
    public void updateLocation(UUID carId, UUID stockId) {
        Car car = carRepo.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));
        car.setStockId(stockId);
    }

    public Car createCar(NewCarRequest req) {

        Model model = modelRepo.findById(req.modelId())
                .orElseThrow(() -> new IllegalArgumentException("Model not found"));

        Car car = Car.builder()
                .carId(UUID.randomUUID())
                .vin(req.vin())
                .status(CarStatus.IN_STOCK)
                .listPrice(req.listPrice())
                .model(model)
                .stockId(req.stockId())
                .build();

        return carRepo.save(car);
    }

    public Car getCar(UUID id) {
        return carRepo.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

}