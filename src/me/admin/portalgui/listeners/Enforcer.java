package me.admin.portalgui.listeners;

import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.event.TownAddResidentEvent;
import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.EmptyTownException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownyUniverse;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * PortalGUI started
 */
public class Enforcer implements Listener {

    @EventHandler
    public void onNewTown(NewTownEvent e) {
        Town town = e.getTown();
        Player p = Bukkit.getPlayer(town.getMayor().getName());
        String nationname = "";
        if(p.hasPermission("Nation.Acardia")) {nationname = "Acardia";}
        else if(p.hasPermission("Nation.Silverkeep")) {nationname = "Silverkeep";}
        try {
            Nation nation = TownyUniverse.getDataSource().getNation(nationname);
            town.setNation(nation);
            nation.addTown(town);
        } catch (NotRegisteredException e1) {
            e1.printStackTrace();
        } catch (AlreadyRegisteredException e1) {
            e1.printStackTrace();
        }
    }
    @EventHandler
    public void onTownJoin(TownAddResidentEvent e) {
        Town town = e.getTown();
        Player p = Bukkit.getPlayer(e.getResident().getName());
        if(town.getRegistered() != 0) {
            try {
                if(town.getNation().getName().equals("Acardia")) {
                    if(p.hasPermission("Nation.Acardia")) {
                        return;
                    }
                }
                else if(town.getNation().getName().equals("Silverkeep")) {
                    if(p.hasPermission("Nation.Silverkeep")) {
                        return;
                    }
                }
                town.removeResident(e.getResident());
                p.sendMessage("§8[§4P§fA§8]§r You can only join towns of the same nation as you");
            } catch (NotRegisteredException e1) {
                e1.printStackTrace();
            } catch (EmptyTownException e1) {
                e1.printStackTrace();
            }
        }
    }
}
