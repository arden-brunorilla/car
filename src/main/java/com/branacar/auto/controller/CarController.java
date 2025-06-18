package com.branacar.auto.controller;

import com.branacar.auto.model.CarDto;
import com.branacar.auto.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

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


    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable UUID id) {
        return ResponseEntity.ok( CarDto.from(service.getCar(id)) );
    }
}