package com.ibteisaih.society.actors;

import com.badlogic.gdx.math.Vector2;

public abstract class DynamicActor extends BaseActor {

    float speed = 0f; //The speed the actor moves
    Vector2 direction = new Vector2(1,0); //the direction of the actors movement

    public DynamicActor(float x, float y){
        super(x, y);
        type = ActorType.DYNAMIC;
    }

    public void interact(BaseActor actor){

    }
}