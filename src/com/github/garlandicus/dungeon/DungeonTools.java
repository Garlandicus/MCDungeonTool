/**
 * Ryan Darge
 * 
 * Last Updated: 1/27/2013
 * 
 * TODO: Add support for bidding on fancy items
 * TODO: Add support for collecting points for contributing items
 * TODO: Add support for collecting exp
 * TODO: Add support for item blacklists
 */

package com.github.garlandicus.dungeon;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.garlandicus.dungeon.commands.CommandDisband;
import com.github.garlandicus.dungeon.commands.CommandDistribute;
import com.github.garlandicus.dungeon.commands.CommandJoinTeam;
import com.github.garlandicus.dungeon.commands.CommandLeaveTeam;
import com.github.garlandicus.dungeon.commands.CommandLootInventory;
import com.github.garlandicus.dungeon.commands.CommandLootOff;
import com.github.garlandicus.dungeon.commands.CommandLootOn;
import com.github.garlandicus.dungeon.commands.CommandNewTeam;
import com.github.garlandicus.dungeon.util.DungeonTeam;

public class DungeonTools extends JavaPlugin {

	ArrayList<DungeonTeam> teams;

	@Override
	public void onEnable() {
		getLogger()
				.info("DungeonTools onEnable has been invoked! Hang on to your booties!");

		getCommand("disband").setExecutor(new CommandDisband(this));
		getCommand("distribute").setExecutor(new CommandDistribute(this));
		getCommand("joinTeam").setExecutor(new CommandJoinTeam(this));
		getCommand("leaveTeam").setExecutor(new CommandLeaveTeam(this));
		getCommand("lootInventory").setExecutor(new CommandLootInventory(this));
		getCommand("lootOff").setExecutor(new CommandLootOff(this));
		getCommand("lootOn").setExecutor(new CommandLootOn(this));
		getCommand("newTeam").setExecutor(new CommandNewTeam(this));
	}

	@Override
	public void onDisable() {
		getLogger()
				.info("DungeonTools onDisable has been invoked! Hang on to your booties!");

	}
}
