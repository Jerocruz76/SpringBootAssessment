package com.riwi.SpringBootAssessment.web;

import com.riwi.SpringBootAssessment.application.dto.request.PalletRequest;
import com.riwi.SpringBootAssessment.application.dto.response.PalletResponse;
import com.riwi.SpringBootAssessment.application.services.impl.PalletImpl;
import com.riwi.SpringBootAssessment.domain.model.entities.PalletEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pallets")
public class PalletController {
    @Autowired
    private final PalletImpl pallet;

    public PalletController(PalletImpl pallet) {
        this.pallet = pallet;
    }

    @PostMapping("/create")
    public PalletResponse create(@RequestBody PalletRequest request){
        PalletResponse response = pallet.create(request);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PalletEntity> getById(@PathVariable Long id){
        PalletEntity response = pallet.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PalletRequest> update(@PathVariable Long id, @RequestBody PalletRequest request){
        PalletRequest palletRequest = pallet.update(id, request);
        return ResponseEntity.ok(palletRequest);
    }
}
