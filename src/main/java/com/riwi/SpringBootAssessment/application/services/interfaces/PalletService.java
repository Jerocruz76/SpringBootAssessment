package com.riwi.SpringBootAssessment.application.services.interfaces;

import com.riwi.SpringBootAssessment.application.dto.request.PalletRequest;
import com.riwi.SpringBootAssessment.application.dto.response.PalletResponse;
import com.riwi.SpringBootAssessment.application.services.crud.Create;
import com.riwi.SpringBootAssessment.application.services.crud.Delete;
import com.riwi.SpringBootAssessment.application.services.crud.GetById;
import com.riwi.SpringBootAssessment.application.services.crud.Update;
import com.riwi.SpringBootAssessment.domain.model.entities.PalletEntity;

public interface PalletService extends
        Create<PalletRequest, PalletResponse>,
        GetById<Long, PalletResponse>,
        Update<Long, PalletRequest>,
        Delete<Long> {
}
