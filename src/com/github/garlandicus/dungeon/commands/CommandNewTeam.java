package com.github.garlandicus.dungeon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.garlandicus.dungeon.DungeonTools;

public class CommandNewTeam implements CommandExecutor {

	DungeonTools parent;
	
	public CommandNewTeam(DungeonTools dungeonTools) {
		this.parent = dungeonTools;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player)
		{
			Player player = (Player)sender;
			int result;
			result = this.parent.newTeam(player, args);
			if(result == 1)
				return true;
			else if(result == -1)
				sender.sendMessage("You're already on a team!");
			else if(result == -2)
				sender.sendMessage("That team name is taken already, sorry!");
		}
		return false;
	}

}
