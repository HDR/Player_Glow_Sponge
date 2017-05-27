package hdr.glow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.Text;
import static hdr.glow.config.glowTeams.*;
import static hdr.glow.commands.CommandList.*;
import java.util.*;

@Plugin(id = "playerglow", name = "Player Glow", version = "0.9.9")
public class playerGlow {

    public static PotionEffect glowPot;
    //Build Scoreboard
    public static Scoreboard scoreboard = Scoreboard.builder().build();

    //Build Commands
    private void makeCommands() {
        Sponge.getCommandManager().register(this, colorCMD, "glow");
    }

    //List for saving colors over restart
    public static Map<UUID, Team> playerList = new HashMap<>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Listener
    public void onInit(GameStartedServerEvent e) {
        makeCommands();
        glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(100000).amplifier(100).particles(false).ambience(true).build();
    }

    @Listener
    public void onServerStart(GameStartedServerEvent e) {
        //Wait for server to start then Register teams.
        scoreboard.registerTeam(Black);
        scoreboard.registerTeam(DarkBlue);
        scoreboard.registerTeam(DarkGreen);
        scoreboard.registerTeam(DarkAqua);
        scoreboard.registerTeam(DarkRed);
        scoreboard.registerTeam(DarkPurple);
        scoreboard.registerTeam(Gold);
        scoreboard.registerTeam(Gray);
        scoreboard.registerTeam(DarkGray);
        scoreboard.registerTeam(Blue);
        scoreboard.registerTeam(Green);
        scoreboard.registerTeam(Aqua);
        scoreboard.registerTeam(Red);
        scoreboard.registerTeam(LightPurple);
        scoreboard.registerTeam(Yellow);
        scoreboard.registerTeam(White);
    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join e) {
        Player player = e.getTargetEntity();
        player.setScoreboard(scoreboard);
        if (playerList.containsKey(Text.of(player.getName()))) {
            Black.addMember(Text.of(player.getName()));
        }
    }
}