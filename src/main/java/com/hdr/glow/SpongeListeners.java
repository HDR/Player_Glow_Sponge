package com.hdr.glow;

import com.hdr.glow.config.FileManager;
import com.hdr.glow.core.GlowColors;
import com.hdr.glow.core.GlowRegistry;
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
		if (FileManager.ColorData.has(PlayerID)) {
			String PlayerColor = FileManager.ColorData.get(PlayerID).getAsString();
			switch (PlayerColor) {
				case "Aqua":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.AQUA, player);
					FileManager.ColorData.addProperty(PlayerID, "Aqua");
					break;
				case "Black":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.BLACK, player);
					FileManager.ColorData.addProperty(PlayerID, "Black");
					break;
				case "Blue":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.BLUE, player);
					FileManager.ColorData.addProperty(PlayerID, "Blue");
					break;
				case "DarkAqua":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.DARK_AQUA, player);
					FileManager.ColorData.addProperty(PlayerID, "DarkAqua");
					break;
				case "DarkBlue":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.DARK_BLUE, player);
					FileManager.ColorData.addProperty(PlayerID, "DarkBlue");
					break;
				case "DarkGray":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.DARK_GRAY, player);
					FileManager.ColorData.addProperty(PlayerID, "DarkGray");
					break;
				case "DarkGreen":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.DARK_GREEN, player);
					FileManager.ColorData.addProperty(PlayerID, "DarkGreen");
					break;
				case "DarkPurple":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.DARK_PURPLE, player);
					FileManager.ColorData.addProperty(PlayerID, "DarkPurple");
					break;
				case "DarkRed":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.DARK_RED, player);
					FileManager.ColorData.addProperty(PlayerID, "DarkRed");
					break;
				case "Gold":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.GOLD, player);
					FileManager.ColorData.addProperty(PlayerID, "Gold");
					break;
				case "Gray":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.GRAY, player);
					FileManager.ColorData.addProperty(PlayerID, "Gray");
					break;
				case "Green":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.GREEN, player);
					FileManager.ColorData.addProperty(PlayerID, "Green");
					break;
				case "LightPurple":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.LIGHT_PURPLE, player);
					FileManager.ColorData.addProperty(PlayerID, "LightPurple");
					break;
				case "Red":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.RED, player);
					FileManager.ColorData.addProperty(PlayerID, "Red");
					break;
				case "White":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.WHITE, player);
					FileManager.ColorData.addProperty(PlayerID, "White");
					break;
				case "Yellow":
					GlowRegistry.getInstance().addToGlowTeam(GlowColors.YELLOW, player);
					FileManager.ColorData.addProperty(PlayerID, "Yellow");
					break;
				default:
					break;
			}
		}
	}

	@Listener
	public void onSave(SaveWorldEvent e) {
		String jstring = FileManager.ColorData.toString();
		try {
			FileManager.create("colorData.json", jstring);
		} catch (IOException e1) {
		}
	}
}
