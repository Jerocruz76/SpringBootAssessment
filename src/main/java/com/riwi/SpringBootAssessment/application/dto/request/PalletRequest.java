package com.riwi.SpringBootAssessment.application.dto.request;

import com.riwi.SpringBootAssessment.domain.model.enums.Material;
import com.riwi.SpringBootAssessment.domain.model.enums.StatusPallet;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PalletRequest {
    @NotBlank(message = "weight capacity is not specified")
    private Float weightCapacity;

    @NotBlank(message = "material is required")
    private Material material;

    @NotBlank(message = "status is required")
    private StatusPallet status;

    @NotBlank(message = "load is required")
    private Long loadId;
}
