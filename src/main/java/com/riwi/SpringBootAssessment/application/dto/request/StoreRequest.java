package com.riwi.SpringBootAssessment.application.dto.request;

import com.riwi.SpringBootAssessment.domain.model.enums.StatusStore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequest {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "status is required")
    private StatusStore statusStore;
}
