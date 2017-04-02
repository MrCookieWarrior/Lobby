/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.commands;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.manager.MuteManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author BungeeDev
 */
public class CMD_Mute implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if(cmd.getName().equalsIgnoreCase("mute")) {
            if(sender.hasPermission("lobby.mute") || sender.hasPermission("lobby.*")) {
                if(args.length == 2) {
                    String playername = args[0];
                    if(MuteManager.isMuted(getUUID(playername))) {
                        sender.sendMessage(Main.getLobby().Prefix + "§cDer Spieler ist bereits gemutet!");
                        return true;
                    }
                    String reason = "";
                    for(int i = 1; i < args.length; i++) {
                        reason = reason + args[i] + " ";
                    }
                    MuteManager.Mute(getUUID(playername), playername, reason, -1);
                    sender.sendMessage(Main.getLobby().Prefix + "§7Du hast §e" + playername + " §7vom Chat gebannt!");
                    return true;
                }
                sender.sendMessage(Main.getLobby().Prefix + "§3Use: §7/mute <Player> <Reason>");
                return true;
            }
            sender.sendMessage(Main.getLobby().Prefix + Main.getLobby().NoPermCMD);
            return true;
        }
        return true;
    }
    public String getUUID(String playernamem) {
        return Bukkit.getOfflinePlayer(playernamem).getUniqueId().toString();
    }
}