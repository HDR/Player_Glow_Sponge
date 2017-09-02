package com.hdr.glow;

import com.google.gson.JsonObject;
import com.google.inject.Inject;
import com.hdr.glow.command.Glow;
import com.hdr.glow.config.FileManager;
import com.hdr.glow.util.GlowEffect;
import com.hdr.glow.util.GlowRegistry;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Plugin(id = "playerglow", name = "Player Glow", version = "1.2")
public class PlayerGlow {
	private static PlayerGlow instance;
	private FileManager fileManager;

	@Inject
	private Logger logger;

	@Inject
	@ConfigDir(sharedRoot = false)
	private File config;

	@Listener
	public void onServerStart(GameStartedServerEvent event) {
		instance = this;
		fileManager = new FileManager("data.json");
		fileManager.createJson();
		fileManager.readJson();
		registerCommands();
		GlowRegistry.getInstance();
	}

	private void registerCommands() {
		HashMap<String, String> choices = new HashMap<>();

		for (GlowEffect color : GlowEffect.values()) {
			choices.put(color.getTeam(), color.name());
		}

		CommandSpec glow = CommandSpec.builder()
				.description(Text.of(TextColors.GREEN, "Change colors or toggle your glow effect"))
				.permission("glow.use")
				.arguments(
						GenericArguments.optional(GenericArguments.choices(Text.of("color"), choices))
				)
				.executor(new Glow())
				.build();

		Sponge.getCommandManager().register(this, glow, "glow");
	}

	@Listener
	public void onJoin(ClientConnectionEvent.Join e) {
		JsonObject colorData = fileManager.getColorData();
		Player player = e.getTargetEntity();
		GlowRegistry.getInstance().setGlowScoreboard(player);
		String PlayerID = player.getUniqueId().toString();

		if (colorData.has(PlayerID)) {
			String color = colorData.get(PlayerID).getAsString();
			GlowRegistry.getInstance().addToGlowTeam(GlowEffect.valueOf(color), player);
			colorData.addProperty(PlayerID, color);
		}
	}

	@Listener
	public void onSave(SaveWorldEvent event) {
		try {
			fileManager.create(fileManager.getColorData().toString());
		} catch (IOException e) {

		}
	}

	public static PlayerGlow getInstance() {
		return instance;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public Logger getLogger() {
		return logger;
	}

	public File getConfigDir() {
		return config;
	}
}
