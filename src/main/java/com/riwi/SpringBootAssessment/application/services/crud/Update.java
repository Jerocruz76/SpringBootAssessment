package com.riwi.SpringBootAssessment.application.services.crud;

public interface Update<ID, Entity>{
    public Entity update(ID id, Entity request);
}
