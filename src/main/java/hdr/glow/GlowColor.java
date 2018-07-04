package hdr.glow;

import hdr.glow.core.GlowEffect;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import hdr.glow.core.GlowRegistry;

import java.util.Optional;

import static hdr.glow.PlayerGlow.ColorData;
import static hdr.glow.core.GlowStrings.*;

class GlowColor implements CommandExecutor {
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player player = (Player) src;
            Optional<String> value = args.getOne("color");
            PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();



            if (value.isPresent()) {
                String color = value.get();
                if (!value.get().equalsIgnoreCase("toggle") & player.hasPermission("glow.color." + color.toLowerCase())) {
                    ColorData.addProperty(player.getUniqueId().toString(), color);
                    GlowRegistry.getInstance().addToGlowTeam(GlowEffect.valueOf(color), player);
                    effects.addElement(GlowRegistry.getInstance().getGlowPotionEffect());
                    player.offer(effects);
                }
                else if (value.get().equalsIgnoreCase("toggle") && player.hasPermission("glow.toggle")) {
                    toggleGlow(player);
                }
                else if (!player.hasPermission("glow.color." + color.toLowerCase())) {
                    player.sendMessage(Text.of(TextColors.RED, "You're not allowed to use this color"));
                }
                else if (!player.hasPermission("glow.toggle")) {
                    player.sendMessage(Text.of(TextColors.RED, "You're not allowed to toggle your glow"));
                }

            } else {
                PaginationList.builder()
                        .title(Text.of(TextStyles.BOLD, TextColors.GREEN, "Player Glow 1.4.0 By HDR"))
                        .contents(Toggle, Black, DarkBlue, DarkGreen, DarkAqua, DarkRed, DarkPurple, Gold, Gray, DarkGray, Blue, Green, Aqua, Red, LightPurple, Yellow, White)
                        .padding(Text.of("="))
                        .sendTo(player);
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
        } else {
            effects.addElement(GlowRegistry.getInstance().getGlowPotionEffect());
            player.offer(effects);
            player.sendMessage(ChatTypes.ACTION_BAR, Text.of(TextColors.GREEN, TextStyles.BOLD, "Glow Enabled"));
        }
    }

    public static boolean isGlowing(PotionEffectData effects) {
        return effects.asList().stream().anyMatch(pot -> pot.getType().equals(PotionEffectTypes.GLOWING));
    }
}
