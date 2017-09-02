package com.hdr.glow;

import com.hdr.glow.config.FileManager;
import com.hdr.glow.util.GlowColor;
import com.hdr.glow.util.GlowRegistry;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;

import java.io.IOException;

public class SpongeListeners {

	@Listener
	public void onJoin(ClientConnectionEvent.Join e) {
		Player player = e.getTargetEntity();
		GlowRegistry.getInstance().setGlowScoreboard(player);
		String PlayerID = player.getUniqueId().toString();
		if (FileManager.colorData.has(PlayerID)) {
			String color = FileManager.colorData.get(PlayerID).getAsString();
			GlowRegistry.getInstance().addToGlowTeam(GlowColor.valueOf(color), player);
			FileManager.colorData.addProperty(PlayerID, color);
		}
	}

	@Listener
	public void onSave(SaveWorldEvent event) {
		String data = FileManager.colorData.toString();

		try {
			FileManager.create("colorData.json", data);
		} catch (IOException e) {

		}
	}
}
