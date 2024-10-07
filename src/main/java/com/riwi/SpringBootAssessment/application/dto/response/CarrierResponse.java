package com.riwi.SpringBootAssessment.application.dto.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CarrierResponse {
    private Long id;
    private String fullName;
    private String email;
}
