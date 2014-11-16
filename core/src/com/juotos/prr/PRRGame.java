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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.juotos.prr.Actors.Player;
import com.juotos.prr.Actors.Wall;
import com.juotos.prr.Helpers.Debugger;

public class PRRGame extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Wall wallLeft, wallRight;
	GameState state = GameState.RUN;
	
	OrthographicCamera camera;
	
	int current_position = 0;
	int move_speed = 4;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		player = new Player(this);
		wallLeft = new Wall(0, 0);
		wallRight = new Wall(Constants.GAME_WIDTH-70, 0);
		
		camera.setToOrtho(false, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
		camera.update();
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
		camera.translate(0, move_speed, 0);
		anyKeyPressed();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batchUpdate();
		batch.end();
		
		current_position += move_speed;
		player.update(move_speed);
		wallLeft.update(move_speed);
		wallRight.update(move_speed);
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
	
	private void anyKeyPressed() {
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			Debugger.Log("loglog", "space entered");
		}
	}
	private void batchUpdate() {
		player.render(batch);
		
		wallLeft.render(batch);
		wallRight.render(batch);
		
	}

}
