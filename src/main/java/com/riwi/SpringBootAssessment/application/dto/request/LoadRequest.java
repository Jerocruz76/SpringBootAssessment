package com.riwi.SpringBootAssessment.application.dto.request;

import com.riwi.SpringBootAssessment.domain.model.enums.StatusLoad;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoadRequest {
    @NotBlank(message="description is required")
    private String description;

    @NotBlank(message="weight is required")
    private Float weight;

    @NotBlank(message="status is required")
    private StatusLoad status;

    @NotBlank(message="carrier is required")
    private Long carrierId;
}
