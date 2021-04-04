package me.centy.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerSelector implements Listener {

	public Inventory inv = Bukkit.createInventory(null, 9, "Server Selector");
	ItemStack uhcitem = new ItemStack(Material.DIAMOND);
	ItemMeta uhcmeta = uhcitem.getItemMeta();

	@EventHandler
	public void onCompassClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getInventory().getItemInHand().getType() == Material.COMPASS) {
				createUHC();
				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory invclicked = e.getInventory();
		if (invclicked.getName().equalsIgnoreCase(inv.getName())) {
			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase("UHC")) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

	public void createUHC() {
		uhcmeta.setDisplayName("UHC");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("Drop in and battle it out in a 'battle royale' style gamemode.");
		uhcmeta.setLore(Lore);
		uhcitem.setItemMeta(uhcmeta);

		inv.setItem(4, uhcitem);
	}

}