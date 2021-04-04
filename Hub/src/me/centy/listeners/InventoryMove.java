package me.centy.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryMove implements Listener {

	@EventHandler
	public void onItemMove(InventoryClickEvent e) {
		ItemStack gray = new ItemStack(Material.INK_SACK, 1, (short) 7);
		gray.setDurability((short) 7);
		ItemStack green = new ItemStack(Material.INK_SACK, 1);
		green.setDurability((short) 10);
		if (e.getCurrentItem().getType() == Material.COMPASS || e.getCurrentItem().getDurability() == 7
				|| e.getCurrentItem().getDurability() == 10) {
			e.setCancelled(true);
		}
	}

}