package com.branacar.auto.repository;

import com.branacar.auto.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByStockId(UUID stockId);
}
