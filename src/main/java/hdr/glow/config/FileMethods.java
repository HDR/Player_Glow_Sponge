package hdr.glow.config;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMethods {
    public static void create(String path, String name, String text) throws IOException {
        File dir = new File(path);
        dir.mkdirs();
        FileWriter file = new FileWriter(new File(dir, name));
        file.write(text);
        file.flush();
        file.close();
    }
}