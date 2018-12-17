package com.ibteisaih.society.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.ibteisaih.society.actors.models.Model;

public abstract class BaseActor extends Actor {

    public enum ActorType{
        DYNAMIC, STATIC
    }

    //Base Game Actor + texture model
    protected Texture texture;

    //The type of the actor
    protected ActorType type;

    //The tyoe of the model
    protected Model model;

    public BaseActor(float x, float y){
        type = ActorType.STATIC;
        setCenterX(x);
        setCenterY(y);
    }

    public void dispose(){
        texture.dispose();
    }

    public float getCenterX(){
        return getX() + getWidth()/2;
    }

    public void setCenterX(float centerX){
        setX(centerX - getWidth()/2);
    }

    public void setCenterY(float centerY){
        setY(centerY - getHeight()/2);
    }

    public float getCenterY(){
        return getY() + getHeight()/2;
    }

    public Model getModel() {
        return model;
    }

    public ActorType getType() {
        return type;
    }

    public abstract void render(Batch batch, float parentAlpha);


    //renders the actor
    @Override
    public void draw(Batch batch, float parentAlpha) {
        render(batch, parentAlpha);
    }

    //updates the actor over time
    public abstract void update(float delta);


    public float getDeltaDistance(float x, float y, float x1, float y1){
        return (float) Math.sqrt( Math.pow(x-x1, 2) + Math.pow(y-y1, 2) );
    }

}
