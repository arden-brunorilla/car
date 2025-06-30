package com.branacar.auto.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "sale-service")
public interface SaleClient {
    @GetMapping("/sales/{id}")
    Object getSale(@PathVariable UUID id);

    @GetMapping("/people/clients")
    Object listClients();

    @GetMapping("/people/employees")
    Object listEmployees();
}
