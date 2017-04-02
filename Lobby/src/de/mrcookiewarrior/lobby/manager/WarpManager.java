/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.manager;

import de.mrcookiewarrior.lobby.main.Main;
import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 *
 * @author DieSeNse14
 */
public class WarpManager {
    
    public static File file = new File(Main.getLobby().getDataFolder().getPath(), "Warps.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    
    public static void setToWarpPoint(Player p, String WarpName) {
        String path = "LobbySystem." + WarpName + ".";
        String welt = p.getWorld().getName();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        float yaw = p.getLocation().getYaw();
        float pitch = p.getLocation().getPitch();

        cfg.set(path + "Welt", welt);
        cfg.set(path + "X", Double.valueOf(x));
        cfg.set(path + "Y", Double.valueOf(y));
        cfg.set(path + "Z", Double.valueOf(z));
        cfg.set(path + "Yaw", Float.valueOf(yaw));
        cfg.set(path + "Pitch", Float.valueOf(pitch));
        cfg.set(path + "SetFrom", p.getName() + " : " + p.getUniqueId() + " : " + p.getAddress());
        cfg.options().header("LobbySystem LocationManager");
        cfg.options().copyHeader(true);
        try {
            cfg.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void delWarpPoint(Player p, String name) {
        if(file.exists()) {
        String path = "LobbySystem." + name;
        if(cfg.getString("LobbySystem." + name) != null) {
        cfg.set("Bedwars_ClazeGames." + name, null);
        p.sendMessage(Main.getLobby().Prefix + "§aDer Warp-Punkt §e" + name + " §awurde §centfernt");
            try {
                cfg.save(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            p.sendMessage(Main.getLobby().Prefix + "§cDer Warp-Punkt §e" + name + " §cexistiert nicht");
        }
        }
    }
    public static void TeleportToWarpPoint(Player p, String warpname) {
        String path = "LobbySystem." + warpname + ".";
        String welt = cfg.getString(path + "Welt");
        double x = cfg.getDouble(path + "X");
        double y = cfg.getDouble(path + "Y");
        double z = cfg.getDouble(path + "Z");
        float yaw = (float)cfg.getDouble(path + "Yaw");
        float pitch = (float)cfg.getDouble(path + "Pitch");
    
        Location loc = new Location(Bukkit.getWorld(welt), x, y, z, yaw, pitch);
        p.teleport(loc);
    }
    public static boolean existWarpPoint(String warpname) {
        if(cfg.getString(warpname) != null) {
            return false;
        }
        return true;
    }
    public static void saveWarpFile() {
        try {
            cfg.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}