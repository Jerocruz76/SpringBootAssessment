package com.riwi.SpringBootAssessment.application.mappers;

import com.riwi.SpringBootAssessment.application.dto.request.StoreRequest;
import com.riwi.SpringBootAssessment.application.dto.response.StoreResponse;
import com.riwi.SpringBootAssessment.domain.model.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    Store toEntity(StoreRequest storeRequest);
    StoreResponse toResponse(Store store);

    default Long map(Store store){
        return store != null ? store.getId() : null;
    }
}
