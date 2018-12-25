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
        model = Model.PERSON;

    }

    @Override
    public void render(Batch batch, float parentAlpha) {
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(getCenterX(), getCenterY(), 5, 5);
        shapeRenderer.end();
    }

    int count = 0;
    @Override
    public void update(float delta) {
        count++;
        if(count % 100 == 0)
            AIResponder.addEntitiy(new Person((float) Math.random() * 1000, (float) Math.random() * 1000));
    }
}
