package hdr.glow.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import static hdr.glow.config.GlowStrings.*;

public class GlowColor implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

            PaginationList.builder()
                    .title(Text.of(TextStyles.BOLD, TextColors.GREEN, "Player Glow 1.3.0 By HDR"))
                    .contents(Toggle, Black, DarkBlue, DarkGreen, DarkAqua, DarkRed, DarkPurple, Gold, Gray, DarkGray, Blue, Green, Aqua, Red, LightPurple, Yellow, White)
                    .padding(Text.of("="))
                    .sendTo(src);
        return CommandResult.success();
    }
}
