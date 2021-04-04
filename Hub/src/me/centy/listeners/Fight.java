package me.centy.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Fight implements Listener {

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		e.setCancelled(true);
	}

}