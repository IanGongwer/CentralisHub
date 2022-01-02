package me.centy.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.centy.listeners.Break;
import me.centy.listeners.Command;
import me.centy.listeners.Damage;
import me.centy.listeners.Drop;
import me.centy.listeners.Fight;
import me.centy.listeners.Food;
import me.centy.listeners.InventoryMove;
import me.centy.listeners.Join;
import me.centy.listeners.Particle;
import me.centy.listeners.Place;
import me.centy.listeners.PlayerToggle;
import me.centy.listeners.Quit;
import me.centy.listeners.ServerSelector;

public class Main extends JavaPlugin {

	public File customParticleFile;
	public FileConfiguration customParticle;

	public void registerRunnables() {

	}

	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new Join(this), this);
		getServer().getPluginManager().registerEvents(new Damage(), this);
		getServer().getPluginManager().registerEvents(new Fight(), this);
		getServer().getPluginManager().registerEvents(new Quit(), this);
		getServer().getPluginManager().registerEvents(new Food(), this);
		getServer().getPluginManager().registerEvents(new Place(), this);
		getServer().getPluginManager().registerEvents(new Break(), this);
		getServer().getPluginManager().registerEvents(new Command(), this);
		getServer().getPluginManager().registerEvents(new Particle(this), this);
		getServer().getPluginManager().registerEvents(new Drop(), this);
		getServer().getPluginManager().registerEvents(new InventoryMove(), this);
		getServer().getPluginManager().registerEvents(new PlayerToggle(), this);
		getServer().getPluginManager().registerEvents(new ServerSelector(), this);
	}

	public void registerCommands() {
		getCommand("particle").setExecutor(new Particle(this));
	}

	public void onEnable() {
		createParticleConfig();
		registerRunnables();
		registerListeners();
		registerCommands();
	}

	public void onDisable() {

	}

	public FileConfiguration getParticleConfig() {
		return this.customParticle;
	}

	private void createParticleConfig() {
		customParticleFile = new File(getDataFolder(), "particle.yml");
		if (!customParticleFile.exists()) {
			customParticleFile.getParentFile().mkdirs();
			saveResource("particle.yml", false);
		}

		customParticle = new YamlConfiguration();
		try {
			customParticle.load(customParticleFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void saveParticleConfig() {
		try {
			customParticle.save(customParticleFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}