package com.hdr.glow;

import com.google.inject.Inject;
import com.hdr.glow.config.FileManager;
import com.hdr.glow.util.GlowColor;
import com.hdr.glow.util.GlowRegistry;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.io.File;
import java.util.HashMap;

@Plugin(id = "playerglow", name = "Player Glow", version = "1.2")
public class PlayerGlow {
	private static PlayerGlow instance;

	@Inject
	private Logger logger;

	@Inject
	@ConfigDir(sharedRoot = false)
	private File config;

	@Listener
	public void onServerStart(GameStartedServerEvent e) {
		instance = this;
		FileManager.createJson();
		FileManager.readJson();
		registerCommands();
		Sponge.getEventManager().registerListeners(this, new SpongeListeners());
		GlowRegistry.getInstance();
	}

	private void registerCommands() {
		HashMap<String, String> choices = new HashMap<>();

		for (GlowColor color : GlowColor.values()) {
			choices.put(color.getTeam(), color.name());
		}

		CommandSpec glow = CommandSpec.builder()
				.description(Text.of(TextColors.GREEN, "Change your glow color"))
				.permission("playerglow.command.color")
				.arguments(
						GenericArguments.optional(GenericArguments.choices(Text.of("color"), choices))
				)
				.executor(new com.hdr.glow.command.GlowColor())
				.build();

		Sponge.getCommandManager().register(this, glow, "glow");
	}

	public static PlayerGlow getInstance() {
		return instance;
	}

	public Logger getLogger() {
		return logger;
	}

	public File getConfigDir() {
		return config;
	}
}
