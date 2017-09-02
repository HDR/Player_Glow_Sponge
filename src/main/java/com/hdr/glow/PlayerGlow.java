package com.hdr.glow;

import com.google.inject.Inject;
import com.hdr.glow.commands.Commands;
import com.hdr.glow.config.FileManager;
import com.hdr.glow.core.GlowRegistry;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;

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
		Commands.registerCommands(this);
		Sponge.getEventManager().registerListeners(this, new SpongeListeners());
		GlowRegistry.getInstance();
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
