package com.ibteisaih.society.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ibteisaih.society.GameActor;

import java.util.ArrayList;

public class World extends Stage {


    ArrayList<AIController> societies;
    ArrayList<GameActor> entities; //all entities in the world

    public World(){
        societies = new ArrayList<AIController>();
        societies.add(new AIController(AIController.defaultStart(), entities));
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void update(){

    }
}
