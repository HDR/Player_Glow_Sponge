package hdr.glow;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import hdr.glow.config.Utils;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.RideEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.scoreboard.*;
import org.spongepowered.api.text.Text;

import java.io.*;
import java.nio.file.Path;

import static hdr.glow.config.GlowStrings.glowPot;
import static hdr.glow.config.GlowTeams.*;
import static hdr.glow.commands.CommandList.*;

@Plugin(id = "playerglow", name = "Player Glow")
public class PlayerGlow {

    @Inject
    @DefaultConfig(sharedRoot = true)
    private File defaultConfig;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    @Inject
    @ConfigDir(sharedRoot = false)
    private Path privateConfigDir;

    public static Scoreboard scoreboard = Scoreboard.builder().build();
    public static JsonObject ColorData;
    private void makeCommands() {
        Sponge.getCommandManager().register(this, colorCMD, "glow");
    }

    @Listener
    public void onInit(GameInitializationEvent e) {

    }

    @Listener
    public void onServerStart(GameStartedServerEvent e) {
        registerTeams();
        createJson();
        readJson();
        makeCommands();

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
        try {
            if (configManager.load().getNode("Mounts glow with player").getBoolean()) {
                Entity entity = event.getTargetEntity();
                PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
                scoreboard.getMemberTeam(Text.of(player.getName())).get().addMember(Text.of(entity.getUniqueId()));
                effects.addElement(glowPot);
                entity.offer(effects);
            }
        } catch (IOException ignore) {}
    }

    @Listener
    public void onDismount(RideEntityEvent.Dismount event, @First Player player) {
        try {
            if (configManager.load().getNode("Mounts glow with player").getBoolean()) {
                Entity entity = event.getTargetEntity();
                PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
                if (effects.asList().stream().anyMatch(pot -> pot.getType().equals(PotionEffectTypes.GLOWING))) {
                    effects.removeAll(pot -> pot.getType().equals(PotionEffectTypes.GLOWING));
                    entity.offer(effects);
                }
            }
        } catch (IOException ignore) {}
    }



    @Listener
    public void onJoin(ClientConnectionEvent.Join e) {
        Player player = e.getTargetEntity();
        player.setScoreboard(scoreboard);
        String PlayerID = player.getUniqueId().toString();
        if (ColorData.has(PlayerID)) {
            String PlayerColor = ColorData.get(PlayerID).getAsString();
            switch(PlayerColor) {
                case "Aqua":
                    Aqua.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Aqua");
                    break;
                case "Black":
                    Black.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Black");
                    break;
                case "Blue":
                    Blue.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Blue");
                    break;
                case "DarkAqua":
                    DarkAqua.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkAqua");
                    break;
                case "DarkBlue":
                    DarkBlue.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkBlue");
                    break;
                case "DarkGray":
                    DarkGray.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkGray");
                    break;
                case "DarkGreen":
                    DarkGreen.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkGreen");
                    break;
                case "DarkPurple":
                    DarkPurple.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkPurple");
                    break;
                case "DarkRed":
                    DarkRed.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "DarkRed");
                    break;
                case "Gold":
                    Gold.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Gold");
                    break;
                case "Gray":
                    Gray.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Gray");
                    break;
                case "Green":
                    Green.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Green");
                    break;
                case "LightPurple":
                    LightPurple.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "LightPurple");
                    break;
                case "Red":
                    Red.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Red");
                    break;
                case "White":
                    White.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "White");
                    break;
                case "Yellow":
                    Yellow.addMember(Text.of(player.getName()));
                    ColorData.addProperty(PlayerID, "Yellow");
                    break;
                default: break;
            }
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

    private static void createJson() {
        String CreateString = "{}";
        File file = new File("config/playerglow/colorData.json");
        if (!file.exists()) {
            try {
                Utils.create("config/playerglow", "colorData.json", CreateString);
            } catch (IOException ignore) {}
        }
        if (file.length() == 0) {
            try {
                Utils.create("config/playerglow", "colorData.json", CreateString);
            } catch (IOException ignore) {}
        }
    }

    private static void readJson() {
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader("config/playerglow/colorData.json"));
            ColorData = (JsonObject) obj;
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
            switch(collision) {
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
                default: break;
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

        } catch (IOException ignore) {}

    }

    private void SetCollisionType(CollisionRule rule){
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