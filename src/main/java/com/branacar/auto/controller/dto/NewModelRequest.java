package com.branacar.auto.controller.dto;

import jakarta.validation.constraints.*;
import java.util.UUID;

public record NewModelRequest(
        @NotNull UUID brandId,
        @NotBlank String commercialName,
        String segment,
        @Min(1900) @Max(2100) Integer modelYear
) { }
