package com.branacar.auto.controller;

import com.branacar.auto.model.CarDto;
import com.branacar.auto.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable UUID id) {
        return ResponseEntity.ok( CarDto.from(service.getCar(id)) );
    }
}