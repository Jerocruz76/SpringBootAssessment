package com.riwi.SpringBootAssessment.web;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.application.services.impl.LoadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loads")
public class LoadController {
    @Autowired
    private final LoadImpl loadImpl;

    public LoadController(LoadImpl load) {
        this.loadImpl = load;
    }

    @PostMapping("/create")
    public LoadResponse create(@RequestBody LoadRequest loadRequest){
        LoadResponse response = loadImpl.create(loadRequest);
        return response;
    }
}
