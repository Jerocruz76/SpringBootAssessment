package com.riwi.SpringBootAssessment.application.mappers;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoadMapper {
    LoadMapper INSTANCE = Mappers.getMapper(LoadMapper.class);

    @Mapping(source = "carrierId", target = "carriedId")
    LoadEntity toEntity(LoadRequest loadRequest);

    @Mapping(source = "carriedId", target = "carriedId")
    LoadResponse toResponse(LoadEntity loadEntity);

    default Long map(LoadEntity loadEntity){
        return loadEntity != null ? loadEntity.getId() : null;
    }
}
