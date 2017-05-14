package hdr.glow;

import hdr.glow.commands.glowColor;
import hdr.glow.commands.glowToggle;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.format.TextColors;

@Plugin(id = "playerglow", name = "Player Glow", version = "0.9.4")
public class playerGlow {

    public static PotionEffect glowPot;

    //Build Scoreboard
    Scoreboard scoreboard = Scoreboard.builder().build();

    //Build Teams
    Team Black = Team.builder().name("Black").prefix(Text.of(TextColors.BLACK)).color(TextColors.BLACK).build();
    Team DarkBlue = Team.builder().name("DarkBlue").prefix(Text.of(TextColors.DARK_BLUE)).color(TextColors.DARK_BLUE).build();
    Team DarkGreen = Team.builder().name("DarkGreen").prefix(Text.of(TextColors.DARK_GREEN)).color(TextColors.DARK_GREEN).build();
    Team DarkAqua = Team.builder().name("DarkAqua").prefix(Text.of(TextColors.DARK_AQUA)).color(TextColors.DARK_AQUA).build();
    Team DarkRed = Team.builder().name("DarkRed").prefix(Text.of(TextColors.DARK_RED)).color(TextColors.DARK_RED).build();
    Team DarkPurple = Team.builder().name("DarkPurple").prefix(Text.of(TextColors.DARK_PURPLE)).color(TextColors.DARK_PURPLE).build();
    Team Gold = Team.builder().name("Orange").prefix(Text.of(TextColors.GOLD)).color(TextColors.GOLD).build();
    Team Gray = Team.builder().name("Gray").prefix(Text.of(TextColors.GRAY)).color(TextColors.GRAY).build();
    Team DarkGray = Team.builder().name("DarkGray").prefix(Text.of(TextColors.DARK_GRAY)).color(TextColors.DARK_GRAY).build();
    Team Blue = Team.builder().name("Blue").prefix(Text.of(TextColors.BLUE)).color(TextColors.BLUE).build();
    Team Green = Team.builder().name("Green").prefix(Text.of(TextColors.GREEN)).color(TextColors.GREEN).build();
    Team Aqua = Team.builder().name("Aqua").prefix(Text.of(TextColors.AQUA)).color(TextColors.AQUA).build();
    Team Red = Team.builder().name("Red").prefix(Text.of(TextColors.RED)).color(TextColors.RED).build();
    Team LightPurple = Team.builder().name("Pink").prefix(Text.of(TextColors.LIGHT_PURPLE)).color(TextColors.LIGHT_PURPLE).build();
    Team Yellow = Team.builder().name("Yellow").prefix(Text.of(TextColors.YELLOW)).color(TextColors.YELLOW).build();
    Team White = Team.builder().name("White").prefix(Text.of(TextColors.WHITE)).color(TextColors.WHITE).build();

    private void makeCommands() {
        CommandSpec toggleCMD = CommandSpec.builder().description(Text.of("Toggle Glow")).permission("glow.toggle").executor(new glowToggle()).build();
        CommandSpec infoCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color").executor(new glowColor()).build();
        CommandSpec BlackCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.black").executor(new glowColor()).build();
        CommandSpec DarkBlueCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.darkblue").executor(new glowColor()).build();
        CommandSpec DarkGreenCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.darkgreen").executor(new glowColor()).build();
        CommandSpec DarkAquaCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.darkaqua").executor(new glowColor()).build();
        CommandSpec DarkRedCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.darkred").executor(new glowColor()).build();
        CommandSpec DarkPurpleCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.darkpurple").executor(new glowColor()).build();
        CommandSpec GoldCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.gold").executor(new glowColor()).build();
        CommandSpec GrayCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.gray").executor(new glowColor()).build();
        CommandSpec DarkGrayCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.darkgray").executor(new glowColor()).build();
        CommandSpec BlueCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.blue").executor(new glowColor()).build();
        CommandSpec GreenCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.green").executor(new glowColor()).build();
        CommandSpec AquaCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.aqua").executor(new glowColor()).build();
        CommandSpec RedCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.red").executor(new glowColor()).build();
        CommandSpec LightPurpleCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.lightpurple").executor(new glowColor()).build();
        CommandSpec YellowCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.yellow").executor(new glowColor()).build();
        CommandSpec WhiteCMD = CommandSpec.builder().description(Text.of("")).permission("glow.color.white").executor(new glowColor()).build();
        CommandSpec colorCMD = CommandSpec.builder().description(Text.of("")).executor(new glowColor()).child(infoCMD, "help", "info").child(BlackCMD, "black").child(DarkBlueCMD, "darkblue").child(DarkGreenCMD, "darkgreen").child(DarkAquaCMD, "darkaqua").child(DarkRedCMD, "darkred").child(DarkPurpleCMD, "darkpurple").child(GoldCMD, "gold").child(GrayCMD, "gray").child(DarkGrayCMD, "darkgray").child(BlueCMD, "blue").child(GreenCMD, "green").child(AquaCMD, "aqua").child(RedCMD, "red").child(LightPurpleCMD, "lightpurple").child(YellowCMD, "yellow").child(WhiteCMD, "white").build();
        Sponge.getCommandManager().register(this, toggleCMD, "tgw");
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