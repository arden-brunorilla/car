package com.branacar.auto.repository;

import com.branacar.auto.model.catalog.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> { }
