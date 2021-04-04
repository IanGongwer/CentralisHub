package me.centy.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.centy.scoreboard.SB;

public class Quit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		e.setQuitMessage("");
		for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
			SB.updateScoreboard(p2);
		}
	}

}