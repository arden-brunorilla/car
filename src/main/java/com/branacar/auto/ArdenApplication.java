package com.branacar.auto;

import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarStatus;
import com.branacar.auto.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.openfeign.EnableFeignClients;


import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class ArdenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArdenApplication.class, args);
    }
}