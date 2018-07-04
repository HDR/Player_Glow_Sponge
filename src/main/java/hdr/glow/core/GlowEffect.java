package hdr.glow.core;

import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

public enum GlowEffect {
    BLACK("black", TextColors.BLACK),
    DARK_BLUE("darkblue", TextColors.DARK_BLUE),
    DARK_GREEN("darkgreen", TextColors.DARK_GREEN),
    DARK_AQUA("darkaqua", TextColors.DARK_AQUA),
    DARK_RED("darkred", TextColors.DARK_RED),
    DARK_PURPLE("darkpurple", TextColors.DARK_PURPLE),
    GOLD("gold", TextColors.GOLD),
    GRAY("gray", TextColors.GRAY),
    DARK_GRAY("darkgray", TextColors.DARK_GRAY),
    BLUE("blue", TextColors.BLUE),
    GREEN("green", TextColors.GREEN),
    AQUA("aqua", TextColors.AQUA),
    RED("red", TextColors.RED),
    LIGHT_PURPLE("lightpurple", TextColors.LIGHT_PURPLE),
    YELLOW("yellow", TextColors.YELLOW),
    WHITE("white", TextColors.WHITE),
    TOGGLE("toggle", TextColors.WHITE);

    private final String team;
    private final TextColor textColor;

    GlowEffect(String team, TextColor textColor) {
        this.textColor = textColor;
        this.team = team;
    }

    public TextColor getTextColor() {
        return textColor;
    }

    public String getTeam() {
        return team;
    }
}