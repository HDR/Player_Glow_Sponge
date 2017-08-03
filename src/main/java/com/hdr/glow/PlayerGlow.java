package com.hdr.glow;

import com.google.inject.Inject;
import com.hdr.glow.commands.Commands;
import com.hdr.glow.config.FileManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import java.io.*;
import com.hdr.glow.core.GlowRegistry;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;

@Plugin(id = "playerglow", name = "Player Glow", version = "1.1.0")
public class PlayerGlow {

    private static PlayerGlow instance;

    @Inject
    @ConfigDir(sharedRoot = false)
    private File config;

    @Inject
    private Logger logger;

    public Logger getLogger() {
        return logger;
    }

    public File getConfigDir() {
        return config;
    }

    public static PlayerGlow getInstance() {
        return instance;
    }

    @Listener
    public void onInit(GameStartedServerEvent e) {
        instance = this;
        FileManager.createJson();
        FileManager.readJson();
        Commands.registerCommands(this);
        Sponge.getEventManager().registerListeners(this, new SpongeListeners());
    }

    @Listener
    public void onServerStart(GameStartedServerEvent e) {
        GlowRegistry.getInstance();
    }

}
