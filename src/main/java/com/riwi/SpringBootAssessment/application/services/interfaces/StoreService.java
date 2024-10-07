package com.riwi.SpringBootAssessment.application.services.interfaces;

import com.riwi.SpringBootAssessment.application.dto.request.StoreRequest;
import com.riwi.SpringBootAssessment.application.dto.response.StoreResponse;
import com.riwi.SpringBootAssessment.application.services.crud.Create;
import com.riwi.SpringBootAssessment.application.services.crud.Delete;
import com.riwi.SpringBootAssessment.application.services.crud.GetById;
import com.riwi.SpringBootAssessment.application.services.crud.Update;
import com.riwi.SpringBootAssessment.domain.model.entities.Store;

public interface StoreService extends
        Create<StoreRequest, StoreResponse>,
        Delete<Long>,
        GetById<Store, Long>,
        Update<Long, StoreRequest> {
}
