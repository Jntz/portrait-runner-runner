package com.juotos.prr.Actors;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.juotos.prr.Constants;

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
	int x = 0, y = 0;
	WallTexture[] woodenTexture = new WallTexture[6];
	
	WallTexture[] currentTextureWall = new WallTexture[4];
	WallTexture[] nextTextureWall = new WallTexture[4];
	
	int textureWallIndex = 0, maxtextureWallIndex = 0;
	int[][] textureWallCurrentList = new int[10][4];	//list for compinations
	
	Random random = new Random();
	int maxRandomValue = 0;
	
	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
		woodenTexture[0] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "1.png"), 70, 140);
		woodenTexture[1] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "2.png"), 70, 220);
		woodenTexture[2] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "3.png"), 70,140);
		woodenTexture[3] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "4.png"),70,220);
		woodenTexture[4] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "5.png"),70,140);
		woodenTexture[5] = new WallTexture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "6.png"),70,220);
		
		maxtextureWallIndex = textureWallCurrentList.length - 1;
		maxRandomValue = woodenCompinations.length;
		
		for(int i = 0; i < 10; i++) {
			textureWallCurrentList[i] = woodenCompinations[random.nextInt(maxRandomValue)];
			for(int k = 0; k < textureWallCurrentList[i].length; k++) {
				Gdx.app.log("loglog"+i, Integer.toString(textureWallCurrentList[i][k]));
			}
			
		}
			
		
		for (int i = 0; i < currentTextureWall.length; i++) {
			currentTextureWall[i] = woodenTexture[ textureWallCurrentList[textureWallIndex][i] ];
		}
		textureWallIndex++;
		
	}
	//
	public void render(SpriteBatch batch) {
		int currentY = 0;
		for(int i = 0; i < 4; i++) {
			batch.draw(currentTextureWall[i].texture, 
					x, currentY, 
					currentTextureWall[i].width, 
					currentTextureWall[i].height);
			currentY += currentTextureWall[i].height;
			Gdx.app.log("loglog" + i, Integer.toString(currentY));
		}
		//Gdx.app.log("loglog", Integer.toString(currentY));
	}
	
}
