package com.ibteisaih.society.actors.models;

import com.ibteisaih.society.controllers.Params;

import java.util.Dictionary;

public enum Model {

    PERSON;

    public Model getModelFromProperty(Params query){
        switch (query){
            case POPULATION:
                return Model.PERSON;
            default:
                return Model.PERSON;
        }
    }


}
