package hdr.glow.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.text.format.TextColors;
import java.util.List;
import static hdr.glow.playerGlow.glowPot;


public class glowToggle implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            if (player.get(Keys.POTION_EFFECTS).isPresent()) {
                List<PotionEffect> potionEffects = player.get(Keys.POTION_EFFECTS).get();
                for (PotionEffect pot : potionEffects) {
                    if (pot.getType().equals(PotionEffectTypes.GLOWING)) {
                        player.sendMessage(Text.of(TextColors.GOLD, "Glow Effect Disabled."));
                    }

                }
            } else {
                PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
                effects.addElement(glowPot);
                player.offer(effects);
                src.sendMessage(Text.of(TextColors.GOLD, "Glow Effect Enabled."));
                src.sendMessage(Text.of(player.get(Keys.POTION_EFFECTS)));
            }
        }
        return CommandResult.success();
    }
}