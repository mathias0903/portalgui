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
import java.util.Arrays;

/**
 * PortalGUI started
 */
public class GUIHandler {



    Core core;


    private GUIHandler(Core core){
        this.core = core;
    }

    public static Inventory invent = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Choose your allegiance!");



    public static void createItems(Material material, Inventory inv, int Slot, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        inv.setItem(Slot, item);
    }

    public static ItemStack items(ItemStack itemStack, String name, Enchantment enchant, int level) {
        ItemStack item = new ItemStack(itemStack);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> Lore = new ArrayList<String>();
        meta.setLore(Lore);
        item.setItemMeta(meta);
        item.addEnchantment(enchant, level);
        return item;



    }
    static {
        createItems(Material.LOG, invent, 3, ChatColor.GREEN + "Acardia", ChatColor.GRAY + "The largest and most thriving nation,",ChatColor.GRAY + "it’s residents are strong willed", ChatColor.GRAY + "and passionate. ", " You will stop at nothing for what is right!", null);
    }

    static {
        createItems(Material.PACKED_ICE, invent, 5, ChatColor.AQUA + "Silverkeep", ChatColor.GRAY + "In the harsh climates of the north, ",ChatColor.GRAY +  "the people of Silverkeep", ChatColor.GRAY + "have become wary to outsiders.",  "You'll strive on your powerful", "control of ancient magic.");
    }
;




}
