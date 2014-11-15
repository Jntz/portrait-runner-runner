package com.juotos.prr;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class PRRGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture woodenTexture1, woodenTexture2, woodenTexture3, woodenTexture4, woodenTexture5, woodenTexture6;
	Texture playerTexture1, playerTexture2, playerTexture3;
	
	int playerSize[] = {70, 70}; //width, height
	int woodenSize[][] = {
			{70, 70, 70, 70, 70, 70}, 
			{140, 220, 140, 220, 140, 220}
	}; 
	
	OrthographicCamera camera;
	Rectangle rect;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		initializeAssets();
		
		camera.setToOrtho(false, 480, 800);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);	//red,green,blue,alpha
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //Clear screen
		camera.update();
		anyKeyPressed();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batchUpdate();
		batch.end();
	}
	
	private void initializeAssets() {
		woodenTexture1 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/wood/1.png"));
		woodenTexture2 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/wood/2.png"));
		woodenTexture3 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/wood/3.png"));
		woodenTexture4 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/wood/4.png"));
		woodenTexture5 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/wood/5.png"));
		woodenTexture6 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/wood/6.png"));
		
		playerTexture1 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/player/1.png"));
		playerTexture2 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/player/2.png"));
		playerTexture3 = new Texture(Gdx.files.external("Development/game-dev/portrait-runner-runner/assets/player/3.png"));
	}
	
	private void anyKeyPressed() {
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			Gdx.app.log("loglog", "space entered");
		}
	}
	private void batchUpdate() {
		
		
		
	}
}
