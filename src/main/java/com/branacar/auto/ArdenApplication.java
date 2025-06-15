package com.branacar.auto;

import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarStatus;
import com.branacar.auto.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class ArdenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArdenApplication.class, args);
    }

    /**
     * Inserta un Car de ejemplo con un VIN fijo para que puedas
     * probar rápidamente el endpoint GET /cars/{id}.
     */
    @Bean
    CommandLineRunner seedCar(CarRepository repo) {
        return args -> {
            repo.save(
                    Car.builder()
                            .carId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                            .vin("VIN-TEST-001")                    // ← tu VIN de prueba
                            .status(CarStatus.IN_STOCK)
                            .listPrice(new BigDecimal("25000000"))
                            .build()
            );
        };
    }
}