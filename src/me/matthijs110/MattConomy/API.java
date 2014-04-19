package me.matthijs110.MattConomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class API {
	
	public static Main m;
	
	public static int CurrentBalance(Player p) {
		int currentbalance = m.getConfig().getInt(p.getUniqueId().toString() + ".Balance");
		return currentbalance;
	}
	
	public static void giveMoney(Player p, int i) {
		m.getConfig().set(p.getUniqueId().toString() + ".Balance",
				m.getConfig().getInt(p.getUniqueId().toString() + ".Balance", 0) + i);
		m.saveConfig();
		
		
		
		p.sendMessage(ChatColor.GREEN + "+ " + ChatColor.GOLD + "$" + i + ".00");
		p.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p));
	}

	public static void takeMoney(Player p, int i) {
		m.getConfig().set(p.getUniqueId().toString() + ".Balance",
				m.getConfig().getInt(p.getUniqueId().toString() + ".Balance", 0) - i);
		m.saveConfig();
		
		
		p.sendMessage(ChatColor.RED + "- " + ChatColor.GOLD + "$" + i + ".00");
		p.sendMessage(ChatColor.GREEN + "Your new balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p));
	}
	
	public static void getBalance(Player p) {
		p.sendMessage(ChatColor.GOLD + "Your current balance is " + ChatColor.YELLOW + "$" + CurrentBalance(p));
	}
}
