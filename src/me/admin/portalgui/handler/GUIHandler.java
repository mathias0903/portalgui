package me.admin.portalgui.handler;

import me.admin.portalgui.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * PortalGUI started
 */
public class GUIHandler {

    Core core;

    private GUIHandler(Core core){
        this.core = core;
    }

    public static Inventory invent = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Nation Selector");

    static {
        createItems(Material.DIAMOND_BLOCK, invent, 3, ChatColor.GOLD + "Number one", ChatColor.LIGHT_PURPLE + "One");
    }

    static {
        createItems(Material.EMERALD_BLOCK, invent, 5, ChatColor.GOLD + "Number two", ChatColor.LIGHT_PURPLE + "Two");
    }

    public static void createItems(Material material, Inventory inv, int Slot, String name, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        meta.setLore(Lore);
        item.setItemMeta(meta);

        inv.setItem(Slot, item);
    }

    public static ItemStack items(ItemStack itemStack, String name, String lore, Enchantment enchant, int level) {
        ItemStack item = new ItemStack(itemStack);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(lore);
        meta.setLore(Lore);
        item.setItemMeta(meta);
        item.addEnchantment(enchant, level);
        return item;

    }

}
