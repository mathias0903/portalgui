package me.admin.portalgui.listeners;

import me.admin.portalgui.Core;
import me.admin.portalgui.handler.GUIHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

/**
 * PortalGUI started
 */
public class ClickListener implements Listener {
    public static ArrayList<Player> confirmAcardia = new ArrayList<Player>();
    public  static ArrayList<Player> confirmSilverKeep = new ArrayList<Player>();

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
    	if(event.getInventory() != null) {
    		Inventory inv = event.getInventory();
    		if(inv.getName() != null) {
    			if (inv.getName().equalsIgnoreCase(ChatColor.GREEN + "Choose your allegiance!")) {
    				event.setCancelled(true);
    				if (event.getCurrentItem() != null) {
    					Player p = (Player) event.getWhoClicked();
    					if (event.getCurrentItem().getItemMeta() != null) {
    						if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Acardia")) {
    							event.setCancelled(true);
    							confirmAcardia.add(p);
    							p.closeInventory();
    							p.sendMessage(ChatColor.GOLD + "Are you sure you want to join this team? Do /confirmnation within 30 seconds to join!");
    						}
    						if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Silverkeep")) {
    							event.setCancelled(true);
    							confirmSilverKeep.add(p);
    							p.closeInventory();
    							p.sendMessage(ChatColor.GOLD + "Are you sure you want to join this team? Do /confirmnation within 30 seconds to join!");
    					
    						}
    						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable() {
    							public void run() {
    								if(ClickListener.confirmSilverKeep.contains(p) || ClickListener.confirmAcardia.contains(p)) {
    									if(ClickListener.confirmSilverKeep.contains(p)) {
    										confirmSilverKeep.remove(p);
    									}
    									if(ClickListener.confirmAcardia.contains(p)) {
    										confirmAcardia.remove(p);
    									}
    									p.teleport(new Location(p.getWorld(), 0, 4, 0));
    					                p.openInventory(GUIHandler.invent);
    								}
    							}
    						}, 600);
    					}
    				}
    			}
    		}
    	}
    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
    	Player p = (Player) event.getPlayer();
    	if(event.getInventory() != null) {
    		Inventory inv = event.getInventory();
    		if(inv.getName() != null) {
    			if (inv.getName().equalsIgnoreCase(ChatColor.GREEN + "Choose your allegiance!")) {
    				if(!(ClickListener.confirmSilverKeep.contains(p) || ClickListener.confirmAcardia.contains(p))) {
    					p.teleport(new Location(p.getWorld(), 0, 4, 0));
    					p.openInventory(GUIHandler.invent);
    				}
    			}
    		}
    	}
    }
}
