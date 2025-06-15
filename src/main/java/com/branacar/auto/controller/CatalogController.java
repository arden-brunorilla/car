package com.branacar.auto.controller;

import com.branacar.auto.controller.dto.*;
import com.branacar.auto.service.BrandService;
import com.branacar.auto.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final BrandService brandService;
    private final ModelService modelService;

    // Brand
    @PostMapping("/brands")
    public ResponseEntity<BrandDto> createBrand(@Valid @RequestBody NewBrandRequest body) {
        return ResponseEntity.ok( brandService.create(body) );
    }

    @GetMapping("/brands")
    public List<BrandDto> listBrands() {
        return brandService.list();
    }

    // Model
    @PostMapping("/models")
    public ResponseEntity<ModelDto> createModel(@Valid @RequestBody NewModelRequest body) {
        return ResponseEntity.ok( modelService.create(body) );
    }

    @GetMapping("/models")
    public List<ModelDto> listModels() {
        return modelService.list();
    }
}
