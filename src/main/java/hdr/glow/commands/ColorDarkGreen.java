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
import static hdr.glow.config.GlowTeams.*;
import static hdr.glow.PlayerGlow.ColorData;

public class ColorDarkGreen implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            String uuid = player.getUniqueId().toString();
            String color = "DarkGreen";
            ColorData.addProperty(uuid, color);
            DarkGreen.addMember(Text.of(player.getName()));
            player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.DARK_GREEN, TextStyles.BOLD, "Dark Green Glow Enabled"));
        }
        return CommandResult.success();
    }
}