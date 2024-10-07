package com.riwi.SpringBootAssessment.application.services.impl;

import com.riwi.SpringBootAssessment.application.dto.request.PalletRequest;
import com.riwi.SpringBootAssessment.application.dto.response.PalletResponse;
import com.riwi.SpringBootAssessment.application.mappers.PalletMapper;
import com.riwi.SpringBootAssessment.application.services.interfaces.PalletService;
import com.riwi.SpringBootAssessment.domain.model.entities.PalletEntity;
import com.riwi.SpringBootAssessment.domain.repositories.PalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class PalletImpl implements PalletService {

    private final PalletRepository palletRepository;

    public PalletImpl(PalletRepository palletRepository) {
        this.palletRepository = palletRepository;
    }

    @Override
    @Transactional
    public PalletResponse create(PalletRequest palletRequest) {
        PalletEntity newPallet = PalletEntity.builder()
                .weightCapacity(palletRequest.getWeightCapacity())
                .material(palletRequest.getMaterial())
                .status(palletRequest.getStatus())
                .loadId(palletRequest.getLoadId())
                .build();
        palletRepository.save(newPallet);
        return PalletMapper.INSTANCE.toResponse(newPallet);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        PalletEntity existingPallet = palletRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,"Pallet with id " + id + " not found")
        );
        palletRepository.delete(existingPallet);
        return true;
    }

    @Override
    @Transactional
    public PalletEntity getById(Long id) {
        return palletRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,"Pallet with id " + id + " not found")
        );
    }

    @Override
    @Transactional
    public PalletRequest update(Long id, PalletRequest request) {
        Optional<PalletEntity> existingPallet = palletRepository.findById(id);
        if (existingPallet.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Pallet with id " + id + " not found");
        }else {
            PalletEntity palletToUpdate = existingPallet.get();
            palletToUpdate.setWeightCapacity(request.getWeightCapacity());
            palletToUpdate.setMaterial(request.getMaterial());
            palletToUpdate.setStatus(request.getStatus());
            palletToUpdate.setLoadId(request.getLoadId());
            palletRepository.save(palletToUpdate);
            return request;
        }
    }
}
