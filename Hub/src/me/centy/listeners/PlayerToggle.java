package me.centy.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerToggle implements Listener {

	List<String> visible = new ArrayList<String>();

	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		ItemStack gray = new ItemStack(Material.INK_SACK, 1);
		gray.setDurability((short) 7);
		ItemStack green = new ItemStack(Material.INK_SACK, 1);
		green.setDurability((short) 10);
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getInventory().getItemInHand().getType() == Material.INK_SACK) {
				if (p.getInventory().getItemInHand().getDurability() == (short) 7) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aAll players are now visible."));
					p.getInventory().setItem(8, green);
					visible.add(p.getDisplayName());
					for (Player p2 : Bukkit.getOnlinePlayers()) {
						p.showPlayer(p2);
					}
					return;
				}
			}
			if (p.getInventory().getItemInHand().getType() == Material.INK_SACK) {
				if (p.getInventory().getItemInHand().getDurability() == (short) 10) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cAll players are now hidden."));
					p.getInventory().setItem(8, gray);
					visible.remove(p.getDisplayName());
					for (Player p2 : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(p2);
					}
					return;
				}
			}
		}
	}

}