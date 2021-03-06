/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.listener;

import de.mrcookiewarrior.lobby.main.Main;
import de.mrcookiewarrior.lobby.manager.MuteManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 *
 * @author DieSeNse14
 */
public class ChatListener implements Listener {
    
    @EventHandler
    public void onPrefix(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        
        if(PermissionsEx.getUser(p).inGroup("Owner")) {
            e.setFormat(Main.getLobby().Owner + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Admin")) {
            e.setFormat(Main.getLobby().Admin + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrDeveloper")) {
            e.setFormat(Main.getLobby().SrDev + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Developer")) {
            e.setFormat(Main.getLobby().Dev + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrModerator")) {
            e.setFormat(Main.getLobby().SrMod + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Moderator")) {
            e.setFormat(Main.getLobby().Mod + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrSupporter")) {
            e.setFormat(Main.getLobby().SrSupp + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Supporter")) {
            e.setFormat(Main.getLobby().Supp + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrBuilder")) {
            e.setFormat(Main.getLobby().SrBuilder + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Builder")) {
            e.setFormat(Main.getLobby().Builder + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("YouTuber")) {
            e.setFormat(Main.getLobby().YouTuber + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Premium")) {
            e.setFormat(Main.getLobby().Premium + p.getDisplayName() + " §7» " + msg);
        } else {
            e.setFormat(Main.getLobby().Spieler + p.getDisplayName() + " §7» " + msg);
        }
    }
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
    @EventHandler
    public void onServerChat(AsyncPlayerChatEvent e) {
        if((Main.getLobby().BungeeCord) && (Main.getLobby().AllowServerChat)) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.getLobby().Prefix + "§cDer ServerChat wurde auf dem Server deativiert!");
        } else if((!Main.getLobby().BungeeCord) && (Main.getLobby().AllowServerChat)) {
            Player p = e.getPlayer();
            if(p.getWorld().getName().contains(Main.getLobby().LevelName)) {
                e.setCancelled(true);
                p.sendMessage(Main.getLobby().Prefix + "§cDer Chat wurde auf dieser Welt ausgeschaltet!");
            }
        } else {
            e.setCancelled(false);
        }
    }
}