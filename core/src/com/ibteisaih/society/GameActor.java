package com.ibteisaih.society;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;

public abstract class GameActor extends Actor {

    //Base Game Actor + texture model
    protected Texture texture;

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

}
