package hdr.glow;

import com.google.gson.JsonObject;
import com.google.inject.Inject;
import hdr.glow.core.*;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.RideEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.*;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static hdr.glow.GlowColor.isGlowing;
import static hdr.glow.core.GlowCore.*;


@Plugin(id = "playerglow", name = "Player Glow")
public class PlayerGlow {

    @Inject
    @DefaultConfig(sharedRoot = true)
    private File defaultConfig;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    public static final Scoreboard scoreboard = Scoreboard.builder().build();
    public static JsonObject ColorData;

    @Listener
    public void onServerStart(GameStartedServerEvent e) {
        GlowCore.registerTeams();
        Utils.createJson();
        Utils.readJson();

        HashMap<String, String> choices = new HashMap<>();

        for (GlowEffect color : GlowEffect.values()) {
            choices.put(color.getTeam(), color.name());
        }

        CommandSpec glow = CommandSpec.builder()
                .description(Text.of(TextColors.GREEN, "Change colors or toggle your glow effect"))
                .permission("glow.menu")
                .arguments(
                        GenericArguments.optional(GenericArguments.choices(Text.of("color"), choices))
                )
                .executor(new GlowColor())
                .build();

        Sponge.getCommandManager().register(this, glow, "glow");

        ConfigurationNode config;
        try {
            if (!defaultConfig.exists()) {
                defaultConfig.createNewFile();
                config = configManager.load();
                config.getNode("Allow Friendly Fire").setValue(false);
                config.getNode("Team Collision").setValue("Always");
                config.getNode("See Friendly Invisible Players").setValue(false);
                config.getNode("Mounts glow with player").setValue(true);
                configManager.save(config);
            }
            ConfigureTeams();

        } catch (IOException exception) {
            System.out.println("The default configuration could not be loaded or created!");
        }
    }

    @Listener
    public void onMount(RideEntityEvent.Mount event, @First Player player) {
        PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
        try {
            if (configManager.load().getNode("Mounts glow with player").getBoolean()) {
                if (isGlowing(effects)) {
                    Entity entity = event.getTargetEntity();
                    String color = ColorData.get(player.getUniqueId().toString()).getAsString();
                    GlowRegistry.getInstance().addToGlowTeam(GlowEffect.valueOf(color), entity);
                    effects.addElement(GlowRegistry.getInstance().getGlowPotionEffect());
                    entity.offer(effects);
                }
            }
        } catch (IOException ignore) {}
    }

    @Listener
    public void onDismount(RideEntityEvent.Dismount event, @First Player player) {
        try {
            if (configManager.load().getNode("Mounts glow with player").getBoolean()) {
                PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
                Entity entity = event.getTargetEntity();
                effects.removeAll(pot -> pot.getType().equals(PotionEffectTypes.GLOWING));
                entity.offer(effects);
            }
        } catch (IOException ignore) {}
    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join e) {
        Player player = e.getTargetEntity();
        GlowRegistry.getInstance().setGlowScoreboard(player);
        String PlayerID = player.getUniqueId().toString();

        if (ColorData.has(PlayerID)) {
            String color = ColorData.get(PlayerID).getAsString();
            GlowRegistry.getInstance().addToGlowTeam(GlowEffect.valueOf(color), player);
            ColorData.addProperty(PlayerID, color);
        } else {
            Default.addMember(Text.of(player.getName()));
        }
    }

    @Listener
    public void onSave(SaveWorldEvent e) {
        String jstring = ColorData.toString();
        try {
            Utils.create("config/playerglow", "colorData.json", jstring);
        } catch (IOException ignore) {}
    }

    private void ConfigureTeams() {
        try {
            ConfigurationNode config = configManager.load();

            //Friendly Fire
            Black.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            DarkBlue.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            DarkGreen.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            DarkAqua.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            DarkRed.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            DarkPurple.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Gold.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Gray.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            DarkGray.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Blue.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Green.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Aqua.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Red.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            LightPurple.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Yellow.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            White.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());
            Default.setAllowFriendlyFire(config.getNode("Allow Friendly Fire").getBoolean());

            //Collision
            String collision = config.getNode("Team Collision").getString().toLowerCase();
            switch (collision) {
                case "always":
                    SetCollisionType(CollisionRules.ALWAYS);
                    break;
                case "never":
                    SetCollisionType(CollisionRules.NEVER);
                    break;
                case "pushotherteams":
                    SetCollisionType(CollisionRules.PUSH_OTHER_TEAMS);
                    break;
                case "pushownteam":
                    SetCollisionType(CollisionRules.PUSH_OWN_TEAM);
                    break;
                default:
                    break;
            }

            //Invisible
            Black.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            DarkBlue.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            DarkGreen.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            DarkAqua.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            DarkRed.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            DarkPurple.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Gold.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Gray.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            DarkGray.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Blue.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Green.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Aqua.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Red.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            LightPurple.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Yellow.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            White.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());
            Default.setCanSeeFriendlyInvisibles(config.getNode("See Friendly Invisible Players").getBoolean());

        } catch (IOException ignore) {
        }

    }

    private void SetCollisionType(CollisionRule rule) {
        Black.setCollisionRule(rule);
        DarkBlue.setCollisionRule(rule);
        DarkGreen.setCollisionRule(rule);
        DarkAqua.setCollisionRule(rule);
        DarkRed.setCollisionRule(rule);
        DarkPurple.setCollisionRule(rule);
        Gold.setCollisionRule(rule);
        Gray.setCollisionRule(rule);
        DarkGray.setCollisionRule(rule);
        Blue.setCollisionRule(rule);
        Green.setCollisionRule(rule);
        Aqua.setCollisionRule(rule);
        Red.setCollisionRule(rule);
        LightPurple.setCollisionRule(rule);
        Yellow.setCollisionRule(rule);
        White.setCollisionRule(rule);
        Default.setCollisionRule(rule);
    }
}