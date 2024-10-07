package com.riwi.SpringBootAssessment.application.dto.response;

import com.riwi.SpringBootAssessment.domain.model.enums.StatusLoad;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class LoadResponse {
    private String id;
    private String description;
    private Float weight;
    private StatusLoad status;
    private Long carrierId;
}
