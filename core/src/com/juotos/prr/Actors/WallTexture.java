package com.juotos.prr.Actors;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class WallTexture {
	public Texture texture;
	public int width = 0, height = 0;
	
	public WallTexture(FileHandle file, int width, int height) {
		texture = new Texture(file);
		this.width = width;
		this.height = height;
	}
}
