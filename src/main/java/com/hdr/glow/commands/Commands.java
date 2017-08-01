package com.hdr.glow.commands;

import com.hdr.glow.PlayerGlow;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class Commands {

    public static Text Toggle = Text.builder("Toggle Glow").onClick(TextActions.runCommand("/glow toggle")).color(TextColors.GREEN).onHover(TextActions.showText(Text.of("Toggle Glow on or off"))).style(TextStyles.BOLD).build();
    public static CommandSpec toggleCMD;
    public static CommandSpec infoCMD;
    public static CommandSpec BlackCMD;
    public static CommandSpec DarkBlueCMD;
    public static CommandSpec DarkGreenCMD;
    public static CommandSpec DarkAquaCMD;
    public static CommandSpec DarkRedCMD;
    public static CommandSpec DarkPurpleCMD;
    public static CommandSpec GoldCMD;
    public static CommandSpec GrayCMD;
    public static CommandSpec DarkGrayCMD;
    public static CommandSpec BlueCMD;
    public static CommandSpec GreenCMD;
    public static CommandSpec AquaCMD;
    public static CommandSpec RedCMD;
    public static CommandSpec LightPurpleCMD;
    public static CommandSpec YellowCMD;
    public static CommandSpec WhiteCMD;
    public static CommandSpec colorCMD;

    public static void registerCommands(PlayerGlow plugin) {
        toggleCMD = CommandSpec.builder().description(Text.of("Toggle Glow")).permission("glow.toggle").executor(new GlowToggle()).build();
        infoCMD = CommandSpec.builder().description(Text.of("Info Command")).permission("glow.color").executor(new GlowColor()).build();
        BlackCMD = CommandSpec.builder().description(Text.of("Black Glow")).permission("glow.color.black").executor(new ColorBlack()).build();
        DarkBlueCMD = CommandSpec.builder().description(Text.of("Dark Blue Glow")).permission("glow.color.darkblue").executor(new ColorDarkBlue()).build();
        DarkGreenCMD = CommandSpec.builder().description(Text.of("Dark Green Glow")).permission("glow.color.darkgreen").executor(new ColorDarkGreen()).build();
        DarkAquaCMD = CommandSpec.builder().description(Text.of("Dark Aqua Glow")).permission("glow.color.darkaqua").executor(new ColorDarkAqua()).build();
        DarkRedCMD = CommandSpec.builder().description(Text.of("Dark Red Glow")).permission("glow.color.darkred").executor(new ColorDarkRed()).build();
        DarkPurpleCMD = CommandSpec.builder().description(Text.of("Dark Purple Glow")).permission("glow.color.darkpurple").executor(new ColorDarkPurple()).build();
        GoldCMD = CommandSpec.builder().description(Text.of("Gold Glow")).permission("glow.color.gold").executor(new ColorGold()).build();
        GrayCMD = CommandSpec.builder().description(Text.of("Gray Glow")).permission("glow.color.gray").executor(new ColorGray()).build();
        DarkGrayCMD = CommandSpec.builder().description(Text.of("Dark Gray Glow")).permission("glow.color.darkgray").executor(new ColorDarkGray()).build();
        BlueCMD = CommandSpec.builder().description(Text.of("Blue Glow")).permission("glow.color.blue").executor(new ColorBlue()).build();
        GreenCMD = CommandSpec.builder().description(Text.of("Green Glow")).permission("glow.color.green").executor(new ColorGreen()).build();
        AquaCMD = CommandSpec.builder().description(Text.of("Aqua Glow")).permission("glow.color.aqua").executor(new ColorAqua()).build();
        RedCMD = CommandSpec.builder().description(Text.of("Red Glow")).permission("glow.color.red").executor(new ColorRed()).build();
        LightPurpleCMD = CommandSpec.builder().description(Text.of("Light Purple Glow")).permission("glow.color.lightpurple").executor(new ColorLightPurple()).build();
        YellowCMD = CommandSpec.builder().description(Text.of("Yellow Glow")).permission("glow.color.yellow").executor(new ColorYellow()).build();
        WhiteCMD = CommandSpec.builder().description(Text.of("White Glow")).permission("glow.color.white").executor(new ColorWhite()).build();
        colorCMD = CommandSpec.builder().description(Text.of("")).executor(new GlowColor()).child(toggleCMD, "toggle", "tg").child(infoCMD, "help", "info").child(BlackCMD, "black").child(DarkBlueCMD, "darkblue").child(DarkGreenCMD, "darkgreen").child(DarkAquaCMD, "darkaqua").child(DarkRedCMD, "darkred").child(DarkPurpleCMD, "darkpurple").child(GoldCMD, "gold").child(GrayCMD, "gray").child(DarkGrayCMD, "darkgray").child(BlueCMD, "blue").child(GreenCMD, "green").child(AquaCMD, "aqua").child(RedCMD, "red").child(LightPurpleCMD, "lightpurple").child(YellowCMD, "yellow").child(WhiteCMD, "white").permission("glow.menu").build();
        Sponge.getCommandManager().register(plugin, colorCMD, "glow");
    }

}
