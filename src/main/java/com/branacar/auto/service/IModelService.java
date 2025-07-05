package com.branacar.auto.service;

import com.branacar.auto.controller.dto.ModelDto;
import com.branacar.auto.controller.dto.NewModelRequest;

import java.util.List;
import java.util.UUID;

public interface IModelService {
    List<ModelDto> list();
    ModelDto create(NewModelRequest req);
} 