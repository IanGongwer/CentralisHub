package me.centy.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Place implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		e.setCancelled(true);
	}

}