package me.admin.portalgui.listeners;

import me.admin.portalgui.Core;
import me.admin.portalgui.handler.GUIHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;

/**
 * PortalGUI started
 */
public class PortalListener implements Listener {

    Core core;

    public PortalListener(Core core) {

        this.core = core;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player p = (Player) event.getPlayer();

        Location loc = new Location(p.getWorld(), 767, 43, 4187);
        Location loc2 = new Location(p.getWorld(), 0, 4, 0);

        Block pBlock = p.getLocation().getBlock();
        Block northBlock = pBlock.getRelative(BlockFace.NORTH);
        Block southBlock = pBlock.getRelative(BlockFace.SOUTH);
        Block westBlock = pBlock.getRelative(BlockFace.WEST);
        Block eastBlock = pBlock.getRelative(BlockFace.EAST);
        if (p.getWorld().getName().equalsIgnoreCase("Tutorial")) {
            if (northBlock.getType() == Material.PORTAL || southBlock.getType() == Material.PORTAL || westBlock.getType() == Material.PORTAL || eastBlock.getType() == Material.PORTAL || pBlock.getType() == Material.PORTAL) {
                p.teleport(loc2);
                p.openInventory(GUIHandler.invent);
            }
        }

    }
    @EventHandler
    public void onPortalTeleportEvent(PlayerPortalEvent event){
        if(event.getFrom().getWorld().getName().equalsIgnoreCase("Tutorial")){
            event.setCancelled(true);
        }
    }


}
