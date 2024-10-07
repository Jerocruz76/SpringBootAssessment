package com.riwi.SpringBootAssessment.application.services.impl;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.application.mappers.LoadMapper;
import com.riwi.SpringBootAssessment.application.services.interfaces.LoadService;
import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;
import com.riwi.SpringBootAssessment.domain.repositories.LoadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class LoadImpl implements LoadService {
    private final LoadRepository loadRepository;

    public LoadImpl(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Override
    public LoadResponse create(LoadRequest loadRequest) {
        LoadEntity newLoad = LoadEntity.builder()
                .description(loadRequest.getDescription())
                .weight(loadRequest.getWeight())
                .status(loadRequest.getStatus())
                .carrier_id(loadRequest.getCarrierId())
                .build();
        loadRepository.save(newLoad);
        return LoadMapper.INSTANCE.toResponse(newLoad);
    }

    @Override
    public boolean delete(Long id) {
        LoadEntity existingLoad = loadRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Load with id " + id + " not found")
        );
        loadRepository.delete(existingLoad);
        return true;
    }

    @Override
    public LoadEntity getById(Long id) {
        return loadRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Load with id " + id + " not found")
        );
    }

    @Override
    public LoadRequest update(Long id, LoadRequest request) {
        Optional<LoadEntity> existingLoad = loadRepository.findById(id);
        if (existingLoad.isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Load with id " + id + " not found");
        }else {
            LoadEntity loadToUpdate = existingLoad.get();
            loadToUpdate.setDescription(request.getDescription());
            loadToUpdate.setWeight(request.getWeight());
            loadToUpdate.setStatus(request.getStatus());
            loadToUpdate.setCarrier_id(request.getCarrierId());
            loadRepository.save(loadToUpdate);
            return request;
        }
    }
}
