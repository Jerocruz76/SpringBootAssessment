package com.riwi.SpringBootAssessment.application.services.interfaces;

import com.riwi.SpringBootAssessment.application.dto.request.LoadRequest;
import com.riwi.SpringBootAssessment.application.dto.response.LoadResponse;
import com.riwi.SpringBootAssessment.application.services.crud.Create;
import com.riwi.SpringBootAssessment.application.services.crud.Delete;
import com.riwi.SpringBootAssessment.application.services.crud.GetById;
import com.riwi.SpringBootAssessment.application.services.crud.Update;

public interface LoadService extends
        Create<LoadRequest, LoadResponse>,
        Delete<Long>,
        GetById<Long, LoadResponse>,
        Update<Long, LoadRequest> {
}
