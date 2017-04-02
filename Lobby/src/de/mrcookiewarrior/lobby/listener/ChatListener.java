/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.listener;

import de.mrcookiewarrior.lobby.manager.MuteManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 *
 * @author DieSeNse14
 */
public class ChatListener implements Listener {
    
    @EventHandler
    public void onMute(AsyncPlayerChatEvent e) {
        if(MuteManager.isMuted(e.getPlayer().getUniqueId().toString())) {
            long current = System.currentTimeMillis();
            long end = MuteManager.getEnd(e.getPlayer().getUniqueId().toString());
            if(((current < end ? 1 : 0) | (end == -1L ? 1 : 0)) != 0) {
                e.setCancelled(true);
                e.getPlayer().sendMessage("§e---------- Mute-Infos ----------");
                e.getPlayer().sendMessage("§eDu bist im Chat gebannt!");
                e.getPlayer().sendMessage("§eGrund: §a" + MuteManager.getReason(e.getPlayer().getUniqueId().toString()));
                e.getPlayer().sendMessage("§eDauer: §a" + MuteManager.getRemainingTime(e.getPlayer().getUniqueId().toString()));
                e.getPlayer().sendMessage("§e--------------------------------");
        }
        }
    }    
}