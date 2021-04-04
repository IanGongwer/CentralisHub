package me.centy.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class Drop implements Listener {

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		ItemStack gray = new ItemStack(Material.INK_SACK, 1, (short) 7);
		gray.setDurability((short) 7);
		ItemStack green = new ItemStack(Material.INK_SACK, 1);
		green.setDurability((short) 10);
		if (e.getItemDrop().getItemStack().getType() == Material.COMPASS
				|| e.getItemDrop().getItemStack().getDurability() == 7
				|| e.getItemDrop().getItemStack().getDurability() == 10) {
			e.setCancelled(true);
		}
	}

}