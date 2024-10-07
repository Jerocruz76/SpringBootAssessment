package com.riwi.SpringBootAssessment.application.services.impl;

import com.riwi.SpringBootAssessment.application.dto.request.StoreRequest;
import com.riwi.SpringBootAssessment.application.dto.response.StoreResponse;
import com.riwi.SpringBootAssessment.application.mappers.StoreMapper;
import com.riwi.SpringBootAssessment.application.services.interfaces.StoreService;
import com.riwi.SpringBootAssessment.domain.model.entities.Store;
import com.riwi.SpringBootAssessment.domain.repositories.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class StoreImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }


    @Override
    @Transactional
    public StoreResponse create(StoreRequest storeRequest) {
        Store newStore = Store.builder()
                    .name(storeRequest.getName())
                    .address(storeRequest.getAddress())
                    .statusStore(storeRequest.getStatusStore())
                    .build();
        storeRepository.save(newStore);
        return StoreMapper.INSTANCE.toResponse(newStore);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        Store existingStore = storeRepository.findById(id).orElseThrow(
                () -> new HttpServerErrorException(HttpStatus.NOT_FOUND,"Store with id " + id + "not found")
        );
        storeRepository.delete(existingStore);
        return true;
    }

    @Override
    @Transactional
    public Long getById(StoreResponse storeResponse) {
        return null;
    }

    @Override
    @Transactional
    public StoreRequest update(Long aLong, StoreRequest request) {
        return null;
    }
}
