package hdr.glow.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;


public class glowColor implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            player.sendMessage(Text.of("Player Glow 0.9 By HDR"));
            player.sendMessage(Text.of("Usage: /glow colorname"));
            player.sendMessage(Text.of("Colors: black, darkblue, darkgreen, darkaqua, darkred, darkpurple, gold, gray, darkgray, blue, green, aqua, red, lightpurple, yellow, white"));
        }
        return CommandResult.success();
    }
}