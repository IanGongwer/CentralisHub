package me.centy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Command implements Listener {

	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().contains("/particle")) {
			e.setCancelled(false);
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fUnknown command. Type '/help' for help."));
			e.setCancelled(true);
		}
	}

}