package com.hdr.glow.command;

import com.hdr.glow.config.FileManager;
import com.hdr.glow.util.GlowRegistry;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.Optional;

public class GlowColor implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if (src instanceof Player) {
			Player player = (Player) src;
			String uuid = player.getUniqueId().toString();
			Optional<String> value = args.getOne("color");

			if (value.isPresent()) {
				String color = value.get();
				if (player.hasPermission("glow.color." + color.toLowerCase())) {
					FileManager.colorData.addProperty(uuid, color);
					GlowRegistry.getInstance().addToGlowTeam(com.hdr.glow.util.GlowColor.valueOf(color), player);
				}
			} else {
				if (player.hasPermission("glow.toggle")) {
					toggleGlow(player);
				}
			}
		}
		return CommandResult.success();
	}

	private void toggleGlow(Player player) {
		PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();

		if (isGlowing(effects)) {
			effects.removeAll(pot -> pot.getType().equals(PotionEffectTypes.GLOWING));
			player.offer(effects);
			player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, TextStyles.BOLD, "Glow Disabled"));
			GlowRegistry.getInstance().runGlowFix(player, false);
		} else {
			effects.addElement(GlowRegistry.getInstance().getGlowPotionEffect());
			player.offer(effects);
			player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.GREEN, TextStyles.BOLD, "Glow Enabled"));
			GlowRegistry.getInstance().runGlowFix(player, true);
		}
	}

	private boolean isGlowing(PotionEffectData effects) {
		return effects.asList().stream().anyMatch(pot -> pot.getType().equals(PotionEffectTypes.GLOWING));
	}
}
