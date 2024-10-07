package com.riwi.SpringBootAssessment.application.services.impl;

import com.riwi.SpringBootAssessment.application.dto.request.PalletRequest;
import com.riwi.SpringBootAssessment.application.dto.response.PalletResponse;
import com.riwi.SpringBootAssessment.application.services.interfaces.PalletService;

public class PalletImpl implements PalletService {

    @Override
    public PalletResponse create(PalletRequest palletRequest) {
        return null;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public Long getById(PalletResponse palletResponse) {
        return null;
    }

    @Override
    public PalletRequest update(Long aLong, PalletRequest request) {
        return null;
    }
}
