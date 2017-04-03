/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.listener;

import de.mrcookiewarrior.lobby.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 *
 * @author BungeeDev
 */
public class BlockListener implements Listener {
    
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(Main.getLobby().BungeeCord == true && Main.getLobby().AllowBlockBreak == false) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.getLobby().NoPermBuild);
        } else if(Main.getLobby().BungeeCord == false && Main.getLobby().AllowBlockBreak == false) {
            Player p = e.getPlayer();
            if(p.getWorld().getName().contains(Main.getLobby().LevelName)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(Main.getLobby().NoPermBuild);
            } else {
                e.setCancelled(false);
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(Main.getLobby().BungeeCord == true && Main.getLobby().AllowBlockPlace == false) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.getLobby().NoPermBuild);
        } else if(Main.getLobby().BungeeCord == false && Main.getLobby().AllowBlockPlace == false) {
            Player p = e.getPlayer();
            if(p.getWorld().getName().contains(Main.getLobby().LevelName)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(Main.getLobby().NoPermBuild);
            } else {
                e.setCancelled(false);
            }
        }
    }
}