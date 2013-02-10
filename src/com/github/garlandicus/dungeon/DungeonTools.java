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

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
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
import com.github.garlandicus.listeners.LootListener;

public class DungeonTools extends JavaPlugin {

	ArrayList<DungeonTeam> teams;

	@Override
	public void onEnable() {
		getLogger()
				.info("DungeonTools onEnable has been invoked! Hang on to your booties!");

		//Team initialization
		teams = new ArrayList<DungeonTeam>();
		
		//Command Registration
		getCommand("disband").setExecutor(new CommandDisband(this));
		getCommand("distribute").setExecutor(new CommandDistribute(this));
		getCommand("joinTeam").setExecutor(new CommandJoinTeam(this));
		getCommand("leaveTeam").setExecutor(new CommandLeaveTeam(this));
		getCommand("lootInventory").setExecutor(new CommandLootInventory(this));
		getCommand("lootOff").setExecutor(new CommandLootOff(this));
		getCommand("lootOn").setExecutor(new CommandLootOn(this));
		getCommand("newTeam").setExecutor(new CommandNewTeam(this));
		
		//Event Registration
		getServer().getPluginManager().registerEvents(new LootListener(this), this);
	}

	@Override
	public void onDisable() {
		getLogger()
				.info("DungeonTools onDisable has been invoked! Hang on to your booties!");
	}
	
	/**
	 * Checks to see if a specified player is a member of a team. Returns the first team the player is a member of
	 * @param player The player to be checked
	 * @return The first team a player is found on, or null if no teams contain the player
	 */
	public DungeonTeam getTeam(Player player)
	{
		for(int x = 0; x < teams.size(); x++)
		{
			if(teams.get(x).containsPlayer(player))
				return teams.get(x);
		}
		return null;
	}
	
	public int newTeam(Player creator, String[] args)
	{
		String name = creator.getName() + "'s Team";
		String pass = "";
		if(args.length > 0)
			name = args[0];
		if(args.length > 1)
			pass = args[1];
		
		for(int x = 0; x < teams.size(); x++)
		{
			if(teams.get(x).containsPlayer(creator))
				return -1;
			else if(teams.get(x).getTeamName().equals(name))
				return -2;
		}
		teams.add(new DungeonTeam(creator,name,pass));
		Bukkit.broadcastMessage("The team " + name + " has been created! Huzzah!");
		creator.playEffect(creator.getLocation(),Effect.RECORD_PLAY,1);
		return 1;
	}
}
