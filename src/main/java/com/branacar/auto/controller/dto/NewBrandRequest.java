package com.branacar.auto.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record NewBrandRequest(@NotBlank String name) { }
