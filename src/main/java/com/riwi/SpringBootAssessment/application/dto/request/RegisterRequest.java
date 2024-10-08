package com.riwi.SpringBootAssessment.application.dto.request;

import com.riwi.SpringBootAssessment.domain.model.enums.Role;
import com.riwi.SpringBootAssessment.infrastructure.validators.ValidEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Schema(example = "CARRIER", description = "role of the carrier", implementation = Role.class)
    @NotBlank(message = "role is required")
    @ValidEnum(enumClass = Role.class, message = "role must be ADMIN or CARRIER")
    private String role;
}
