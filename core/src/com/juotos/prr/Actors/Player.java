package com.juotos.prr.Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.juotos.prr.Constants;
import com.juotos.prr.PRRGame;

public class Player {
	private static final String PLAYER_ASSETS_DIR = "player/";
	private static final int MAX_HIT_METER = 100;
	private static final int MIN_HIT_METER = 0;
	private static final float HIT_METER_CAP = MAX_HIT_METER / 3;
	
	private PRRGame game;
	
	public boolean leftSide = true;
	public boolean jumping = false;
	public int hitMeter = MAX_HIT_METER;
	public Texture playerTexture1, playerTexture2, playerTexture3;
	public Texture prevTexture;
	public Sprite sprite;
	public int width = 70, height = 70;
	public float x = 0f, y = 0f;
	public float rotation = 0;
	
	public Player(PRRGame g) {
		game = g;
		playerTexture1 = new Texture(Gdx.files.external(Constants.ASSETS_DIR + PLAYER_ASSETS_DIR + "2.png"));
		playerTexture2 = new Texture(Gdx.files.external(Constants.ASSETS_DIR + PLAYER_ASSETS_DIR + "1.png"));
		//playerTexture2 = new Texture(Gdx.files.external(Constants.ASSETS_DIR + PLAYER_ASSETS_DIR + "2.png"));
		playerTexture3 = new Texture(Gdx.files.external(Constants.ASSETS_DIR + PLAYER_ASSETS_DIR + "3.png"));
		
		x = 70;
		y = 0; //bottom to screen
		
		prevTexture = playerTexture1;
		sprite = new Sprite(prevTexture);
		
		sprite.setX(x);
		sprite.setY(y);
	}
	public void update(int speed_move) {
		y += speed_move;
		sprite.setY(y);
	}
	public void render(SpriteBatch batch) {
		sprite.rotate(rotation);
		rotation += 0.025f;
		
		if(360f <= rotation) rotation = 0;
		sprite.draw(batch);
		
	}
	public void increaseHealth(int value) {
		hitMeter += value;
		if(hitMeter > MAX_HIT_METER) hitMeter = MAX_HIT_METER;
	}
	public void decreaseHealth(int value) {
		hitMeter -= value;
		if(hitMeter <= MIN_HIT_METER) {
			hitMeter = 0;
			game.toggleGameState();
		}
	}
	
	public Texture currentPlayerTexture() {
		if(hitMeter <= HIT_METER_CAP) 
			return playerTexture3;
		else if(hitMeter > HIT_METER_CAP && hitMeter <= (2* HIT_METER_CAP))
			return playerTexture2;
		else 
			return playerTexture1;
	}
}