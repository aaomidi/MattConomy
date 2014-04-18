package me.matthijs110.MattConomy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public int CurrentBalance(Player p) {
		int currentbalance = getConfig().getInt(p.getUniqueId() + ".Balance");
		return currentbalance;
	}

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (!getConfig().contains(p.getName())) {
			getConfig().set(p.getUniqueId() + ".Balance", 0.00);
			getConfig().set(p.getUniqueId() + ".Minecraft name", p.getName());
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("givemoney")) {
			giveMoney(p, 200);
			System.out.print(p.getName() + "'s new balance is " + CurrentBalance(p));
		}
		
		if (cmd.getName().equalsIgnoreCase("takemoney")) {
			takeMoney(p, 200);
			System.out.print(p.getName() + "'s new balance is " + CurrentBalance(p));
		}
		
		if (cmd.getName().equalsIgnoreCase("money")) {
			getBalance(p);
			System.out.print(p.getName() + "'s new balance is " + CurrentBalance(p));
		}
		return false;
	}

	public void giveMoney(Player p, int i) {
		getConfig().set(p.getUniqueId() + ".Balance",
				getConfig().getInt(p.getUniqueId() + ".Balance", 0) + i);
		saveConfig();
		
		
		p.sendMessage(ChatColor.GREEN + "+ " + ChatColor.GOLD + "$" + i + ".00");
		p.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p));
	}

	public void takeMoney(Player p, int i) {
		getConfig().set(p.getUniqueId() + ".Balance",
				getConfig().getInt(p.getUniqueId() + ".Balance", 0) - i);
		saveConfig();
		
		
		p.sendMessage(ChatColor.RED + "- " + ChatColor.GOLD + "$" + i + ".00");
		p.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p));
	}
	
	public void getBalance(Player p) {
		p.sendMessage(ChatColor.GOLD + "Your current balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p));
	}
}
