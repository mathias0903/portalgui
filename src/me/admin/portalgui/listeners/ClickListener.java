package me.admin.portalgui.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * PortalGUI started
 */
public class ClickListener implements Listener{

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase(ChatColor.GREEN + "Nation Selector")) {

            Player p = (Player) event.getWhoClicked();
            if (event.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
                event.setCancelled(true);
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Do stuff");
            }
            if (event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                event.setCancelled(true);
                p.closeInventory();
                p.sendMessage(ChatColor.AQUA + "Do stuff");
            }
        }
    }
}
