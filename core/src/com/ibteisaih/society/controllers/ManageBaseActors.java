package com.ibteisaih.society.controllers;

import com.ibteisaih.society.actors.BaseActor;
import com.ibteisaih.society.actors.models.Model;

import java.util.List;

public interface ManageBaseActors {

    void addEntitiy(BaseActor actor); //allows the adding of an actor
    void removeEntitiy(BaseActor actor); //allows the removing of an actor

    BaseActor getEntity(Model model, float x, float y); //get closest entity of a specific model to the point

    List<BaseActor> getAllModel(Model model);

}
