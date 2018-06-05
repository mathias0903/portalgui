package me.admin.portalgui.listeners;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

/**
 * PortalGUI started
 */
public class LaunchPads implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        Vector direction = e.getPlayer().getLocation().getDirection();
        if (e.getFrom().getWorld().getName().equalsIgnoreCase("Tutorial")) {

            if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PORTAL || (e.getTo().getBlock().getRelative(BlockFace.NORTH).getType() == Material.SLIME_BLOCK) || (e.getTo().getBlock().getRelative(BlockFace.EAST).getType() == Material.PORTAL) || (e.getTo().getBlock().getRelative(BlockFace.SOUTH).getType() == Material.PORTAL || (e.getTo().getBlock().getRelative(BlockFace.WEST).getType() == Material.PORTAL))) {

                e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(4));
                e.getPlayer().setVelocity(new Vector(e.getPlayer().getVelocity().getY(), 1.0D, e.getPlayer().getVelocity().getY()));
            }
        }


    }
}





