package com.hdr.glow.commands;

import com.hdr.glow.core.GlowColors;
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

public class GlowColor implements CommandExecutor {

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

		if (src instanceof Player) {
			Player player = (Player) src;
			PaginationList.builder()
					.title(Text.of(TextStyles.BOLD, TextColors.GREEN, "Player Glow 1.1.0 By HDR"))
					.contents(
							Commands.Toggle,
							GlowColors.BLACK.getCommandText(),
							GlowColors.DARK_BLUE.getCommandText(),
							GlowColors.DARK_GREEN.getCommandText(),
							GlowColors.DARK_AQUA.getCommandText(),
							GlowColors.DARK_RED.getCommandText(),
							GlowColors.DARK_PURPLE.getCommandText(),
							GlowColors.GOLD.getCommandText(),
							GlowColors.GRAY.getCommandText(),
							GlowColors.DARK_GRAY.getCommandText(),
							GlowColors.BLUE.getCommandText(),
							GlowColors.GREEN.getCommandText(),
							GlowColors.AQUA.getCommandText(),
							GlowColors.RED.getCommandText(),
							GlowColors.LIGHT_PURPLE.getCommandText(),
							GlowColors.YELLOW.getCommandText(),
							GlowColors.WHITE.getCommandText())
					.padding(Text.of("="))
					.sendTo(player);
		}
		return CommandResult.success();
	}
}
