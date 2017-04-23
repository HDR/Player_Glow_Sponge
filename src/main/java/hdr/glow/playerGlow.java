package hdr.glow;

import hdr.glow.commands.glowToggle;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;

@Plugin(id = "playerglow", name = "Player Glow", version = "0.5")
public class playerGlow {

    private void makeCommands() {
        CommandSpec toggleCMD = CommandSpec.builder()
                .description(Text.of("Toggle Glow"))
                .permission("glow.toggle")
                .executor(new glowToggle())
                .build();
        Sponge.getCommandManager().register(this, toggleCMD, "toggleglow", "tgw");
    }

    public static PotionEffect glowPot;

    @Listener
    public void onInit(GameStartedServerEvent e){
        makeCommands();
        glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(100000).amplifier(100).particles(false).ambience(true).build();
    }

    }

