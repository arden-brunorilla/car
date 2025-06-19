package com.branacar.auto.config;

import com.branacar.auto.model.Car;
import com.branacar.auto.model.CarStatus;
import com.branacar.auto.model.catalog.Brand;
import com.branacar.auto.model.catalog.Model;
import com.branacar.auto.repository.BrandRepository;
import com.branacar.auto.repository.CarRepository;
import com.branacar.auto.repository.ModelRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class CatalogSeeder {

    private final BrandRepository brandRepo;
    private final ModelRepository modelRepo;
    private final CarRepository carRepo;
    private final ObjectMapper mapper;

    @Bean
    CommandLineRunner seedCatalog() {
        return args -> {
            if (brandRepo.count() > 0) return;

            // Use central stock for initial car placement
            UUID stockCentral = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-ffffffffffff");

            try (InputStream in = getClass().getResourceAsStream("/seed/seed-data.json")) {
                JsonNode root = mapper.readTree(in);

                for (JsonNode b : root.path("brands")) {
                    Brand brand = brandRepo.save(
                            Brand.builder()
                                    .brandId(UUID.fromString(b.get("brandId").asText()))
                                    .name(b.get("name").asText())
                                    .build());

                    for (JsonNode m : b.path("models")) {
                        Model model = modelRepo.save(
                                Model.builder()
                                        .modelId(UUID.fromString(m.get("modelId").asText()))
                                        .commercialName(m.get("commercialName").asText())
                                        .segment(m.get("segment").asText(null))
                                        .modelYear(m.get("modelYear").asInt())
                                        .brand(brand)
                                        .build());

                        for (JsonNode c : m.path("cars")) {
                            carRepo.save(
                                    Car.builder()
                                            .carId(UUID.fromString(c.get("carId").asText()))
                                            .vin(c.get("vin").asText())
                                            .status(CarStatus.valueOf(c.get("status").asText()))
                                            .listPrice(new BigDecimal(c.get("listPrice").asText()))
                                            .stockId(stockCentral)
                                            .model(model)
                                            .build());
                        }
                    }
                }
                System.out.println("✅ Catalog seed loaded - Cars placed in central stock");
            }
        };
    }
}
