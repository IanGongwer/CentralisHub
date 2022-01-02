package me.centy.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Food implements Listener {

	@EventHandler
	public void onFoodDecrease(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

}