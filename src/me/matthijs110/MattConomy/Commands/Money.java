package me.matthijs110.MattConomy.Commands;

import me.matthijs110.MattConomy.API;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Money implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("money")) {
			API.getBalance(p);
			System.out.print(p.getName() + "'s new balance is " + API.CurrentBalance(p));
		}
		return false;
	}

}
