/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.commands;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.manager.BanManager;
import de.mrcookiewarrior.lobby.manager.MuteManager;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author BungeeDev
 */
public class CMD_Check implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if(cmd.getName().equalsIgnoreCase("check")) {
            if(sender.hasPermission("lobby.check") || sender.hasPermission("lobby.*")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("list")) {
                        List<String> list = BanManager.getBannedPlayers();
                        if(list.size() == 0) {
                            sender.sendMessage(Main.getLobby().Prefix + "§cEs sind keine Spieler gebannt!");
                            return true;
                        }
                        for(String AllBanned : BanManager.getBannedPlayers()) {
                            sender.sendMessage("§l");
                            sender.sendMessage("§7---------- §6§lBan-Liste §7----------");
                            sender.sendMessage("§l ");
                            sender.sendMessage("§e" + AllBanned + " §7Grund §r(" + BanManager.getReason(getUUID(AllBanned)) + "§7)");
                        }
                        return true;
                    }
                    String playername = args[0];
                    sender.sendMessage("§l");
                    sender.sendMessage("§7---------- §6§lBan-Infos §7----------");
                    sender.sendMessage("§l ");
                    sender.sendMessage("§eGebannt: " + (BanManager.isBanned(getUUID(playername)) ? "§aJa" : "§cNein"));
                    sender.sendMessage("§eGemutet: " + (MuteManager.isMuted(getUUID(playername)) ? "§aJa" : "§cNein"));
                    if (MuteManager.isMuted(getUUID(playername))) {
                        sender.sendMessage("§eMute-Grund: §a" + MuteManager.getReason(getUUID(playername)));
                        sender.sendMessage("§eMute-Dauer: §a" + MuteManager.getRemainingTime(getUUID(playername)));
                    }
                    if(BanManager.isBanned(getUUID(playername))) {
                        sender.sendMessage("§eBan-Grund: §a" + BanManager.getReason(getUUID(playername)));
                        sender.sendMessage("§eBan-Dauer: §a" + BanManager.getRemainingTime(getUUID(playername)));
                    }
                    return true;
                }
                sender.sendMessage(Main.getLobby().Prefix + "§3Use: §7/check [list] or [Player]");
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