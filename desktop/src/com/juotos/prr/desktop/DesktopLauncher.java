package com.juotos.prr.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.juotos.prr.Constants;
import com.juotos.prr.PRRGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "portrait-runner-runner";
		config.width = Constants.GAME_WIDTH;
		config.height = Constants.GAME_HEIGHT;
		
		new LwjglApplication(new PRRGame(), config);
	}
}
