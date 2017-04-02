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
 * @author DieSeNse14
 */
public class CMD_Unmute implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if(cmd.getName().equalsIgnoreCase("unmute")) {
            if(sender.hasPermission("lobby.unmute") || sender.hasPermission("lobby.*")) {
                if(args.length == 1) {
                    String playername = args[0];
                    if(!MuteManager.isMuted(getUUID(playername))) {
                        sender.sendMessage(Main.getLobby().Prefix + "§cDer Spieler ist nicht gemutet!");
                        return true;
                    }
                    MuteManager.unmute(getUUID(playername));
                    sender.sendMessage(Main.getLobby().Prefix + "§7Du hast §e" + playername + " §7vom Chat entbannt!");
                    return true;
                }
                sender.sendMessage(Main.getLobby().Prefix + "§3Use; §7/unmute <Player>");
                return true;
            }
            sender.sendMessage(Main.getLobby().Prefix + Main.getLobby().NoPermCMD);
            return true;
        }
        return true;
    }
    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }
}