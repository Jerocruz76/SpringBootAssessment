package com.riwi.SpringBootAssessment.web;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.application.services.impl.LoadImpl;
import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        boolean deleted = loadImpl.delete(id);
        if(deleted) return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadEntity> getById(@PathVariable Long id){
        LoadEntity response = loadImpl.getById(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<LoadRequest> update(@PathVariable Long id, @RequestBody LoadRequest request){
        LoadRequest loadRequest = loadImpl.update(id, request);
        return ResponseEntity.ok(loadRequest);
    }
}
