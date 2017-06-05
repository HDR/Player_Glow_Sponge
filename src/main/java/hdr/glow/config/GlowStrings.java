package hdr.glow.config;

import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class GlowStrings {

    //Pagination
    public static Text Toggle = Text.builder("Toggle Glow").onClick(TextActions.runCommand("/glow toggle")).color(TextColors.GREEN).onHover(TextActions.showText(Text.of("Toggle Glow on or off"))).style(TextStyles.BOLD).build();
    public static Text Black = Text.builder("Glow Black").onClick(TextActions.runCommand("/glow black")).color(TextColors.BLACK).onHover(TextActions.showText(Text.of("Glow Black"))).style(TextStyles.BOLD).build();
    public static Text DarkBlue = Text.builder("Glow Dark Blue").onClick(TextActions.runCommand("/glow darkblue")).color(TextColors.DARK_BLUE).onHover(TextActions.showText(Text.of("Glow Dark Blue"))).style(TextStyles.BOLD).build();
    public static Text DarkGreen = Text.builder("Glow Dark Green").onClick(TextActions.runCommand("/glow darkgreen")).color(TextColors.DARK_GREEN).onHover(TextActions.showText(Text.of("Glow Dark Green"))).style(TextStyles.BOLD).build();
    public static Text DarkAqua = Text.builder("Glow Dark Aqua").onClick(TextActions.runCommand("/glow darkaqua")).color(TextColors.DARK_AQUA).onHover(TextActions.showText(Text.of("Glow Dark Aqua"))).style(TextStyles.BOLD).build();
    public static Text DarkRed = Text.builder("Glow Dark Red").onClick(TextActions.runCommand("/glow darkred")).color(TextColors.DARK_RED).onHover(TextActions.showText(Text.of("Glow Dark Red"))).style(TextStyles.BOLD).build();
    public static Text DarkPurple = Text.builder("Glow Dark Purple").onClick(TextActions.runCommand("/glow darkpurple")).color(TextColors.DARK_PURPLE).onHover(TextActions.showText(Text.of("Glow Dark Purple"))).style(TextStyles.BOLD).build();
    public static Text Gold = Text.builder("Glow Gold").onClick(TextActions.runCommand("/glow gold")).color(TextColors.GOLD).onHover(TextActions.showText(Text.of("Glow Gold"))).style(TextStyles.BOLD).build();
    public static Text Gray = Text.builder("Glow Gray").onClick(TextActions.runCommand("/glow gray")).color(TextColors.GRAY).onHover(TextActions.showText(Text.of("Glow Gray"))).style(TextStyles.BOLD).build();
    public static Text DarkGray = Text.builder("Glow Dark Gray").onClick(TextActions.runCommand("/glow darkgray")).color(TextColors.DARK_GRAY).onHover(TextActions.showText(Text.of("Glow Dark Gray"))).style(TextStyles.BOLD).build();
    public static Text Blue = Text.builder("Glow Blue").onClick(TextActions.runCommand("/glow blue")).color(TextColors.BLUE).onHover(TextActions.showText(Text.of("Glow Blue"))).style(TextStyles.BOLD).build();
    public static Text Green = Text.builder("Glow Green").onClick(TextActions.runCommand("/glow green")).color(TextColors.GREEN).onHover(TextActions.showText(Text.of("Glow Green"))).style(TextStyles.BOLD).build();
    public static Text Aqua = Text.builder("Glow Aqua").onClick(TextActions.runCommand("/glow Aqua")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Glow Aqua"))).style(TextStyles.BOLD).build();
    public static Text Red = Text.builder("Glow Red").onClick(TextActions.runCommand("/glow red")).color(TextColors.RED).onHover(TextActions.showText(Text.of("Glow Red"))).style(TextStyles.BOLD).build();
    public static Text LightPurple = Text.builder("Glow Light Purple").onClick(TextActions.runCommand("/glow lightpurple")).color(TextColors.LIGHT_PURPLE).onHover(TextActions.showText(Text.of("Glow Light Purple"))).style(TextStyles.BOLD).build();
    public static Text Yellow = Text.builder("Glow Yellow").onClick(TextActions.runCommand("/glow yellow")).color(TextColors.YELLOW).onHover(TextActions.showText(Text.of("Glow Yellow"))).style(TextStyles.BOLD).build();
    public static Text White = Text.builder("Glow White").onClick(TextActions.runCommand("/glow white")).color(TextColors.WHITE).onHover(TextActions.showText(Text.of("Glow White"))).style(TextStyles.BOLD).build();
    public static PotionEffect glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(100000).amplifier(100).particles(false).ambience(true).build();
}
