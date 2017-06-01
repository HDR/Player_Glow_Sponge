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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static hdr.glow.config.glowTeams.*;
import static hdr.glow.commands.CommandList.*;

@Plugin(id = "playerglow", name = "Player Glow", version = "1.0.0-Dev")
public class playerGlow {

    public static Scoreboard scoreboard = Scoreboard.builder().build();
    public static JsonObject ColorData;
    private void makeCommands() {Sponge.getCommandManager().register(this, colorCMD, "glow");}

    @Listener
    public void onInit(GameStartedServerEvent e) {
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
            if (PlayerColor.equals("\"Aqua\"")){
                Aqua.addMember(Text.of(player.getName()));
                ColorData.addProperty(PlayerID, "Aqua");
            }
            if (PlayerColor.equals("\"Black\"")){
                Black.addMember(Text.of(player.getName()));
                ColorData.addProperty(PlayerID, "Black");
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

    private static void readJson() {
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("config/playerglow/colorData.json"));
            ColorData = gson.fromJson(br, JsonObject.class);
        } catch (IOException e2) {}
    }
}