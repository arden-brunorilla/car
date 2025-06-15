package com.branacar.auto.service;
import com.branacar.auto.exception.CarNotFoundException;
import com.branacar.auto.model.Car;
import com.branacar.auto.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repo;

    public Car getCar(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }
}
