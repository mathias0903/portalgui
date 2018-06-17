package me.admin.portalgui.commands;

import me.admin.portalgui.Core;
import me.admin.portalgui.listeners.ClickListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * PortalGUI started
 */
public class CommandAccept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
        if (commandlabel.equalsIgnoreCase("confirmnation")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You can not execute this command!");
                return true;
            }
            Player p = (Player) sender;
            if (!(p.hasPermission("nationsgui.accept"))) {
                p.sendMessage(ChatColor.RED + "You can not use this command, " + ChatColor.GOLD + " please contact a developer if this is not correct!");
                return true;

            }
            if (!(ClickListener.confirmAcardia.contains(p) || ClickListener.confirmSilverKeep.contains(p))) {
                p.sendMessage(ChatColor.RED + "You do not currently have a request pending!");
                return true;
            }
            if (ClickListener.confirmSilverKeep.contains(p)) {
                ClickListener.confirmSilverKeep.remove(p);
                Core.getPlugin().getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group add Silverkeep");
                p.sendMessage(ChatColor.GREEN + "You have successfully joined the nation" + ChatColor.GOLD + " Silverkeep!");
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " has joined " + ChatColor.GOLD + "Silverkeep" + ChatColor.GREEN + "!");
                return true;
            }
            if (ClickListener.confirmAcardia.contains(p)) {
                ClickListener.confirmAcardia.remove(p);
                Core.getPlugin().getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group add Acardia");
                p.sendMessage(ChatColor.GREEN + "You have successfully joined the nation" + ChatColor.GOLD + " Acardia!");
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " has joined " + ChatColor.GOLD + "Acardia" + ChatColor.GREEN + "!");
                    return true;
            }
        }

        return true;
    }
}
