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
                sender.sendMessage(ChatColor.RED + "You can not use this command!");
                    return true;
                }
                Player p = (Player) sender;
                if (!(p.hasPermission("nationsgui.open"))) {
                    p.sendMessage(ChatColor.RED + "You can not use this command, " + ChatColor.GOLD + " please contact a developer if this is not correct!");
                    return true;
                }
                if (args.length == 0) {
                    p.openInventory(GUIHandler.invent);
                    p.sendMessage(ChatColor.GREEN + "NationsGUI forcibly opened by player!");
                    return true;
                }
            if(args.length != 1 && args.length != 0){
                p.sendMessage(ChatColor.RED + "Incorrect Syntax! " + ChatColor.GOLD + "/nationsgui [playername]");
                return true;
            }

                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                        if(target == null){
                            p.sendMessage(ChatColor.RED + "Can not find player " + ChatColor.GOLD + args[0]);
                            return true;
                        }


                        target.openInventory(GUIHandler.invent);
                        target.sendMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " has forcibly opened the Nation Selector for you!");
                        p.sendMessage(ChatColor.GREEN + "You have successfully opened the NationsGUI for " + ChatColor.GOLD + args[0] + ChatColor.GREEN + "!");
                        return true;
                }
            }


        return true;
    }

}
