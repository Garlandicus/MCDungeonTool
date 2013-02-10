package com.github.garlandicus.dungeon.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DungeonTeam {
	ArrayList<Player> members;
	ArrayList<Inventory> loot;
	String name;
	String password;
	boolean looting;
	final int inventoryRows = 6;

	/**
	 * Creates a new team with 1 member and the specified name
	 * 
	 * @param creator
	 *            The team leader
	 * @param name
	 * 			  The team name
	 */
	public DungeonTeam(Player creator, String name, String pass) {
		members = new ArrayList<Player>();
		members.add(creator);

		loot = new ArrayList<Inventory>();
		loot.add(Bukkit.createInventory(null, 9*inventoryRows));

		this.name = name;
		this.password = pass;
		looting = true;

	}

	/**
	 * Sets the password to join a team.
	 * 
	 * @param password
	 *            The string containing the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Adds a player to the team
	 * 
	 * @param player
	 *            The player object to be added to the team
	 * @param pass
	 *            The password (If =/= this.password, returns false
	 * @return True if the player can join, False if the player is already in
	 *         the team or the pasword is wrong
	 */
	public boolean addPlayer(Player player, String pass) {
		if (!members.contains(player) && pass.equals(this.password))
			members.add(player);
		else
			return false;
		return true;
	}

	/**
	 * Removes a player from the team
	 * 
	 * @param player
	 *            The player object to be removed from the team
	 * @return True if the player exists in the team (and is removed), False if
	 *         the player is not on the team
	 */
	public boolean removePlayer(Player player) {
		if (members.contains(player))
			members.remove(player);
		else
			return false;
		return true;
	}
	
	/**
	 * Checks to see if a specified player is on this team
	 * 
	 * @param player 
	 * 				The player to be checked
	 * @return True if the player exists on the team, false if the player is not.
	 */
	public boolean containsPlayer(Player player)
	{
		if (members.contains(player))
			return true;
		else
			return false;
	}

	/**
	 * Gets one inventory page for players to view
	 * 
	 * @param inventoryPage
	 *            The page number to be viewed. Should not be over the number of
	 *            inventories available
	 * @return The inventory corresponding to inventoryPage, or null if the
	 *         command was called with an invalid inventoryPage value
	 */
	public Inventory getInventory(int inventoryPage) {
		if (inventoryPage < loot.size())
			return loot.get(inventoryPage);
		else
			return null;
	}
	
	public boolean addInventoryPage()
	{
		if(loot.size() < 10)
			loot.add(Bukkit.createInventory(null, 9*inventoryRows));
		else
			return false;
		return true;
	}

	/**
	 * Adds an item to the inventory
	 * 
	 * @param item
	 *            The item stack to be added
	 * @return True if the item was successfully added, false if there is no
	 *         room.
	 */
	public boolean addItem(ItemStack item) {

		return false;

	}

	/**
	 * Distributes the current inventory to the current team members
	 * 
	 * @return true if all items could be distributed appropriately, false
	 *         otherwise.
	 */
	public boolean distribute() {

		return false;
	}
	
	public String getTeamName() {
		return name;
	}
	
	public boolean getLooting() {
		return looting;
	}
	
	public void setLooting(boolean state) {
		looting = state;
	}

}