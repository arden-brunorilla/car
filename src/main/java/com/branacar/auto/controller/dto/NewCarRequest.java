package com.branacar.auto.controller.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

public record NewCarRequest(
        @NotNull UUID modelId,
        @NotBlank String vin,
        @DecimalMin("0.0") BigDecimal listPrice
) { }