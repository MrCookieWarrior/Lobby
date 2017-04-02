package de.mrcookiewarrior.lobby.commands;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.manager.WarpManager;
import de.mrcookiewarrior.lobby.manager.utils_Navigator;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Warp
implements CommandExecutor
{
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
{
  if ((sender instanceof Player))
  {
    Player p = (Player)sender;
    
    Location loc = p.getLocation();
    if (args.length == 0)
    {
      utils_Navigator.Navi(p);
      return true;
    }
    if (args.length == 1)
    {
      if (args[0].equalsIgnoreCase("Team")) {
        WarpManager.TeleportToWarpPoint(p, "Team");
      }
      if (args[0].equalsIgnoreCase("SkyBlock")) {
        WarpManager.TeleportToWarpPoint(p, "SkyBlock");
      }
      if (args[0].equalsIgnoreCase("Leben")) {
        WarpManager.TeleportToWarpPoint(p, "Leben");
      }
      if (args[0].equalsIgnoreCase("PixelGun")) {
        WarpManager.TeleportToWarpPoint(p, "PixelGun");
      }
      if (args[0].equalsIgnoreCase("Cores")) {
        WarpManager.TeleportToWarpPoint(p, "Cores");
      }
      if (args[0].equalsIgnoreCase("1VS1")) {
        WarpManager.TeleportToWarpPoint(p, "1VS1");
      }
      if (args[0].equalsIgnoreCase("Lobby")) {
        WarpManager.TeleportToWarpPoint(p, "Lobby");
      }
      if (args[0].equalsIgnoreCase("BedWars")) {
        WarpManager.TeleportToWarpPoint(p, "BedWars");
      }
      if (args[0].equalsIgnoreCase("EnderGames")) {
        WarpManager.TeleportToWarpPoint(p, "EnderGames");
      }
      if (args[0].equalsIgnoreCase("SkyWars")) {
        WarpManager.TeleportToWarpPoint(p, "SkyWars");
      }
      if (args[0].equalsIgnoreCase("Ragemode")) {
        WarpManager.TeleportToWarpPoint(p, "Ragemode");
      }
      if (args[0].equalsIgnoreCase("PvP")) {
        WarpManager.TeleportToWarpPoint(p, "PvP");
      }
      if (args[0].equalsIgnoreCase("TTT")) {
        WarpManager.TeleportToWarpPoint(p, "TTT");
      }
    }
    if ((args.length == 2) && 
      (p.isOp()))
    {
      if (args[0].equals("set"))
      {
        if (args[1].equalsIgnoreCase("Team"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "Team");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("SkyBlock"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "SkyBlock");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("Leben"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "Leben");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("PixelGun"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "PixelGun");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("Cores"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "Cores");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("1VS1"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "1VS1");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("Lobby"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "Lobby");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("BedWars"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "BedWars");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("EnderGames"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "EnderGames");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("SkyWars"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "SkyWars");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("Ragemode"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "Ragemode");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("PvP"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "PvP");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
        if (args[1].equalsIgnoreCase("TTT"))
        {
          try
          {
            WarpManager.setToWarpPoint(p, "TTT");
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          p.sendMessage(Main.getLobby().Prefix + "§fDu Hast erfolgreich den Warp-Point gesetzt!");
        }
      }
      try
      {
        WarpManager.saveWarpFile();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  return true;
}
}