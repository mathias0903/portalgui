package me.admin.portalgui.commands;

import me.admin.portalgui.handler.GUIHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * PortalGUI started
 */
public class PortalOpen implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]){
        if(commandlabel.equalsIgnoreCase("nationsgui")){
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You can not use this command!") {
                    return true;
                }
                Player p = (Player) sender;
                if (!(p.hasPermission("nations.guiopen"))) {
                    p.sendMessage(ChatColor.RED + "You can not use this command, " + ChatColor.GOLD + " please contact a developer if this is not correct!");
                    return true;
                }
                if (args.length == 0) {
                    p.openInventory(GUIHandler.invent);
                    p.sendMessage(ChatColor.GREEN + "NationsGUI forcibly opened by player!");
                    return true;
                }
                if(args.length == 1){
                    Player target = (Player) target.getUniqueId();
                        if(target == null){
                            p.sendMessage(ChatColor.RED + "Can not find player " + ChatColor.GOLD + args[0]);
                        }
                }
            }


        }
        return true;
    }

}
