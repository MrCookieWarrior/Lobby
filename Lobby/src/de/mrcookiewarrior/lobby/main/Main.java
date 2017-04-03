/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.main;

import de.mrcookiewarrior.lobby.commands.CMD_Ban;
import de.mrcookiewarrior.lobby.commands.CMD_Check;
import de.mrcookiewarrior.lobby.commands.CMD_Kick;
import de.mrcookiewarrior.lobby.commands.CMD_Mute;
import de.mrcookiewarrior.lobby.commands.CMD_Unban;
import de.mrcookiewarrior.lobby.commands.CMD_Unmute;
import de.mrcookiewarrior.lobby.listener.BlockListener;
import de.mrcookiewarrior.lobby.listener.ChatListener;
import de.mrcookiewarrior.lobby.listener.MOTD_Listener;
import de.mrcookiewarrior.lobby.listener.PlayerListener;
import de.mrcookiewarrior.lobby.manager.MySQL;
import de.mrcookiewarrior.lobby.manager.ScoreboardFileManager;
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
        ScoreboardFileManager.createScoreboardFile();
	ScoreboardFileManager.addDefaults();
        if (!new File(getDataFolder(), "config.yml").exists()) {
        saveResource("config.yml", true);
    }
        MySQL.readMySQL();
        MySQL.setStandardMySQL();
        MySQL.connect();
        MySQL.createTableBanSystem();
        MySQL.createTableMuteSystem();
        registerEvents();
        registerCommands();
        pluginMessage();
    }
    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new MOTD_Listener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new BlockListener(), this);
    }
    public void registerCommands() {
        this.getCommand("ban").setExecutor(new CMD_Ban());
        this.getCommand("mute").setExecutor(new CMD_Mute());
        this.getCommand("check").setExecutor(new CMD_Check());
        this.getCommand("unban").setExecutor(new CMD_Unban());
        this.getCommand("unmute").setExecutor(new CMD_Unmute());
        this.getCommand("kick").setExecutor(new CMD_Kick());
    }
    @Override
    public void onDisable() {
        pluginMessage();
    }
    public void pluginMessage() {
        Bukkit.getConsoleSender().sendMessage("§l");
        Bukkit.getConsoleSender().sendMessage("§9---------- §3LobbySystem §9----------");
        Bukkit.getConsoleSender().sendMessage("§l ");
        Bukkit.getConsoleSender().sendMessage("§7Version: §e" + Main.Instance.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§7TeamSpeak: §eCeriox.de");
        Bukkit.getConsoleSender().sendMessage("§7YouTube: §eBungeeDev");
        Bukkit.getConsoleSender().sendMessage("§7Website: §ewww.ceriox.de");
        Bukkit.getConsoleSender().sendMessage("§7Skype: §eSeelenfresser8");
        Bukkit.getConsoleSender().sendMessage("§7Minecraft-Name §eBungeeDev");
        Bukkit.getConsoleSender().sendMessage("§9----------------------------------");
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
    public String LevelName = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Lobby.LevelName"));
    public String ServerName = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Lobby.ServerName"));
    public String Forum = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Lobby.Forum"));
    public String TeamSpeak = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Lobby.TeamSpeak"));
    public boolean BungeeCord = getConfig().getBoolean("Lobby.BungeeCord");
    public int MaxPlayers = getConfig().getInt("Lobby.MaxPlayer");
    public boolean AllowFood = getConfig().getBoolean("Lobby.AllowFood");
    public boolean AllowServerChat = getConfig().getBoolean("Lobby.AllowServerChat");
    public boolean AllowWeatherChange = getConfig().getBoolean("Lobby.AllowWeatherChange");
    public boolean AllowMobSpawning = getConfig().getBoolean("Lobby.AllowMobSpawming");
    public boolean AllowPremiumChat = getConfig().getBoolean("Lobby.AllowPremiumChat");
    public boolean AllowBlockBreak = getConfig().getBoolean("Lobby.AllowBlockBreak");
    public boolean AllowBlockPlace = getConfig().getBoolean("Lobby.AllowBlockPlace");
    public String Owner = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Owner"));
    public String Admin = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Admin"));
    public String SrDev = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrDeveloper"));
    public String Dev = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Developer"));
    public String SrMod = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrModerator"));
    public String Mod = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Moderator"));
    public String SrSupp = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrSupporter"));
    public String Supp = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Supporter"));
    public String SrBuilder = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrBuilder"));
    public String Builder = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Builder"));
    public String YouTuber = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.YouTuber"));
    public String Premium = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Premium"));
    public String Spieler = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Player"));
}