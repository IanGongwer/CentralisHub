package me.centy.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import net.md_5.bungee.api.ChatColor;

public class SB {

	public static void setScoreboard(Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();

		Objective objective = board.registerNewObjective("Scoreboard", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aCentralisWin | Hub"));

		Team name = board.registerNewTeam("name");
		name.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
		name.setPrefix(ChatColor.translateAlternateColorCodes('&', "&aName: "));
		name.setSuffix(ChatColor.translateAlternateColorCodes('&', "&f" + p.getDisplayName()));
		Score namescore = objective.getScore(ChatColor.BLACK + "" + ChatColor.WHITE);
		namescore.setScore(15);

		Team players = board.registerNewTeam("players");
		players.addEntry(ChatColor.WHITE + "" + ChatColor.WHITE);
		players.setPrefix(ChatColor.translateAlternateColorCodes('&', "&aPlayers: "));
		players.setSuffix(ChatColor.translateAlternateColorCodes('&', "&f" + p.getServer().getOnlinePlayers().size()));
		Score playersscore = objective.getScore(ChatColor.WHITE + "" + ChatColor.WHITE);
		playersscore.setScore(14);

		p.setScoreboard(board);

		for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
			updateScoreboard(p2);
		}
	}

	public static void updateScoreboard(Player p) {

		Scoreboard board = p.getScoreboard();

		if (Bukkit.getOnlinePlayers().size() == 0) {
			board.getTeam("players").setSuffix(
					ChatColor.translateAlternateColorCodes('&', "&f" + p.getServer().getOnlinePlayers().size()));
		} else {
			board.getTeam("players").setSuffix(
					ChatColor.translateAlternateColorCodes('&', "&f" + p.getServer().getOnlinePlayers().size()));
		}
	}

}