package com.juotos.prr.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.juotos.prr.PRRGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "portrait-runner-runner";
		config.width = 480;
		config.height = 800;
		
		new LwjglApplication(new PRRGame(), config);
	}
}
