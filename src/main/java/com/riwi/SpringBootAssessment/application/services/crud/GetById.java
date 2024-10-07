package com.riwi.SpringBootAssessment.application.services.crud;

public interface GetById<Entity, ID>{
    public Entity getById(ID id);
}
