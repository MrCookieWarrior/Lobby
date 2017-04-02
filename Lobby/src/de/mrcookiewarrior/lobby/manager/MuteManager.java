/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;

/**
 *
 * @author BungeeDev
 */
public class MuteManager {
    public static void Mute(String uuid, String playername, String reason, long seconds) {
        long end = 0L;
        if(seconds == -1L) {
            end = 1L;
        } else {
            long current = System.currentTimeMillis();
            long millis = seconds * 1000L;
            end = current + millis;
        }
        MySQL.update("INSERT INTO MutePlayers (Spielername, UUID, Ende, Grund) VALUES ('" + playername + "','" + uuid + "','" + end + "','" + reason + "')");
        Bukkit.getPlayer(playername);
    }
    public static void unmute(String uuid) {
        MySQL.update("DELETE FROM MutePlayer WHERE UUID = '" + uuid + "'");
    }
    public static boolean isMuted(String uuid) {
        ResultSet rs = MySQL.getResult("SELECT Ende FROM MutePlayers WHERE UUID = '" + uuid + "'");
        try {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String getReason(String uuid) {
        ResultSet rs = MySQL.getResult("SELECT * FROM MutePlayers WHERE UUID='" + uuid + "'");
        try {
            if (rs.next()) {
        return rs.getString("Grund");
      }
    } catch (SQLException e) {
        e.printStackTrace();
        }
        return "";
    }
    public static Long getEnd(String uuid) {
        ResultSet rs = MySQL.getResult("SELECT * FROM MutePlayers WHERE UUID='" + uuid + "'");
        try {
            if (rs.next()) {
                return Long.valueOf(rs.getLong("Ende"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<String> getMutePlayers() {
        List<String> list = new ArrayList();
        ResultSet rs = MySQL.getResult("SELECT * FROM MutePlayers");
        try {
            while (rs.next()) {
            list.add(rs.getString("Spielername"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static String getRemainingTime(String uuid) {
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
        while (millis > 1000L) {
            millis -= 1000L;
            seconds += 1L;
        }
        while (seconds > 60L) {
            seconds -= 60L;
            minutes += 1L;
        }
        while (minutes > 60L) {
            millis -= 60L;
            hours += 1L;
        }
        while (hours > 24L) {
            millis -= 24L;
            days += 1L;
        }
        while (days > 7L) {
            millis -= 7L;
            weeks += 1L;
        }
    return "§e" + weeks + " §Woche(n) " + days + " Tage(n) " + hours + " Stunde(n) " + minutes + " Minute(n) " + seconds + " Sekunde(n)";
    }
}