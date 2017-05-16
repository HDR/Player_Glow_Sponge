package hdr.glow.commands;

import hdr.glow.config.GlowStrings;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class glowColor implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

        Text Padding = Text.builder("=").color(TextColors.GOLD).build();
        Text Toggle = Text.builder("Toggle Glow").onClick(TextActions.runCommand("/glow toggle")).color(TextColors.GOLD).onHover(TextActions.showText(Text.of("Toggle Glow on or off"))).style(TextStyles.BOLD).build();
        Text Github = Text.builder("https://github.com/MrHDR/Player_Glow_Sponge").color(TextColors.RED).style(TextStyles.BOLD).build();
        Text Black = Text.builder("Glow Black").onClick(TextActions.runCommand("/glow black")).color(TextColors.BLACK).onHover(TextActions.showText(Text.of("Glow Black"))).style(TextStyles.BOLD).build();
        Text DarkBlue = Text.builder("Glow Dark Blue").onClick(TextActions.runCommand("/glow darkblue")).color(TextColors.DARK_BLUE).onHover(TextActions.showText(Text.of("Glow Dark Blue"))).style(TextStyles.BOLD).build();
        Text DarkGreen = Text.builder("Glow Dark Green").onClick(TextActions.runCommand("/glow darkgreen")).color(TextColors.DARK_GREEN).onHover(TextActions.showText(Text.of("Glow Dark Green"))).style(TextStyles.BOLD).build();
        Text DarkAqua = Text.builder("Glow Dark Aqua").onClick(TextActions.runCommand("/glow darkaqua")).color(TextColors.DARK_AQUA).onHover(TextActions.showText(Text.of("Glow Dark Aqua"))).style(TextStyles.BOLD).build();
        Text DarkRed = Text.builder("Glow Dark Red").onClick(TextActions.runCommand("/glow darkred")).color(TextColors.DARK_RED).onHover(TextActions.showText(Text.of("Glow Dark Red"))).style(TextStyles.BOLD).build();
        Text DarkPurple = Text.builder("Glow Dark Purple").onClick(TextActions.runCommand("/glow darkpurple")).color(TextColors.DARK_PURPLE).onHover(TextActions.showText(Text.of("Glow Dark Purple"))).style(TextStyles.BOLD).build();
        Text Gold = Text.builder("Glow Gold").onClick(TextActions.runCommand("/glow gold")).color(TextColors.GOLD).onHover(TextActions.showText(Text.of("Glow Gold"))).style(TextStyles.BOLD).build();
        Text Gray = Text.builder("Glow Gray").onClick(TextActions.runCommand("/glow gray")).color(TextColors.GRAY).onHover(TextActions.showText(Text.of("Glow Gray"))).style(TextStyles.BOLD).build();
        Text DarkGray = Text.builder("Glow Dark Gray").onClick(TextActions.runCommand("/glow darkgray")).color(TextColors.DARK_GRAY).onHover(TextActions.showText(Text.of("Glow Dark Gray"))).style(TextStyles.BOLD).build();
        Text Blue = Text.builder("Glow Blue").onClick(TextActions.runCommand("/glow blue")).color(TextColors.BLUE).onHover(TextActions.showText(Text.of("Glow Blue"))).style(TextStyles.BOLD).build();
        Text Green = Text.builder("Glow Green").onClick(TextActions.runCommand("/glow green")).color(TextColors.GREEN).onHover(TextActions.showText(Text.of("Glow Green"))).style(TextStyles.BOLD).build();
        Text Aqua = Text.builder("Glow Aqua").onClick(TextActions.runCommand("/glow Aqua")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Glow Aqua"))).style(TextStyles.BOLD).build();
        Text Red = Text.builder("Glow Red").onClick(TextActions.runCommand("/glow red")).color(TextColors.RED).onHover(TextActions.showText(Text.of("Glow Red"))).style(TextStyles.BOLD).build();
        Text LightPurple = Text.builder("Glow Light Purple").onClick(TextActions.runCommand("/glow lightpurple")).color(TextColors.LIGHT_PURPLE).onHover(TextActions.showText(Text.of("Glow Light Purple"))).style(TextStyles.BOLD).build();
        Text Yellow = Text.builder("Glow Yellow").onClick(TextActions.runCommand("/glow yellow")).color(TextColors.YELLOW).onHover(TextActions.showText(Text.of("Glow Yellow"))).style(TextStyles.BOLD).build();
        Text White = Text.builder("Glow White").onClick(TextActions.runCommand("/glow white")).color(TextColors.WHITE).onHover(TextActions.showText(Text.of("Glow White"))).style(TextStyles.BOLD).build();
        if (src instanceof Player) {
            Player player = (Player) src;
            PaginationList.builder()
                    .title(Text.of(TextStyles.BOLD, "Player Glow ", TextColors.GOLD, GlowStrings.PluginVersion, TextColors.WHITE, " By ", TextColors.GOLD, "HDR "))
                    .contents(Toggle, Black, DarkBlue, DarkGreen, DarkAqua, DarkRed, DarkPurple, Gold, Gray, DarkGray, Blue, Green, Aqua, Red, LightPurple, Yellow, White)
                    .header(Github)
                    .padding(Padding)
                    .sendTo(player);
        }
        return CommandResult.success();
    }
}