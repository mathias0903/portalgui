package me.admin.portalgui;

import me.admin.portalgui.listeners.ClickListener;
import me.admin.portalgui.listeners.PortalListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Core extends JavaPlugin implements Listener {

    private static Core plugin;

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin started without errors!");
        plugin = this;
        registerEvents(this, new PortalListener(this), new ClickListener());
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
