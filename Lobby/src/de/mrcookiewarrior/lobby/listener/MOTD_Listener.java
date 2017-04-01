/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.listener;

import de.BungeeDev.Lobby.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 *
 * @author DieSeNse14
 */
public class MOTD_Listener implements Listener {
 
    @EventHandler
    public void onMOTD(ServerListPingEvent e) {
        e.setMaxPlayers(Main.getLobby().MaxPlayers);
        e.setMotd(Main.getLobby().MOTDHeader + "\n" + Main.getLobby().MOTDFooter);
    }    
}