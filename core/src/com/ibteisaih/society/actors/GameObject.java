package com.ibteisaih.society.actors;

import com.badlogic.gdx.math.Vector2;
import com.ibteisaih.society.GameActor;

public abstract class GameObject extends GameActor {
    float speed = 0f;
    Vector2 direction = new Vector2(1,0);

}