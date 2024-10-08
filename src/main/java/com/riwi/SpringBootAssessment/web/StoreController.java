package com.riwi.SpringBootAssessment.web;

import com.riwi.SpringBootAssessment.application.dto.request.StoreRequest;
import com.riwi.SpringBootAssessment.application.dto.response.StoreResponse;
import com.riwi.SpringBootAssessment.application.services.impl.StoreImpl;
import com.riwi.SpringBootAssessment.domain.model.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private final StoreImpl store;

    public StoreController(StoreImpl store) {
        this.store = store;
    }

    @PostMapping("/create")
    public StoreResponse create(@RequestParam StoreRequest request){
        return store.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getById(@PathVariable Long id){
        Store response = store.getById(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<StoreRequest> update(@PathVariable Long id, @RequestBody StoreRequest request){
        StoreRequest updatedRequest = store.update(id, request);
        return ResponseEntity.ok(updatedRequest);
    }
}
