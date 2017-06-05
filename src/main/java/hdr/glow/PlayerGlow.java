package hdr.glow;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import hdr.glow.config.FileMethods;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;

import java.io.*;

import static hdr.glow.config.GlowTeams.*;
import static hdr.glow.commands.CommandList.*;

@Plugin(id = "playerglow", name = "Player Glow", version = "1.0.0")
public class PlayerGlow {

    public static Scoreboard scoreboard = Scoreboard.builder().build();
    public static JsonObject ColorData;
    private void makeCommands() {Sponge.getCommandManager().register(this, colorCMD, "glow");}

    @Listener
    public void onInit(GameStartedServerEvent e) {
        createJson();
        readJson();
        makeCommands();
    }

    @Listener
    public void onServerStart(GameStartedServerEvent e) {registerTeams();}

    @Listener
    public void onJoin(ClientConnectionEvent.Join e) {
        Player player = e.getTargetEntity();
        player.setScoreboard(scoreboard);
        String PlayerID = player.getUniqueId().toString();
        if (ColorData.has(PlayerID)) {
            String PlayerColor = ColorData.get(PlayerID).toString();
            switch(PlayerColor) {
                case "\"Aqua\"":
                    Aqua.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Aqua");
                    break;
                case "\"Black\"":
                    Black.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Black");
                    break;
                case "\"Blue\"":
                    Blue.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Blue");
                    break;
                case "\"DarkAqua\"":
                    DarkAqua.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkAqua");
                    break;
                case "\"DarkBlue\"":
                    DarkBlue.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkBlue");
                    break;
                case "\"DarkGray\"":
                    DarkGray.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkGray");
                    break;
                case "\"DarkGreen\"":
                    DarkGreen.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkGreen");
                    break;
                case "\"DarkPurple\"":
                    DarkPurple.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkPurple");
                    break;
                case "\"DarkRed\"":
                    DarkRed.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkRed");
                    break;
                case "\"Gold\"":
                    Gold.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Gold");
                    break;
                case "\"Gray\"":
                    Gray.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Gray");
                    break;
                case "\"Green\"":
                    Green.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Green");
                    break;
                case "\"LightPurple\"":
                    LightPurple.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "LightPurple");
                    break;
                case "\"Red\"":
                    Red.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Red");
                    break;
                case "\"White\"":
                    White.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "White");
                    break;
                case "\"Yellow\"":
                    Yellow.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Yellow");
                    break;
                default: break;
            }
        }
    }

    @Listener
    public void onSave(SaveWorldEvent e) {
        String jstring = ColorData.toString();
        try {
            FileMethods.create("config/playerglow", "colorData.json", jstring);
        } catch (IOException e1) {
        }
    }

    private static void createJson() {
        String CreateString = "{}";
        File file = new File("config/playerglow/colorData.json");
        if (!file.exists()) {
            try {
                FileMethods.create("config/playerglow", "colorData.json", CreateString);
            } catch (IOException e1) {}
        }
    }

    private static void readJson() {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("config/playerglow/colorData.json"));
            ColorData = gson.fromJson(br, JsonObject.class);
        } catch (IOException e2) {}
    }
}