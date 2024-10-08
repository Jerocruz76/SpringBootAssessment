package com.riwi.SpringBootAssessment.application.services.interfaces;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.application.services.crud.Create;
import com.riwi.SpringBootAssessment.application.services.crud.Delete;
import com.riwi.SpringBootAssessment.application.services.crud.GetById;
import com.riwi.SpringBootAssessment.application.services.crud.Update;
import com.riwi.SpringBootAssessment.domain.model.entities.LoadEntity;

public interface LoadService extends
        Create<LoadRequest, LoadResponse>,
        GetById<LoadEntity, Long>,
        Update<Long, LoadRequest> {
}
