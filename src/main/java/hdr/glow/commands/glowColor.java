package hdr.glow.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;


public class glowColor implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            player.sendMessage(Text.of(TextStyles.BOLD, "Player Glow ", TextColors.GOLD, "0.9.4 ", TextColors.WHITE, "By ", TextColors.GOLD, "HDR ", TextColors.RED, "http://bit.ly/2rfrBA3"));
            player.sendMessage(Text.of(TextStyles.BOLD, "Usage: ", TextColors.GOLD, "/glow color"));
            player.sendMessage(Text.of(TextStyles.BOLD, "Colors: ", TextStyles.RESET, TextColors.BLACK, "black ", TextColors.DARK_BLUE, "darkblue ", TextColors.DARK_GREEN, "darkgreen ", TextColors.DARK_AQUA, "darkaqua ", TextColors.DARK_RED, "darkred ", TextColors.DARK_PURPLE, "darkpurple ", TextColors.GOLD, "gold ", TextColors.GRAY, "gray ", TextColors.DARK_GRAY, "darkgray ", TextColors.BLUE, "blue ", TextColors.GREEN, "green ", TextColors.AQUA, "aqua ", TextColors.RED, "red ", TextColors.LIGHT_PURPLE, "lightpurple ", TextColors.YELLOW, "yellow ", TextColors.WHITE, "white"));
        }
        return CommandResult.success();
    }
}