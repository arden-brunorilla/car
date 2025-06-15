package com.branacar.auto.service;

import com.branacar.auto.controller.dto.BrandDto;
import com.branacar.auto.controller.dto.NewBrandRequest;
import com.branacar.auto.model.catalog.Brand;
import com.branacar.auto.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repo;

    public BrandDto create(NewBrandRequest req) {
        Brand brand = repo.save(
                Brand.builder()
                        .brandId(UUID.randomUUID())
                        .name(req.name())
                        .build());
        return BrandDto.from(brand);
    }

    public List<BrandDto> list() {
        return repo.findAll().stream().map(BrandDto::from).toList();
    }
}
