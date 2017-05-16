package hdr.glow;

import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.Scoreboard;
import static hdr.glow.config.glowTeams.*;
import static hdr.glow.commands.CommandList.*;

@Plugin(id = "playerglow", name = "Player Glow", version = "0.9.8")
public class playerGlow {

    public static PotionEffect glowPot;

    //Build Scoreboard
    Scoreboard scoreboard = Scoreboard.builder().build();


    private void makeCommands() {
        Sponge.getCommandManager().register(this, colorCMD, "glow");
    }

    @Listener
    public void onInit(GameStartedServerEvent e){
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
    }

}