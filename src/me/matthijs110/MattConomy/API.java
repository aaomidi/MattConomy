package me.matthijs110.MattConomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class API {
	
	public static int CurrentBalance(Player p) {
		int currentbalance = Main.config.getInt(Main.getUUID(p) + ".Balance");
		return currentbalance;
	}
	
	public static void giveMoney(Player p, int i) {
		Main.config.set(Main.getUUID(p) + ".Balance", Main.config.getInt(Main.getUUID(p) + ".Balance", 0) + i);
		Main.plugin.saveConfig();
		// p.sendMessage(ChatColor.GREEN + "+ " + ChatColor.GOLD + "$" + i + ".00");
		// p.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p) + ".00");
	}

	public static boolean takeMoney(Player p, int i) {
		int amount = CurrentBalance(p) - i;
		int set;
		if(amount <= 0) {
			set = 0;
		} else {
			set = amount;
			// p.sendMessage(ChatColor.RED + "You can't have less then " + ChatColor.YELLOW + "$0.00");
		return false;
		}
		
		Main.config.set(Main.getUUID(p) + ".Balance", set);
		Main.plugin.saveConfig();
		return true;
		// p.sendMessage(ChatColor.RED + "- " + ChatColor.GOLD + "$" + i + ".00");
		// p.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p) + ".00");
	}
	
	public static int getBalance(Player p) {
		//p.sendMessage(ChatColor.GOLD + "Your current balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p) + ".00");
		return CurrentBalance(p);
	}
}
