package com.riwi.SpringBootAssessment.application.dto.response;

import com.riwi.SpringBootAssessment.domain.model.enums.Material;
import com.riwi.SpringBootAssessment.domain.model.enums.StatusPallet;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PalletResponse {
    private Long id;
    private Float weightCapacity;
    private Material material;
    private StatusPallet status;
    private Long loadId;
}
