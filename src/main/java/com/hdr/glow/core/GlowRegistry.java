package com.hdr.glow.core;

import java.util.HashMap;
import net.minecraft.entity.GlowFix;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.scoreboard.TeamMember;
import org.spongepowered.api.text.Text;

public class GlowRegistry {

    private HashMap<GlowColors, Team> TEAMS = new HashMap<>();
    private static GlowRegistry instance;
    private Scoreboard scoreboard = Scoreboard.builder().build();
    private PotionEffect glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(Integer.MAX_VALUE).amplifier(100).particles(false).ambience(true).build();

    private GlowRegistry() {
        for (GlowColors color : GlowColors.values()) {
            Team team = Team.builder().name(color.getTeamName()).prefix(Text.of(new Object[]{color.getTextColor()})).color(color.getTextColor()).build();
            team.setAllowFriendlyFire(true);
            team.setCanSeeFriendlyInvisibles(false);
            scoreboard.registerTeam(team);
            TEAMS.put(color, team);
        }
    }

    public static GlowRegistry getInstance() {
        if (instance == null) {
            instance = new GlowRegistry();
        }
        return instance;
    }

    public PotionEffect getGlowPotionEffect() {
        return glowPot;
    }

    public void setGlowScoreboard(Player p) {
        p.setScoreboard(scoreboard);
    }

    public void addToGlowTeam(GlowColors color, Entity entity) {
        TeamMember t = (TeamMember) entity;
        TEAMS.get(color).addMember(t.getTeamRepresentation());
        PotionEffectData effects = (PotionEffectData) entity.getOrCreate(PotionEffectData.class).get();
        effects.addElement(glowPot);
        entity.offer(effects);
        runGlowFix(entity, true);
    }

    public void runGlowFix(Entity entity, boolean glowing) {
        if (Sponge.getPlatform().getMinecraftVersion().getName().contains("1.10.2")) {
            if (entity instanceof Player) {
                GlowFix.setGlowing((EntityPlayerMP) entity, true);
            }
        }
    }
}
