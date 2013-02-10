package com.github.garlandicus.dungeon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.garlandicus.dungeon.DungeonTools;
import com.github.garlandicus.dungeon.util.DungeonTeam;

public class CommandLootInventory implements CommandExecutor {

	DungeonTools parent;
	
	public CommandLootInventory(DungeonTools dungeonTools) {
		parent = dungeonTools;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player)
		{
			Player player = (Player)sender;			
			DungeonTeam team = parent.getTeam(player);
			if(team != null)
			{
				player.openInventory(team.getInventory(0));
				return true;
			}
			else
				sender.sendMessage("You are not on a team!");
		}
		return false;
	}

}
