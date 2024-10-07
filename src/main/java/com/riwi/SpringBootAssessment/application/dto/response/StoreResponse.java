package com.riwi.SpringBootAssessment.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class StoreResponse {
    String name;
    String address;
    String statusStore;
}
