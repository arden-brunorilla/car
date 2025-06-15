package com.branacar.auto.service;

import com.branacar.auto.controller.dto.ModelDto;
import com.branacar.auto.controller.dto.NewModelRequest;
import com.branacar.auto.model.catalog.Brand;
import com.branacar.auto.model.catalog.Model;
import com.branacar.auto.repository.BrandRepository;
import com.branacar.auto.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepo;
    private final BrandRepository brandRepo;

    public ModelDto create(NewModelRequest req) {
        Brand brand = brandRepo.findById(req.brandId())
                .orElseThrow(() -> new IllegalArgumentException("Brand not found"));

        Model model = modelRepo.save(
                Model.builder()
                        .modelId(UUID.randomUUID())
                        .commercialName(req.commercialName())
                        .brand(brand)
                        .segment(req.segment())
                        .modelYear(req.modelYear())
                        .build());
        return ModelDto.from(model);
    }

    public List<ModelDto> list() {
        return modelRepo.findAll().stream().map(ModelDto::from).toList();
    }
}
