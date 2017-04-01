/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.BungeeDev.Lobby.Main;

import de.mrcookiewarrior.lobby.listener.MOTD_Listener;
import de.mrcookiewarrior.lobby.listener.PlayerListener;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author BungeeDev
 */
public class Main extends JavaPlugin {
    
    public static Main Instance;
    
    @Override
    public void onEnable() {
        Instance = this;
        if (!new File(getDataFolder(), "config.yml").exists()) {
      saveResource("config.yml", true);
    }
    }
    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new MOTD_Listener(), this);
    }
    @Override
    public void onDisable() {
        
    }
    public static Main getLobby() {
        return Instance;
    }
    public String Prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Lobby.Prefix"));
    public boolean AllowJoinMessage = getConfig().getBoolean("Lobby.AllowJoinMessage");
    public boolean AllowQuitMessage = getConfig().getBoolean("Lobby.AllowQuitMessage");
    public String JoinMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.JoinMessage"));
    public String QuitMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.QuitMessage"));
    public String MOTDHeader = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MOTD.Header"));
    public String MOTDFooter = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MOTD.Footer"));
    public String NoPermCMD = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.NoPermCommand"));
    public String NoPermBuild = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.NoPermBuild"));
    public String TitleHeader = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Title.Header"));
    public String TitleFooter = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Title.Footer"));
    public String TabHeader = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Tablist.Header"));
    public String TabFooter = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Tablist.Footer"));
    public int MaxPlayers = getConfig().getInt("Lobby.MaxPlayer");
    public boolean AllowFood = getConfig().getBoolean("Lobby.AllowFood");
    public boolean AllowServerChat = getConfig().getBoolean("Lobby.AllowServerChat");
    public boolean AllowWeatherChange = getConfig().getBoolean("Lobby.AllowWeatherChange");
    public boolean AllowMobSpawning = getConfig().getBoolean("Lobby.AllowMobSpawming");
    public boolean AllowPremiumChat = getConfig().getBoolean("Lobby.AllowPremiumChat");
}