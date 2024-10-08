package com.riwi.SpringBootAssessment.application.mappers;

import com.riwi.SpringBootAssessment.application.dto.request.PalletRequest;
import com.riwi.SpringBootAssessment.application.dto.response.PalletResponse;
import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;
import com.riwi.SpringBootAssessment.domain.model.entities.PalletEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PalletMapper {

    PalletMapper INSTANCE = Mappers.getMapper(PalletMapper.class);

    @Mapping(source = "loadId", target = "loadId")
    PalletEntity toEntity(PalletRequest palletRequest);

    @Mapping(source = "loadId", target = "loadId")
    PalletResponse toResponse(PalletEntity palletEntity);

    default Long map(LoadEntity loadEntity){
        return loadEntity != null ? loadEntity.getId() : null;
    }

}
