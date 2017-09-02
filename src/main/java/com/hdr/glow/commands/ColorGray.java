package com.hdr.glow.commands;

import com.hdr.glow.config.FileManager;
import com.hdr.glow.core.GlowColors;
import com.hdr.glow.core.GlowRegistry;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

public class ColorGray implements CommandExecutor {

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if (src instanceof Player) {
			Player player = (Player) src;
			String uuid = player.getUniqueId().toString();
			String color = "Gray";
			FileManager.ColorData.addProperty(uuid, color);
			GlowRegistry.getInstance().addToGlowTeam(GlowColors.GRAY, player);
		}
		return CommandResult.success();
	}
}
