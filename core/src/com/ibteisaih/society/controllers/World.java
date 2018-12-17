package com.ibteisaih.society.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ibteisaih.society.actors.BaseActor;

import java.util.ArrayList;

public class World extends Stage {


    ArrayList<AIController> societies; //list of all AIs

    public static ArrayList<BaseActor> ENTITIES; //all entities in the world
    public static ArrayList<BaseActor> NEXTENTITIES; //all entities in the world



    public World(){
        societies = new ArrayList<AIController>();
        ENTITIES = new ArrayList<BaseActor>();
        NEXTENTITIES = new ArrayList<BaseActor>();
        
        societies.add(new AIController(null));
        
        
    }

    //Adds an entity to the list of all entities
    public static void addEntity(BaseActor actor){
        if(actor != null) {
            NEXTENTITIES.add(actor);
        }
    }

    //Removes an entity from the list of all entities
    public static void removeEntity(BaseActor actor){
        if(actor != null)
            NEXTENTITIES.remove(actor);
    }

    @Override
    public void draw() {
        super.draw();
        for(BaseActor actors : ENTITIES){
            actors.draw(getBatch(), 1.0f);
        }
        //update entity list
        

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for(AIController AI : societies){
            AI.update(delta);
        }
        for(BaseActor actors : ENTITIES){
            actors.update(delta);
        }

        if(ENTITIES.size() != (ENTITIES.size() + NEXTENTITIES.size())) {
            ENTITIES.addAll(NEXTENTITIES);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        for(BaseActor actors : ENTITIES){
            actors.dispose();
        }
    }
}
