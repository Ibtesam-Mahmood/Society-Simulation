package com.ibteisaih.society;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Simulation extends ApplicationAdapter {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		update();

		Gdx.gl.glClearColor(43/255f, 168/255f, 74/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();



		batch.end();
	}

	//Allows the processing of the object to occur before the rendering
	public void update(){

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
