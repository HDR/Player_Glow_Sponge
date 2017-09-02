package com.hdr.glow.util;

import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

public enum GlowColor {
	BLACK("Black", TextColors.BLACK),
	DARK_BLUE("DarkBlue", TextColors.DARK_BLUE),
	DARK_GREEN("DarkGreen", TextColors.DARK_GREEN),
	DARK_AQUA("DarkAqua", TextColors.DARK_AQUA),
	DARK_RED("DarkRed", TextColors.DARK_RED),
	DARK_PURPLE("DarkPurple", TextColors.DARK_PURPLE),
	GOLD("Gold", TextColors.GOLD),
	GRAY("Gray", TextColors.GRAY),
	DARK_GRAY("DarkGray", TextColors.DARK_GRAY),
	BLUE("Blue", TextColors.BLUE),
	GREEN("Green", TextColors.GREEN),
	AQUA("Aqua", TextColors.AQUA),
	RED("Red", TextColors.RED),
	LIGHT_PURPLE("Pink", TextColors.LIGHT_PURPLE),
	YELLOW("Yellow", TextColors.YELLOW),
	WHITE("White", TextColors.WHITE);

	private final String team;
	private final TextColor textColor;

	GlowColor(String team, TextColor textColor) {
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
