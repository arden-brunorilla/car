package com.branacar.auto.service;

import com.branacar.auto.controller.dto.BrandDto;
import com.branacar.auto.controller.dto.NewBrandRequest;
import com.branacar.auto.model.catalog.Brand;

import java.util.List;
import java.util.UUID;

public interface IBrandService {
    List<BrandDto> list();
    BrandDto create(NewBrandRequest req);
} 