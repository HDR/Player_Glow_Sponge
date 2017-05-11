package hdr.glow;

import hdr.glow.commands.glowToggle;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.format.TextColors;

import java.util.ArrayList;
import java.util.List;

import static sun.misc.Version.print;

@Plugin(id = "playerglow", name = "Player Glow", version = "0.7")
public class playerGlow {

    private void makeCommands() {
        CommandSpec toggleCMD = CommandSpec.builder()
                .description(Text.of("Toggle Glow"))
                .permission("glow.toggle")
                .executor(new glowToggle())
                .build();
        Sponge.getCommandManager().register(this, toggleCMD, "toggleglow", "tgw");
    }

    private void makeTeams() {
        Team blackTeam = Team.builder()
                .name("blackGlow")
                .color(TextColors.BLACK)
                .build();
        Team dBlueTeam = Team.builder()
                .name("darkblueGlow")
                .color(TextColors.DARK_BLUE)
                .build();
        List<Team> teamList = new ArrayList<>();
        teamList.add(blackTeam);
        teamList.add(dBlueTeam);
        Scoreboard.builder().teams(teamList).build();
    }


    public static PotionEffect glowPot;

    @Listener
    public void onInit(GameStartedServerEvent e){
        makeCommands();
        glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(100000).amplifier(100).particles(false).ambience(true).build();
    }

    @Listener
    public void onInit(GameLoadCompleteEvent e){
        makeTeams();
    }

    }

