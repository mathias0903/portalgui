package me.admin.portalgui.listeners;

import me.admin.portalgui.Core;
import me.admin.portalgui.handler.GUIHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

/**
 * PortalGUI started
 */
public class PortalListener implements Listener{

    Core core;

    public PortalListener(Core core){

        this.core = core;
    }

    @EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event){

        World world = event.getFrom().getWorld();
        Location location = new Location(world, 772, 87, -4176);
            if(event.getFrom().getWorld().getName().equalsIgnoreCase("Tutorial")){

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(), new Runnable(){
                    public void run(){
                        event.setCancelled(true);
                        event.getPlayer().teleport(location);

                    }
                }, 1);
                event.getPlayer().openInventory(GUIHandler.invent);
            }
        }
    }
