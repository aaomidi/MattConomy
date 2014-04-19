package me.matthijs110.MattConomy;

import me.matthijs110.MattConomy.Commands.GiveMoney;
import me.matthijs110.MattConomy.Commands.Money;
import me.matthijs110.MattConomy.Commands.TakeMoney;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public static FileConfiguration config = null;
	public static Plugin plugin;
	
	public static String getUUID(Player player) {
		return player.getUniqueId().toString().replace("-", "");
	}

	public void onEnable() {
		RegisterEvents();
		RegisterCommands();
		
		
		plugin = this;
		config = getConfig();
		
	}
	
	public void onDisable() {
		try {
			config = null;
			plugin = null;
			try{
			 	saveConfig();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception Exception) {
			Exception.printStackTrace();
		}
		
	}
	
	public void RegisterEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void RegisterCommands() {
		getCommand("money").setExecutor(new Money());
		getCommand("givemoney").setExecutor(new GiveMoney());
		getCommand("takemoney").setExecutor(new TakeMoney());
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (!config.contains(p.getUniqueId().toString().replace("-", ""))) {
			config.set(Main.getUUID(p) + ".Balance", 0.00);
			config.set(Main.getUUID(p) + ".Minecraft name", p.getName());
		}
	}

}
