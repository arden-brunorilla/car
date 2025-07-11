package com.branacar.auto.controller;

import com.branacar.auto.controller.dto.NewCarRequest;
import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarDto;
import com.branacar.auto.service.ICarService;
import com.branacar.auto.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarService service;

    @GetMapping("/by-stock/{stockId}")
    public List<CarDto> byStock(@PathVariable UUID stockId) {
        return service.findByStock(stockId);
    }

    @PutMapping("/{id}/location/{stockId}")
    public ResponseEntity<Void> changeLocation(@PathVariable UUID id,
                                               @PathVariable UUID stockId) {
        service.updateLocation(id, stockId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<CarDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable UUID id) {
        return ResponseEntity.ok( CarDto.from(service.getCar(id)) );
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody NewCarRequest req) {
        Car car = service.createCar(req);
        return ResponseEntity.ok(CarDto.from(car));
    }
}