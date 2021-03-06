/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.listener;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.api.ItemAPI;
import de.mrcookiewarrior.lobby.api.TitleAPI;
import de.mrcookiewarrior.lobby.manager.BanManager;
import de.mrcookiewarrior.lobby.manager.ScoreboardManager;
import de.mrcookiewarrior.lobby.manager.sendJoinTabManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author BungeeDev
 */
public class PlayerListener implements Listener {
    
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if(BanManager.isBanned(e.getPlayer().getUniqueId().toString())) {
            long current = System.currentTimeMillis();
            long end = BanManager.getEnd(e.getPlayer().getUniqueId().toString()).longValue();
            if(((current < end ? 1 : 0) | (end == -1L ? 1 : 0)) != 0) {
                if (Main.getLobby().BungeeCord) {
                    e.disallow(PlayerLoginEvent.Result.KICK_BANNED, "\n" + Main.getLobby().ServerName + " §4Netzwerk" + 
                    "\n§cDu wurdest vom Netzwerk gebannt!" + 
                    "\n§4GRUND: §e" + BanManager.getReason(e.getPlayer().getUniqueId().toString()) + "\n" + 
                    "\n" + 
                    "\n§bVerbleibene Zeit: §e" + BanManager.getRemainingTime(e.getPlayer().getUniqueId().toString()) + 
                    "\n§aDu kannst im Forum ein Entbannungsantrag stellen!" + 
                    "\n§5FORUM: " + Main.getLobby().Forum);
                } else {
                    e.disallow(PlayerLoginEvent.Result.KICK_BANNED, "\n" + Main.getLobby().ServerName + " §4Server" + 
                    "\n§cDu wurdest vom Server gebannt!" + 
                    "\n§4GRUND: §e" + BanManager.getReason(e.getPlayer().getUniqueId().toString()) + "\n" + 
                    "\n" + 
                    "\n§bVerbleibene Zeit: §e" + BanManager.getRemainingTime(e.getPlayer().getUniqueId().toString()) + 
                    "\n§aDu kannst im Forum ein Entbannungsantrag stellen!" + 
                    "\n§5FORUM: " + Main.getLobby().Forum);
                }
            }
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ScoreboardManager.setJoinScoreboard(e.getPlayer());
        sendJoinTabManager.createNormalTabList();
        ItemAPI.setLobbyItem(e.getPlayer());
        TitleAPI.sendJoinTitle(e.getPlayer(), Integer.valueOf(70), Integer.valueOf(40), Integer.valueOf(50), Main.getLobby().TitleHeader, Main.getLobby().TitleFooter);
        if(Main.getLobby().AllowJoinMessage == true) {
            String join = Main.getLobby().JoinMessage;
            join = join.replaceFirst("%player%", e.getPlayer().getDisplayName());
            e.setJoinMessage(join);
        } else {
            e.setJoinMessage(null);
        }
    }    
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if(Main.getLobby().AllowQuitMessage == true) {
            String quit = Main.getLobby().QuitMessage;
            quit = quit.replaceFirst("%player%", e.getPlayer().getDisplayName());
            e.setQuitMessage(quit);
        } else {
            e.setQuitMessage(null);
        }
    }
}