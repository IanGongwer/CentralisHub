package me.centy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import me.centy.main.Main;
import me.centy.scoreboard.SB;

public class Join implements Listener {

	Main pl;

	public Join(Main instance) {
		pl = instance;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWelcome to CentralisWin"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aWebsite: &fcentralis.win"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aStore: &fstore.centralis.win"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aDiscord: &fdiscord.gg/centraliswin"));
		p.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "&aChange your particle trail using /particle <particle>"));
		p.setFoodLevel(20);
		p.setHealth(20);
		p.getInventory().clear();
		ItemStack gray = new ItemStack(Material.INK_SACK, 1);
		gray.setDurability((short) 7);
		p.getInventory().setItem(8, gray);
		p.getInventory().setItem(0, new ItemStack(Material.COMPASS));
		SB.setScoreboard(p);
		if (!pl.getParticleConfig().contains(p.getDisplayName())) {
			pl.getParticleConfig().set(p.getDisplayName(), "default");
			pl.saveParticleConfig();
		}
		Location loc = new Location(p.getWorld(), 0, 100, 0);
		p.teleport(loc);
	}

}