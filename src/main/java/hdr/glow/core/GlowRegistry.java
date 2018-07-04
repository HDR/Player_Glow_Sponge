package hdr.glow.core;

import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.scoreboard.TeamMember;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;

import java.util.HashMap;

public class GlowRegistry {
    private static GlowRegistry instance;
    private final Scoreboard scoreboard = Scoreboard.builder().build();
    private HashMap<GlowEffect, Team> teams = new HashMap<>();
    private PotionEffect glowPot = PotionEffect.builder().potionType(PotionEffectTypes.GLOWING).duration(Integer.MAX_VALUE).amplifier(100).particles(false).ambience(true).build();

    private GlowRegistry() {
        for (GlowEffect color : GlowEffect.values()) {
            TextColor textColor = color.getTextColor();
            Team team = Team.builder().name(color.getTeam()).prefix(Text.of(new Object[]{textColor})).color(textColor).build();
            team.setAllowFriendlyFire(true);
            team.setCanSeeFriendlyInvisibles(false);
            scoreboard.registerTeam(team);
            teams.put(color, team);
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

    public void addToGlowTeam(GlowEffect color, Entity entity) {
        TeamMember t = (TeamMember) entity;
        teams.get(color).addMember(t.getTeamRepresentation());
        PotionEffectData effects = entity.getOrCreate(PotionEffectData.class).get();
        effects.addElement(glowPot);
    }
}