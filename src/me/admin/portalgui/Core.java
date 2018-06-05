package me.admin.portalgui;

import me.admin.portalgui.commands.CommandAccept;
import me.admin.portalgui.commands.PortalOpen;
import me.admin.portalgui.listeners.ClickListener;
import me.admin.portalgui.listeners.LaunchPads;
import me.admin.portalgui.listeners.PortalListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.bukkit.PermissionsEx;


public class Core extends JavaPlugin implements Listener {

    private static Core plugin;

    public void onEnable() {
        plugin = this;

        getCommand("nationsgui").setExecutor(new PortalOpen());
        getCommand("confirmnation").setExecutor(new CommandAccept());

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin started without errors!");

        registerEvents(this, new PortalListener(this), new ClickListener(), new LaunchPads());
    }

    public void onDiable(){
        plugin  = null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    public static Core getPlugin(){
        return plugin;
    }

}
