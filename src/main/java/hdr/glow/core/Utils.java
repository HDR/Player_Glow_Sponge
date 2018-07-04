package hdr.glow.core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static hdr.glow.PlayerGlow.ColorData;

public class Utils {

    public static void create(String path, String name, String text) throws IOException {
        File dir = new File(path);
        dir.mkdirs();
        FileWriter file = new FileWriter(new File(dir, name));
        file.write(text);
        file.flush();
        file.close();
    }

    public static void createJson() {
        String CreateString = "{}";
        File file = new File("config/playerglow/colorData.json");
        if (!file.exists()) {
            try {
                Utils.create("config/playerglow", "colorData.json", CreateString);
            } catch (IOException ignore) {}
        }
        if (file.length() == 0) {
            try {
                Utils.create("config/playerglow", "colorData.json", CreateString);
            } catch (IOException ignore) {}
        }
    }

    public static void readJson() {
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader("config/playerglow/colorData.json"));
            ColorData = (JsonObject) obj;
        } catch (IOException ignore) {}
    }
}