package me.centy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.centy.main.Main;

public class Particle implements Listener, CommandExecutor {

	Main pl;

	public Particle(Main instance) {
		pl = instance;
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Vector behind = p.getLocation().getDirection().normalize().multiply(-1);
		if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockY() != e.getTo().getBlockY()
				|| e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
			if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("default")) {
				p.getWorld().playEffect(p.getLocation().add(behind), Effect.PARTICLE_SMOKE, 0);
			}
			if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("heart")) {
				p.getWorld().playEffect(p.getLocation().add(behind), Effect.HEART, 0);
			}
			if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("flame")) {
				p.getWorld().playEffect(p.getLocation().add(behind), Effect.FLAME, 0);
			}
			if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("smoke")) {
				p.getWorld().playEffect(p.getLocation().add(behind), Effect.SMOKE, 0);
			}
			if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("slime")) {
				p.getWorld().playEffect(p.getLocation().add(behind), Effect.SLIME, 0);
			}
			if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("splash")) {
				p.getWorld().playEffect(p.getLocation().add(behind), Effect.SPLASH, 0);
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("particle"))
				if (args.length == 0) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /particle <particle>"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&cParticles: Heart, Flame, Smoke, Slime, and Splash. Use 'default' if you want the default particle."));
				}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("default")) {
					if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("default")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cYou already have this particle selected."));
					} else {
						pl.getParticleConfig().set(p.getDisplayName(), "default");
						pl.saveParticleConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&aYou have set your particle trail to Default."));
					}
				}
				if (args[0].equalsIgnoreCase("heart")) {
					if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("heart")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cYou already have this particle selected."));
					} else {
						pl.getParticleConfig().set(p.getDisplayName(), "heart");
						pl.saveParticleConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&aYou have set your particle trail to Heart."));
					}
				}
				if (args[0].equalsIgnoreCase("flame")) {
					if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("flame")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cYou already have this particle selected."));
					} else {
						pl.getParticleConfig().set(p.getDisplayName(), "flame");
						pl.saveParticleConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&aYou have set your particle trail to Flame."));
					}
				}
				if (args[0].equalsIgnoreCase("smoke")) {
					if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("smoke")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cYou already have this particle selected."));
					} else {
						pl.getParticleConfig().set(p.getDisplayName(), "smoke");
						pl.saveParticleConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&aYou have set your particle trail to Smoke."));
					}
				}
				if (args[0].equalsIgnoreCase("slime")) {
					if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("slime")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cYou already have this particle selected."));
					} else {
						pl.getParticleConfig().set(p.getDisplayName(), "slime");
						pl.saveParticleConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&aYou have set your particle trail to Slime."));
					}
				}
				if (args[0].equalsIgnoreCase("splash")) {
					if (pl.getParticleConfig().getString(p.getDisplayName()).equalsIgnoreCase("splash")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&cYou already have this particle selected."));
					} else {
						pl.getParticleConfig().set(p.getDisplayName(), "splash");
						pl.saveParticleConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&aYou have set your particle trail to Splash."));
					}
				}
			}
			if (args.length > 1) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /particle <particle>"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&cParticles: Heart, Flame, Smoke, Slime, and Splash. Use 'default' if you want the default particle."));
			}
		}
		return true;
	}

}