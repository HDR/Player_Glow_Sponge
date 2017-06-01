package hdr.glow.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import static hdr.glow.config.glowTeams.*;
import static hdr.glow.playerGlow.ColorData;

public class ColorRed implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            String uuid = player.getUniqueId().toString();
            String color = "Red";
            ColorData.addProperty(uuid, color);
            Red.addMember(Text.of(player.getName()));
            player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, TextStyles.BOLD, "Red Glow Enabled"));
        }
        return CommandResult.success();
    }
}