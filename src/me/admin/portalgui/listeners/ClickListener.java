package me.admin.portalgui.listeners;

import me.admin.portalgui.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

/**
 * PortalGUI started
 */
public class ClickListener implements Listener {


    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {


        if (event.getInventory().getName().equalsIgnoreCase(ChatColor.GREEN + "Choose your allegiance!")) {

            Player p = (Player) event.getWhoClicked();
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Acardia")) {
                event.setCancelled(true);
                p.closeInventory();
                confirmAcardia.add(p);
                p.sendMessage(ChatColor.GOLD + "Are you sure you want to join this team? Do /confirmnation within 5 seconds to join!");

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable() {
                    public void run() {
                        confirmAcardia.remove(p);
                        confirmSilverKeep.remove(p);
                    }
                }, 200);
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Silverkeep")) {
                event.setCancelled(true);
                p.closeInventory();
                confirmSilverKeep.add(p);
                p.sendMessage(ChatColor.GOLD + "Are you sure you want to join this team? Do /confirmnation within 5 seconds to join!");
            }
        }
    }

    public static ArrayList<Player> confirmAcardia = new ArrayList<Player>();

    public static ArrayList<Player> confirmSilverKeep = new ArrayList<Player>();
}
