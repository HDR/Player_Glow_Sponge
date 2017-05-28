package hdr.glow.commands;

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

import static hdr.glow.playerGlow.glowPot;

public class glowToggle implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
            if (effects.asList().stream().anyMatch(pot -> pot.getType().equals(PotionEffectTypes.GLOWING))) {
                effects.removeAll(pot -> pot.getType().equals(PotionEffectTypes.GLOWING));
                player.offer(effects);
                player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.RED, TextStyles.BOLD, "Glow Disabled"));
            } else {
                effects.addElement(glowPot);
                player.offer(effects);
                player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.GREEN, TextStyles.BOLD, "Glow Enabled"));
            }
        }
        return CommandResult.success();
    }
}