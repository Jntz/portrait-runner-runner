package com.juotos.prr.Actors;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.juotos.prr.Constants;

public class Wall {
	private static final String WALL_ASSETS_DIR = "wood/";
	private static int[][] woodenCompinations = {
		{ 1, 1, 1, 0 },{ 1, 1, 0, 1 },{ 1, 0, 1, 1 },
		{ 0, 1, 1, 1 },{ 1, 1, 1, 1 },{ 1, 1, 1, 2 },
		{ 1, 1, 2, 1 },{ 1, 2, 1, 1 },{ 2, 1, 1, 1 },
		{ 1, 1, 1, 4 },{ 1, 1, 4, 1 },{ 1, 4, 1, 1 },
		{ 4, 1, 1, 1 },
		
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
	Texture[] woodenTexture = new Texture[6];
	
	Texture[] currentTextureWall = new Texture[4];
	Texture[] nextTextureWall = new Texture[4];
	
	int textureWallIndex = 0, maxtextureWallIndex = 0;
	int[][] textureWallCurrentList = new int[10][4];
	
	Random random = new Random();
	int maxRandomValue = 0;
	
	public Wall() {
		woodenTexture[0] = new Texture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "1.png"));
		woodenTexture[1] = new Texture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "2.png"));
		woodenTexture[2] = new Texture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "3.png"));
		woodenTexture[3] = new Texture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "4.png"));
		woodenTexture[4] = new Texture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "5.png"));
		woodenTexture[5] = new Texture(Gdx.files.external(Constants.ASSETS_DIR + WALL_ASSETS_DIR + "6.png"));
		
		
		maxtextureWallIndex = textureWallCurrentList.length - 1;
		maxRandomValue = woodenCompinations.length;
		
		for(int i = 0; i < 10; i++)
			textureWallCurrentList[i] = woodenCompinations[random.nextInt(maxRandomValue)];
		
		
		
	}
	
	public void generateWoodenTextureCompinations() {
		
	}
	
}
