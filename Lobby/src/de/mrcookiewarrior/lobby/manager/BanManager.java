package de.mrcookiewarrior.lobby.manager;

import de.BungeeDev.Lobby.Main.Main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BanManager
{
  public static void ban(String uuid, String playername, String reason, long seconds)
  {
    long end = 0L;
    if (seconds == -1L)
    {
      end = -1L;
    }
    else
    {
      long cureent = System.currentTimeMillis();
      long millis = seconds * 1000L;
      end = cureent + millis;
    }
    MySQL.update("INSERT INTO BannedPlayers (Spielername, UUID, Ende, Grund) VALUES ('" + playername + "','" + uuid + "','" + end + "','" + reason + "')");
    if ((Bukkit.getPlayer(playername) != null) && (Main.getLobby().BungeeCord)) {
      Bukkit.getPlayer(playername).kickPlayer("\n" + Main.getLobby().ServerName + " §4Netzwerk" + 
        "\n§cDu wurdest vom Netzwerk gebannt!" + 
        "\n§4GRUND: §e" + getReason(uuid) + "\n" + 
        "\n" + 
        "\n§bVerbleibene Zeit: §e" + getRemainingTime(uuid) + 
        "\n§aDu kannst im Forum ein Entbannungsantrag stellen!" + 
        "\n§5FORUM: " + Main.getLobby().Forum);
    } else if (Bukkit.getPlayer(playername) != null) {
      Bukkit.getPlayer(playername).kickPlayer("\n" + Main.getLobby().ServerName + " §4Server" + 
        "\n§cDu wurdest vom Server gebannt!" + 
        "\n§4GRUND: §e" + getReason(uuid) + "\n" + 
        "\n" + 
        "\n§bVerbleibene Zeit: §e" + getRemainingTime(uuid) + 
        "\n§aDu kannst im Forum ein Entbannungsantrag stellen!" + 
        "\n§5FORUM: " + Main.getLobby().Forum);
    }
  }
  
  public static void unban(String uuid)
  {
    MySQL.update("DELETE FROM BannedPlayers WHERE UUID='" + uuid + "'");
  }
  
  public static boolean isBanned(String uuid)
  {
    ResultSet rs = MySQL.getResult("SELECT Ende FROM BannedPlayers WHERE UUID='" + uuid + "'");
    try
    {
      return rs.next();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  
  public static String getReason(String uuid)
  {
    ResultSet rs = MySQL.getResult("SELECT * FROM BannedPlayers WHERE UUID='" + uuid + "'");
    try
    {
      if (rs.next()) {
        return rs.getString("Grund");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return "";
  }
  
  public static Long getEnd(String uuid)
  {
    ResultSet rs = MySQL.getResult("SELECT * FROM BannedPlayers WHERE UUID='" + uuid + "'");
    try
    {
      if (rs.next()) {
        return Long.valueOf(rs.getLong("Ende"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static List<String> getBannedPlayers()
  {
    List<String> list = new ArrayList();
    ResultSet rs = MySQL.getResult("SELECT * FROM BannedPlayers");
    try
    {
      while (rs.next()) {
        list.add(rs.getString("Spielername"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return list;
  }
  
  public static String getRemainingTime(String uuid)
  {
    long current = System.currentTimeMillis();
    long end = getEnd(uuid).longValue();
    if (end == -1L) {
      return "§4PERMAMENT";
    }
    long millis = end - current;
    
    long seconds = 0L;
    long minutes = 0L;
    long hours = 0L;
    long days = 0L;
    long weeks = 0L;
    while (millis > 1000L)
    {
      millis -= 1000L;
      seconds += 1L;
    }
    while (seconds > 60L)
    {
      seconds -= 60L;
      minutes += 1L;
    }
    while (minutes > 60L)
    {
      millis -= 60L;
      hours += 1L;
    }
    while (hours > 24L)
    {
      millis -= 24L;
      days += 1L;
    }
    while (days > 7L)
    {
      millis -= 7L;
      weeks += 1L;
    }
    return "§e" + weeks + " §Woche(n) " + days + " Tage(n) " + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
  }
}
