/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.commands;

import de.mrcookiewarrior.lobby.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author BungeeDev
 */
public class CMD_Kick implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     
        if(cmd.getName().equalsIgnoreCase("kick")) {
            if(sender.hasPermission("lobby.kick") || sender.hasPermission("lobby.*")) {
                if(args.length >= 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        String reason = "";
                        for(int i = 1; i < args.length; i++) {
                            reason = reason + args[i] + " ";
                        }
                        sender.sendMessage(Main.getLobby().Prefix + "§eDu hast den Spieler: §a" + target.getName() + " §evom Server gekickt!");
                        target.kickPlayer(Main.getLobby().ServerName + "\n\n§bDu wurdest vom Server gekickt!\n§cGrund: §4" + reason + "\n\n§9Du wurdest vom: §8" + sender.getName() + " §9gekickt!");
                    } else {
                        sender.sendMessage(Main.getLobby().Prefix + "§cDer Spieler ist nicht Online!");
                    }
                } else {
                    sender.sendMessage("§3Use: §7/kick <Player> <Reason>");
                }
            } else {
                sender.sendMessage(Main.getLobby().Prefix + Main.getLobby().NoPermCMD);
            }
        }        
        return true;
    }   
}