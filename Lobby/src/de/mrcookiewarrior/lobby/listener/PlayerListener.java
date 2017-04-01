/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.listener;

import de.BungeeDev.Lobby.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author DieSeNse14
 */
public class PlayerListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
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