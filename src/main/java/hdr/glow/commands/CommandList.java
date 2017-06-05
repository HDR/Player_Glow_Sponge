package hdr.glow.commands;

import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandList {
    public static CommandSpec toggleCMD = CommandSpec.builder().description(Text.of("Toggle Glow")).permission("glow.toggle").executor(new GlowToggle()).build();
    public static CommandSpec infoCMD = CommandSpec.builder().description(Text.of("Info Command")).permission("glow.color").executor(new GlowColor()).build();
    public static CommandSpec BlackCMD = CommandSpec.builder().description(Text.of("Black Glow")).permission("glow.color.black").executor(new ColorBlack()).build();
    public static CommandSpec DarkBlueCMD = CommandSpec.builder().description(Text.of("Dark Blue Glow")).permission("glow.color.darkblue").executor(new ColorDarkBlue()).build();
    public static CommandSpec DarkGreenCMD = CommandSpec.builder().description(Text.of("Dark Green Glow")).permission("glow.color.darkgreen").executor(new ColorDarkGreen()).build();
    public static CommandSpec DarkAquaCMD = CommandSpec.builder().description(Text.of("Dark Aqua Glow")).permission("glow.color.darkaqua").executor(new ColorDarkAqua()).build();
    public static CommandSpec DarkRedCMD = CommandSpec.builder().description(Text.of("Dark Red Glow")).permission("glow.color.darkred").executor(new ColorDarkRed()).build();
    public static CommandSpec DarkPurpleCMD = CommandSpec.builder().description(Text.of("Dark Purple Glow")).permission("glow.color.darkpurple").executor(new ColorDarkPurple()).build();
    public static CommandSpec GoldCMD = CommandSpec.builder().description(Text.of("Gold Glow")).permission("glow.color.gold").executor(new ColorGold()).build();
    public static CommandSpec GrayCMD = CommandSpec.builder().description(Text.of("Gray Glow")).permission("glow.color.gray").executor(new ColorGray()).build();
    public static CommandSpec DarkGrayCMD = CommandSpec.builder().description(Text.of("Dark Gray Glow")).permission("glow.color.darkgray").executor(new ColorDarkGray()).build();
    public static CommandSpec BlueCMD = CommandSpec.builder().description(Text.of("Blue Glow")).permission("glow.color.blue").executor(new ColorBlue()).build();
    public static CommandSpec GreenCMD = CommandSpec.builder().description(Text.of("Green Glow")).permission("glow.color.green").executor(new ColorGreen()).build();
    public static CommandSpec AquaCMD = CommandSpec.builder().description(Text.of("Aqua Glow")).permission("glow.color.aqua").executor(new ColorAqua()).build();
    public static CommandSpec RedCMD = CommandSpec.builder().description(Text.of("Red Glow")).permission("glow.color.red").executor(new ColorRed()).build();
    public static CommandSpec LightPurpleCMD = CommandSpec.builder().description(Text.of("Light Purple Glow")).permission("glow.color.lightpurple").executor(new ColorLightPurple()).build();
    public static CommandSpec YellowCMD = CommandSpec.builder().description(Text.of("Yellow Glow")).permission("glow.color.yellow").executor(new ColorYellow()).build();
    public static CommandSpec WhiteCMD = CommandSpec.builder().description(Text.of("White Glow")).permission("glow.color.white").executor(new ColorWhite()).build();
    public static CommandSpec colorCMD = CommandSpec.builder().description(Text.of("")).executor(new GlowColor()).child(toggleCMD, "toggle", "tg").child(infoCMD, "help", "info").child(BlackCMD, "black").child(DarkBlueCMD, "darkblue").child(DarkGreenCMD, "darkgreen").child(DarkAquaCMD, "darkaqua").child(DarkRedCMD, "darkred").child(DarkPurpleCMD, "darkpurple").child(GoldCMD, "gold").child(GrayCMD, "gray").child(DarkGrayCMD, "darkgray").child(BlueCMD, "blue").child(GreenCMD, "green").child(AquaCMD, "aqua").child(RedCMD, "red").child(LightPurpleCMD, "lightpurple").child(YellowCMD, "yellow").child(WhiteCMD, "white").permission("glow.menu").build();
}
