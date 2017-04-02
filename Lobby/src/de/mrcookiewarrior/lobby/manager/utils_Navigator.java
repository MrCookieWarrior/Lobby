package de.mrcookiewarrior.lobby.manager;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.api.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class utils_Navigator
implements Listener
{
public static void Navi(Player p)
{
  Inventory comp = p.getPlayer().getServer().createInventory(null, 27, "Navigator");
  
  ItemStack Team = ItemAPI.CreateItem(Material.REDSTONE, 1, 0, "§aTeam");
  ItemStack SkyBlock = ItemAPI.CreateItem(Material.GRASS, 1, 0, "§1SkyBlock");
  ItemStack Leben = ItemAPI.CreateItem(Material.IRON_PICKAXE, 1, 0, "§2Leben");
  ItemStack PixelGun = ItemAPI.CreateItem(Material.WOOD_AXE, 1, 0, "§4PixelGun");
  ItemStack Cores = ItemAPI.CreateItem(Material.BEACON, 1, 0, "§dCores");
  ItemStack one = ItemAPI.CreateItem(Material.DIAMOND_CHESTPLATE, 1, 0, "§51VS1");
  ItemStack Spawn = ItemAPI.CreateItem(Material.MAGMA_CREAM, 1, 0, "Spawn");
  ItemStack BedWars = ItemAPI.CreateItem(Material.BED, 1, 0, "§cBedWars");
  ItemStack EnderGames = ItemAPI.CreateItem(Material.ENDER_PEARL, 1, 0, "§8EnderGames");
  ItemStack SkyWars = ItemAPI.CreateItem(Material.SAND, 1, 0, "§7SkyWars");
  ItemStack Ragemode = ItemAPI.CreateItem(Material.BOW, 1, 0, "§6Ragemode");
  ItemStack PvP = ItemAPI.CreateItem(Material.DIAMOND_SWORD, 1, 0, "§2PvP");
  ItemStack TTT = ItemAPI.CreateItem(Material.STICK, 1, 0, "§4TTT");
  
  comp.setItem(1, Team);
  comp.setItem(3, SkyBlock);
  comp.setItem(5, Leben);
  comp.setItem(7, PixelGun);
  comp.setItem(9, Cores);
  comp.setItem(11, one);
  comp.setItem(13, Spawn);
  comp.setItem(15, BedWars);
  comp.setItem(17, EnderGames);
  comp.setItem(19, SkyWars);
  comp.setItem(21, Ragemode);
  comp.setItem(23, PvP);
  comp.setItem(25, TTT);
  
  p.openInventory(comp);
}

@EventHandler
public void oncomp(InventoryClickEvent e)
{
  if (!(e.getWhoClicked() instanceof Player)) {
    return;
  }
  Player p = (Player)e.getWhoClicked();
  if (e.getInventory().getName().equalsIgnoreCase("Navigator"))
  {
    if (e.getCurrentItem().getType().equals(Material.REDSTONE) && WarpManager.existWarpPoint("Team")) {
            WarpManager.TeleportToWarpPoint(p, "Team");         
        } else if(e.getCurrentItem().getType().equals(Material.REDSTONE) && !WarpManager.existWarpPoint("Team")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp Team");
    }
    if (e.getCurrentItem().getType().equals(Material.GRASS)) {
        if(!WarpManager.existWarpPoint("SkyBlock")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp SkyBlock");
        } else {
            WarpManager.TeleportToWarpPoint(p, "SkyBlock");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.IRON_PICKAXE)) {
        if(!WarpManager.existWarpPoint("Leben")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp Leben");
        } else {
            WarpManager.TeleportToWarpPoint(p, "Leben");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.WOOD_AXE)) {
        if(!WarpManager.existWarpPoint("PixelGun")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp PixelGun");
        } else {
            WarpManager.TeleportToWarpPoint(p, "PexelGun");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.BEACON)) {
        if(!WarpManager.existWarpPoint("Cores")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp Cores");
        } else {
            WarpManager.TeleportToWarpPoint(p, "Cores");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE)) {
        if(!WarpManager.existWarpPoint("1VS1")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp 1VS1");
        } else {
            WarpManager.TeleportToWarpPoint(p, "1VS1");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.MAGMA_CREAM)) {
        if(!WarpManager.existWarpPoint("Lobby")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp Lobby");
        } else {
            WarpManager.TeleportToWarpPoint(p, "Lobby");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.BED)) {
        if(!WarpManager.existWarpPoint("BedWars")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp BedWars");
        } else {
            WarpManager.TeleportToWarpPoint(p, "BedWars");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
        if(!WarpManager.existWarpPoint("EnderGames")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp EnderGames");
        } else {
            WarpManager.TeleportToWarpPoint(p, "EnderGames");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.SAND)) {
        if(!WarpManager.existWarpPoint("SkyWars")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp SkyWars");
        } else {
            WarpManager.TeleportToWarpPoint(p, "SkyWars");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.BOW)) {
        if(!WarpManager.existWarpPoint("Ragemode")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp Ragemode");
        } else {
            WarpManager.TeleportToWarpPoint(p, "Ragemode");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
        if(!WarpManager.existWarpPoint("PvP")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp PvP");
        } else {
            WarpManager.TeleportToWarpPoint(p, "PvP");
        }
    }
    if (e.getCurrentItem().getType().equals(Material.STICK)) {
        if(!WarpManager.existWarpPoint("TTT")) {
            e.setCancelled(true);
            p.sendMessage(Main.getLobby().Prefix + "§4ERROR: §cDieser Warp muss noch gesetzt werden! §eBitte mache dazu §7/setwarp TTT");
        } else {
            WarpManager.TeleportToWarpPoint(p, "TTT");
        }
    }
  }
}

@EventHandler
public void onclick(PlayerInteractEvent e)
{
  if (e.getPlayer() == null) {
    return;
  }
  if (e.getAction() == null) {
    return;
  }
  Player p = e.getPlayer();
  if (((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) && 
    (p.getInventory().getItemInHand().getType() == Material.COMPASS)) {
    Navi(p);
  }
}
}