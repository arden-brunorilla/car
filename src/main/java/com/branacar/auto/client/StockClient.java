package com.branacar.auto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@FeignClient(name ="stock-service")
public interface StockClient {
    @GetMapping("/stocks")
    Object listStocks();

    @GetMapping("/stocks/{id}/inventory")
    Object getInventory(@PathVariable UUID id);

    @PostMapping("/stocks/movements")
    Object createMovement(@RequestBody Object movementRequest);
}
