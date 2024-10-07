package com.riwi.SpringBootAssessment.application.services.impl;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.application.services.interfaces.LoadService;

public class LoadImpl implements LoadService {
    @Override
    public LoadResponse create(LoadRequest loadRequest) {
        return null;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public Long getById(LoadResponse loadResponse) {
        return null;
    }

    @Override
    public LoadRequest update(Long aLong, LoadRequest request) {
        return null;
    }
}
