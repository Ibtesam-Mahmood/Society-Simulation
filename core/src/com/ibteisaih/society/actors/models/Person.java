package com.ibteisaih.society.actors.models;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ibteisaih.society.actors.DynamicActor;

public class Person extends DynamicActor {

    private ShapeRenderer shapeRenderer;

    public Person(float x, float y){
        super(x, y);
        shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void render(Batch batch, float parentAlpha) {
        batch.end();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(getCenterX(), getCenterY(), 50, 50);
        shapeRenderer.end();
        batch.begin();
    }

    @Override
    public void update(float delta) {

    }
}
