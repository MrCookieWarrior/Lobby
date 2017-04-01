/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author DieSeNse14
 */
public class Main extends JavaPlugin {
    
    public static Main Instance;
    
    @Override
    public void onEnable() {
        Instance = this;
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
}