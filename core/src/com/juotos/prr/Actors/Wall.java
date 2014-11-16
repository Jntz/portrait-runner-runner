package com.juotos.prr.Actors;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.juotos.prr.Constants;
import com.juotos.prr.Helpers.Debugger;

public class Wall {
	private static final String WALL_ASSETS_DIR = "wood/";
	private static int[][] woodenCompinations = {
		{ 1, 1, 1, 0 },{ 1, 1, 0, 1 },{ 1, 0, 1, 1 },
		{ 0, 1, 1, 1 },{ 1, 1, 1, 2 },{ 1, 1, 2, 1 },
		{ 1, 2, 1, 1 },{ 2, 1, 1, 1 },{ 1, 1, 1, 4 },
		{ 1, 1, 4, 1 },{ 1, 4, 1, 1 },{ 4, 1, 1, 1 },
		
		{ 3, 3, 3, 0 },{ 3, 3, 0, 3 },{ 3, 0, 3, 3 },
		{ 0, 3, 3, 3 },{ 3, 3, 3, 2 },{ 3, 3, 2, 3 },
		{ 3, 2, 3, 3 },{ 2, 3, 3, 3 },{ 3, 3, 3, 4 },
		{ 3, 3, 4, 3 },{ 3, 4, 3, 3 },{ 4, 3, 3, 3 },
	
		{ 5, 5, 5, 0 },{ 5, 5, 0, 5 },{ 5, 0, 5, 5 },
		{ 0, 5, 5, 5 },{ 5, 5, 5, 2 },{ 5, 5, 2, 5 },
		{ 5, 2, 5, 5 },{ 2, 5, 5, 5 },{ 5, 5, 5, 4 },
		{ 5, 5, 4, 5 },{ 5, 4, 5, 5 },{ 4, 5, 5, 5 }
	}; 
	
	
	int woodenSize[][] = {
			{70, 70, 70, 70, 70, 70}, 
			{140, 220, 140, 220, 140, 220}
	};
	int x = 0, y = 0,
		x2 = 0, y2 = 0;	//x,y position to wall 1 ad position to wall 2
	
	WallTexture[] woodenTexture = new WallTexture[6];	//TextureTypes
	WallTexture[] currentTextureWall = new WallTexture[4]; //wall number N
	WallTexture[] nextTextureWall = new WallTexture[4];	//wall number N + 1
	
	int textureWallIndex = 0, maxtextureWallIndex = 0;
	
	//list for compinations
	int[][] textureWallCurrentList = null;	
	
	Random random = new Random();
	int maxRandomValue = 0;
	int yPosition = 0; //when 800 or > => update x,x2,y,y2 position, textures etc.
	
	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.x2 = this.x;
		this.y2 = this.y + Constants.GAME_HEIGHT;	//next wall "screen" y position
		
		//Initialize textures
		woodenTexture[0] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "1.png"), 70, 140);
		woodenTexture[1] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "2.png"), 70, 220);
		woodenTexture[2] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "3.png"), 70, 140);
		woodenTexture[3] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "4.png"), 70, 220);
		woodenTexture[4] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "5.png"), 70, 140);
		woodenTexture[5] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "6.png"), 70, 220);
		
		maxRandomValue = woodenCompinations.length;
		
		generateWallList();
		maxtextureWallIndex = textureWallCurrentList.length;
		
		for(int i = 0; i < textureWallCurrentList.length; i++) {
			textureWallCurrentList[i] = woodenCompinations[random.nextInt(maxRandomValue)];
			
			//Only debug purposes
			for(int k = 0; k < textureWallCurrentList[i].length; k++) {
				Debugger.Log("loglog"+i, Integer.toString(textureWallCurrentList[i][k]));
			}
		}
			
		//Initialize current TextureWall
		currentTextureWall = initializeTextureWall(currentTextureWall.length);
		
		//Initialize next TextureWall
		nextTextureWall = initializeTextureWall(nextTextureWall.length);
	}
	
	private void generateWallList() {
		textureWallCurrentList = null;
		textureWallCurrentList = new int[10][4];
		
		for(int i = 0; i < textureWallCurrentList.length; i++) {
			textureWallCurrentList[i] = woodenCompinations[random.nextInt(maxRandomValue)];
			
			//Only debug purposes
			for(int k = 0; k < textureWallCurrentList[i].length; k++) {
				//Debugger.Log("loglog"+i, Integer.toString(textureWallCurrentList[i][k]));
			}
		}
	}
	
	private WallTexture[] initializeTextureWall(int length) {
		//Initialize next TextureWall
		WallTexture[] textureWall = new WallTexture[length];
		for (int i = 0; i < textureWall.length; i++) {
			textureWall[i] = woodenTexture[ textureWallCurrentList[textureWallIndex][i] ];
		}
		textureWallIndex++;
		if(textureWallIndex >= maxtextureWallIndex) {
			textureWallIndex = 0;
			
			generateWallList();
		}
		
		return textureWall;
	}
	
	//
	public void render(SpriteBatch batch) {
		int currentY = 0;
		for(int i = 0; i < 4; i++) {
			batch.draw(currentTextureWall[i].texture, 
					x, y + currentY, 
					currentTextureWall[i].width, 
					currentTextureWall[i].height);
			batch.draw(nextTextureWall[i].texture, 
					x, y2 + currentY, 
					nextTextureWall[i].width, 
					nextTextureWall[i].height);
			
			Debugger.Log("loglog1", Integer.toString(currentY));
			
			currentY += currentTextureWall[i].height;
			
			Debugger.Log("loglog2", Integer.toString(currentY));
		}
		//Debugger.Log("loglog", Integer.toString(currentY));
	}
	public void update(int moving_speed) {
		yPosition += moving_speed;
		
		//Update wall textures 
		if(yPosition >= 800) {
			yPosition = 0;
			currentTextureWall = null;
			currentTextureWall = nextTextureWall;
			x = x2;
			y = y2;
			
			x2 = x;
			y2 = y + Constants.GAME_HEIGHT;	//next wall "screen" y position
			
			nextTextureWall = new WallTexture[4];
			
			//Initialize next TextureWall
			nextTextureWall = initializeTextureWall(nextTextureWall.length);
		}
	}
	
}
