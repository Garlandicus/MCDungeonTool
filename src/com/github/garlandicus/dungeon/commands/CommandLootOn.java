package com.github.garlandicus.dungeon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.garlandicus.dungeon.DungeonTools;

public class CommandLootOn implements CommandExecutor {

	DungeonTools parent;
	
	public CommandLootOn(DungeonTools dungeonTools) {
		parent = dungeonTools;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
