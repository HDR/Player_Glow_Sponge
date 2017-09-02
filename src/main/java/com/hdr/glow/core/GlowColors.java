package com.hdr.glow.core;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public enum GlowColors {

	BLACK("Black", "Black", TextColors.BLACK),
	DARK_BLUE("Dark Blue", "DarkBlue", TextColors.DARK_BLUE),
	DARK_GREEN("Dark Green", "DarkGreen", TextColors.DARK_GREEN),
	DARK_AQUA("Dark Aqua", "DarkAqua", TextColors.DARK_AQUA),
	DARK_RED("Dark Red", "DarkRed", TextColors.DARK_RED),
	DARK_PURPLE("Dark Purple", "DarkPurple", TextColors.DARK_PURPLE),
	GOLD("Gold", "Orange", TextColors.GOLD),
	GRAY("Gray", "Gray", TextColors.GRAY),
	DARK_GRAY("Dark Gray", "DarkGray", TextColors.DARK_GRAY),
	BLUE("Blue", "Blue", TextColors.BLUE),
	GREEN("Geen", "Green", TextColors.GREEN),
	AQUA("Aqua", "Aqua", TextColors.AQUA),
	RED("Red", "Red", TextColors.RED),
	LIGHT_PURPLE("Light Purple", "Pink", TextColors.LIGHT_PURPLE),
	YELLOW("Yellow", "Yellow", TextColors.YELLOW),
	WHITE("White", "White", TextColors.WHITE);

	private final String name;
	private final String teamName;
	private final TextColor textColor;

	private GlowColors(String name, String teamName, TextColor textColor) {
		this.name = name;
		this.textColor = textColor;
		this.teamName = teamName;
	}

	public String getName() {
		return name;
	}

	public TextColor getTextColor() {
		return textColor;
	}

	public String getTeamName() {
		return teamName;
	}

	public Text getCommandText() {
		return Text.builder("Glow " + name).onClick(TextActions.runCommand("/glow " + name.toLowerCase())).color(textColor).onHover(TextActions.showText(Text.of("Glow " + name))).style(TextStyles.BOLD).build();
	}
}
