package com.riwi.SpringBootAssessment.application.mappers;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;
import com.riwi.SpringBootAssessment.domain.model.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoadMapper {
    LoadMapper INSTANCE = Mappers.getMapper(LoadMapper.class);

    @Mapping(source = "carrierId", target = "carrierId")
    LoadEntity toEntity(LoadRequest loadRequest);

    @Mapping(source = "carrierId", target = "carrierId")
    LoadResponse toResponse(LoadEntity loadEntity);

    default Long map(UserEntity userEntity){
        return userEntity != null ? userEntity.getId() : null;
    }
}
