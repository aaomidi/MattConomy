package me.matthijs110.MattConomy.Commands;

import me.matthijs110.MattConomy.API;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveMoney implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Error: This command can only be run from in-game!");
		}
		
		if (cmd.getName().equalsIgnoreCase("givemoney")) {
			API.giveMoney(p, 200);
			System.out.print(p.getName() + "'s new balance is " + API.CurrentBalance(p));
		}
		return false;
	}
}
