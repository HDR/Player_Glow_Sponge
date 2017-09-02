package com.hdr.glow.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hdr.glow.PlayerGlow;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private JsonObject colorData;
	private String fileName;

	public FileManager(String fileName) {
		this.fileName = fileName;
	}

	public void create(String text) throws IOException {
		File dir = PlayerGlow.getInstance().getConfigDir();
		dir.mkdirs();
		FileWriter file = new FileWriter(new File(dir, fileName));
		file.write(text);
		file.flush();
		file.close();
	}

	public void createJson() {
		String createString = "{}";
		File file = new File(PlayerGlow.getInstance().getConfigDir(), fileName);

		if (!file.exists()) {
			try {
				create(createString);
			} catch (IOException e1) {
				PlayerGlow.getInstance().getLogger().error("Error writing config file!");
			}
		}
	}

	public void readJson() {
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(new File(PlayerGlow.getInstance().getConfigDir(), fileName)));
			colorData = (JsonObject) obj;
		} catch (IOException e2) {
			PlayerGlow.getInstance().getLogger().error("Error reading config file!");
		}
	}

	public JsonObject getColorData() {
		return colorData;
	}
}
