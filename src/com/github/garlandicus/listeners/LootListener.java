package com.github.garlandicus.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import com.github.garlandicus.dungeon.DungeonTools;
import com.github.garlandicus.dungeon.util.DungeonTeam;

public class LootListener implements Listener {
	
	DungeonTools parent;
	
	public LootListener(DungeonTools dungeonTools)
	{
		super();
		parent = dungeonTools;		
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event)
	{
		Bukkit.broadcastMessage(event.getPlayer().getName() + " has emerged from slumber! Beware!");
	}
	
	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent event)
	{
		
		Item loot = event.getItem(); 
		Bukkit.broadcastMessage(event.getPlayer().getName() + " has picked up "+loot.getItemStack().getAmount() + 
				" of item " +loot.getEntityId());
		DungeonTeam team = parent.getTeam(event.getPlayer());
		if(team != null && team.getLooting())
		{
			event.setCancelled(true);
			while(loot.isValid())
			{
				
				int inventoryPage = 0;
				if(team.getInventory(inventoryPage).firstEmpty() != -1)
				{
					team.getInventory(inventoryPage).addItem(loot.getItemStack());
					event.getItem().remove();
				}
				else if(team.getInventory(inventoryPage+1) == null)
				{
					team.addInventoryPage();
					inventoryPage = inventoryPage+1;
				}
			}
		}
	}
}
