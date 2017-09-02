package com.hdr.glow.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hdr.glow.PlayerGlow;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	public static JsonObject ColorData;

	public static void create(String name, String text) throws IOException {
		File dir = PlayerGlow.getInstance().getConfigDir();
		dir.mkdirs();
		FileWriter file = new FileWriter(new File(dir, name));
		file.write(text);
		file.flush();
		file.close();
	}

	public static void createJson() {
		String CreateString = "{}";
		File file = new File(PlayerGlow.getInstance().getConfigDir(), "colorData.json");
		if (!file.exists()) {
			try {
				create("colorData.json", CreateString);
			} catch (IOException e1) {
				PlayerGlow.getInstance().getLogger().error("[PlayerGlow] Error writing config file!");
			}
		}
	}

	public static void readJson() {
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(new File(PlayerGlow.getInstance().getConfigDir(), "colorData.json")));
			ColorData = (JsonObject) obj;
		} catch (IOException e2) {
			PlayerGlow.getInstance().getLogger().error("[PlayerGlow] Error reading config file!");
		}
	}
}
