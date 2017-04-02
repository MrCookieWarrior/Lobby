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
 * @author DieSeNse14
 */
public class CMD_Unban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if(cmd.getName().equalsIgnoreCase("unban")) {
            if(sender.hasPermission("lobby.unban") || sender.hasPermission("lobby.*")) {
                if(args.length == 1) {
                    String playername = args[0];
                    if (!BanManager.isBanned(getUUID(playername))) {
                        sender.sendMessage(Main.getLobby().Prefix + "§cDer Sieler ist Nicht gebannt!");
                        return true;
                    }
                    BanManager.unban(getUUID(playername));
                    sender.sendMessage(Main.getLobby().Prefix + "§7Du hast §e" + playername + " §7vom Server entbannt!");
                    return true;
                }
                sender.sendMessage(Main.getLobby().Prefix + "§3Use: §7/unban <Player>");
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