package me.centy.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {

	@EventHandler
	public void onHit(EntityDamageEvent e) {
		e.setCancelled(true);
	}

}