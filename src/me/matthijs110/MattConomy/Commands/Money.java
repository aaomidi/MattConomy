package me.matthijs110.MattConomy.Commands;

import me.matthijs110.MattConomy.API;
import me.matthijs110.MattConomy.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Money implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Error: This command can only be run from in-game!");
		}

		Player p = (Player) sender;

		if(args.length <= 0) { // just that players balance
			if (cmd.getName().equalsIgnoreCase("money")) {
				API.getBalance(p);
			}
		} else if(args.length == 1) {

			OfflinePlayer customPlayer = Bukkit.getOfflinePlayer(args[0]);

			if (!Main.config.contains(Main.getUUID(customPlayer))) {
				p.sendMessage(ChatColor.RED + "Player " + ChatColor.AQUA + args[0] + " is not found!");
				return true;
			} else if (Main.config.contains(Main.getUUID(customPlayer))) {
				p.sendMessage(ChatColor.AQUA + args[0] + "'s" + ChatColor.GOLD + " current balance is " + 
						ChatColor.YELLOW + "$" + API.CurrentBalance(customPlayer) + ".00");
			}

		} else if (args.length >= 2) {			
			p.sendMessage(ChatColor.RED + "Correct usage: " + ChatColor.GREEN + "/money [player]");
		}
		return false;
	}

}
