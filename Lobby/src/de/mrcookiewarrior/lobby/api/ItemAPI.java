/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author DieSeNse14
 */
public class ItemAPI {
    
  public static ItemStack CreateItem(Material mat, int amount, int shortid, String DisplayName)
  {
    short s = (short)shortid;
    ItemStack item = new ItemStack(mat, amount, s);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(DisplayName);
    item.setItemMeta(meta);
    return item;
  }
  
  public static void setLobbyItem(Player p)
  {
    p.getInventory().setItem(0, CreateItem(Material.COMPASS, 1, 0, "§cNavigator"));
    p.getInventory().setItem(8, CreateItem(Material.BLAZE_ROD, 1, 0, "§eSpieler verstecken"));
    p.getInventory().setItem(7, CreateItem(Material.CHEST, 1, 0, "§3Extras"));
    if ((p.hasPermission("lobby.nick")) || (p.isOp())) {
      p.getInventory().setItem(5, CreateItem(Material.NAME_TAG, 1, 0, "§bNicker"));
    }
    if ((p.hasPermission("lobby.youtuber")) || (p.isOp())) {
      p.getInventory().setItem(3, CreateItem(Material.TNT, 1, 0, "§4Silent Lobby"));
    }
  }

}
