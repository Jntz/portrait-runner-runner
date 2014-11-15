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
import com.juotos.prr.Actors.Player;
import com.juotos.prr.Actors.Wall;

public class PRRGame extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Wall wall1, wall2;
	GameState state = GameState.RUN;
	
	OrthographicCamera camera;
	Rectangle rect;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		player = new Player(this);
		wall1 = new Wall();
		wall2 = new Wall();
		initializeAssets();
		
		camera.setToOrtho(false, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
	}

	@Override
	public void render () {
		switch(state) {
			case RUN:
				renderRun();
				break;
			case PAUSE:
				renderPause();
				break;
			case RESUME:
				renderResume();
				break;
			case STOPPED:
				renderStopped();
				break;
		}
	}
	
	private void renderRun() {
		Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);	//red,green,blue,alpha
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //Clear screen
		camera.update();
		anyKeyPressed();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batchUpdate();
		batch.end();
		
		player.update();
		
	}
	private void renderPause() {
		
	}
	private void renderResume() {
		
	}
	private void renderStopped() {
	
	}
	public void toggleGameState() {
		//Toggle pause or run state
		state = (state == GameState.RUN) ? GameState.PAUSE : GameState.RUN;
	}
	private void initializeAssets() {
	}
	
	private void anyKeyPressed() {
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			Gdx.app.log("loglog", "space entered");
		}
	}
	private void batchUpdate() {
		batch.draw(player.currentPlayerTexture(), player.x, player.y);
		
	}

}
