package com.juotos.prr.Helpers;

import com.badlogic.gdx.Gdx;

public class Debugger {
	public static void Log(String tag, String text) {
		if (tag == null || tag.isEmpty())
			tag = "loglog";
		Gdx.app.log(tag, text);
	}
}
