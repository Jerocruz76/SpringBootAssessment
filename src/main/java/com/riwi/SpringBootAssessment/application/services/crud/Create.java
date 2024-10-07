package com.riwi.SpringBootAssessment.application.services.crud;

public interface Create<EntityRequest, Entity>{
    public Entity create(EntityRequest request);
}
