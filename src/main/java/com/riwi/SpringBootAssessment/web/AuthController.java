package com.riwi.SpringBootAssessment.web;

import com.riwi.SpringBootAssessment.application.dto.request.LoginRequest;
import com.riwi.SpringBootAssessment.application.dto.request.RegisterRequest;
import com.riwi.SpringBootAssessment.application.dto.response.AuthResponse;
import com.riwi.SpringBootAssessment.application.dto.response.LoginResponseDataDto;
import com.riwi.SpringBootAssessment.application.dto.response.LoginResponseDto;
import com.riwi.SpringBootAssessment.application.dto.response.RegisterResponseDto;
import com.riwi.SpringBootAssessment.application.services.impl.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
        RegisterResponseDto responseDto = RegisterResponseDto.builder()
                .status(HttpStatus.CREATED.value())
                .message("Successfully registered")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequest request){
        String token = authService.login(request);
        LoginResponseDataDto loginResponseDataDto = new LoginResponseDataDto(token);
        LoginResponseDto responseDto = LoginResponseDto.builder().status(HttpStatus.OK.value())
                .message("Successfully logged in")
                .data(loginResponseDataDto)
                .build();
        return ResponseEntity.ok(responseDto);
    }
}
