package hdr.glow.core;

import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;


import static hdr.glow.PlayerGlow.scoreboard;

public class GlowCore {

    public static final Team Black = Team.builder().name("Black").prefix(Text.of(TextColors.BLACK)).color(TextColors.BLACK).build();
    public static Team DarkBlue = Team.builder().name("DarkBlue").prefix(Text.of(TextColors.DARK_BLUE)).color(TextColors.DARK_BLUE).build();
    public static Team DarkGreen = Team.builder().name("DarkGreen").prefix(Text.of(TextColors.DARK_GREEN)).color(TextColors.DARK_GREEN).build();
    public static Team DarkAqua = Team.builder().name("DarkAqua").prefix(Text.of(TextColors.DARK_AQUA)).color(TextColors.DARK_AQUA).build();
    public static Team DarkRed = Team.builder().name("DarkRed").prefix(Text.of(TextColors.DARK_RED)).color(TextColors.DARK_RED).build();
    public static Team DarkPurple = Team.builder().name("DarkPurple").prefix(Text.of(TextColors.DARK_PURPLE)).color(TextColors.DARK_PURPLE).build();
    public static Team Gold = Team.builder().name("Orange").prefix(Text.of(TextColors.GOLD)).color(TextColors.GOLD).build();
    public static Team Gray = Team.builder().name("Gray").prefix(Text.of(TextColors.GRAY)).color(TextColors.GRAY).build();
    public static Team DarkGray = Team.builder().name("DarkGray").prefix(Text.of(TextColors.DARK_GRAY)).color(TextColors.DARK_GRAY).build();
    public static Team Blue = Team.builder().name("Blue").prefix(Text.of(TextColors.BLUE)).color(TextColors.BLUE).build();
    public static Team Green = Team.builder().name("Green").prefix(Text.of(TextColors.GREEN)).color(TextColors.GREEN).build();
    public static Team Aqua = Team.builder().name("Aqua").prefix(Text.of(TextColors.AQUA)).color(TextColors.AQUA).build();
    public static Team Red = Team.builder().name("Red").prefix(Text.of(TextColors.RED)).color(TextColors.RED).build();
    public static Team LightPurple = Team.builder().name("Pink").prefix(Text.of(TextColors.LIGHT_PURPLE)).color(TextColors.LIGHT_PURPLE).build();
    public static Team Yellow = Team.builder().name("Yellow").prefix(Text.of(TextColors.YELLOW)).color(TextColors.YELLOW).build();
    public static Team White = Team.builder().name("White").prefix(Text.of(TextColors.WHITE)).color(TextColors.WHITE).build();
    public static Team Default = Team.builder().name("Default").build();

    public static void registerTeams(){
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
        scoreboard.registerTeam(Default);
    }
}
