package hdr.glow.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.text.format.TextColors;


public class glowToggle implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            PotionEffect glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(100000).amplifier(100).particles(false).build();
            PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
            effects.addElement(glowPot);
            player.offer(effects);
            src.sendMessage(Text.of(TextColors.GOLD, "Glow Effect Enabled."));
        }
        return CommandResult.success();
    }
}