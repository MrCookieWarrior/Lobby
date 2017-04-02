/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.commands;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.manager.BanManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author BungeeDev
 */
public class CMD_Ban implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ban")) {
            if(sender.hasPermission("lobby.ban") || sender.hasPermission("lobby.*")) {
                if(args.length == 2) {
                    String playername = args[0];
                    if(BanManager.isBanned(getUUID(playername))) {
                        sender.sendMessage(Main.getLobby().Prefix + "§cDieser Spieler ist bereits gebannt!");
                        return true;
                    }
                    String reason = "";
                    for(int i = 1; i < args.length; i++) {
                        reason = reason + args[i] + " ";
                    }
                    BanManager.ban(getUUID(playername), playername, reason, -1);
                    sender.sendMessage(Main.getLobby().Prefix + "§7Du hast §e" + playername + " §7erfolgreich vom Server gebannt!");
                    return true;
                } else {
                    sender.sendMessage(Main.getLobby().Prefix + "§3Use: §7/ban <Player> <Reason>");
                    return true;
                }
            } else {
                sender.sendMessage(Main.getLobby().Prefix + Main.getLobby().NoPermCMD);
            }
        }
        return true;
    }
    private String getUUID(String playername) {
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }
}