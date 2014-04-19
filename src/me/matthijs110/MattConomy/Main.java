package me.matthijs110.MattConomy;

import me.matthijs110.MattConomy.Commands.GiveMoney;
import me.matthijs110.MattConomy.Commands.Money;
import me.matthijs110.MattConomy.Commands.TakeMoney;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		RegisterEvents();
		RegisterCommands();
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

		if (!getConfig().contains(p.getName())) {
			getConfig().set(p.getUniqueId().toString() + ".Balance", 0.00);
			getConfig().set(p.getUniqueId().toString() + ".Minecraft name", p.getName());
		}
	}

}
