package de.mrcookiewarrior.lobby.manager;

import de.BungeeDev.Lobby.Main.Main;
import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

public class sendJoinTabManager {
	  public static int headernumber = 1;
	  
	  public static void createTablist(String Header, String Footer)
	  {
	    for (Player all : Bukkit.getOnlinePlayers())
	    {
	      CraftPlayer player = (CraftPlayer)all;
	      
	      PacketPlayOutPlayerListHeaderFooter tab = new PacketPlayOutPlayerListHeaderFooter(IChatBaseComponent.ChatSerializer.a(JSONTEXT(Header)));
	      try
	      {
	        Field field = tab.getClass().getDeclaredField("b");
	        field.setAccessible(true);
	        field.set(tab, IChatBaseComponent.ChatSerializer.a(JSONTEXT(Footer)));
	      }
	      catch (Exception Tabexception)
	      {
	        System.out.println("FEHLER bei CREATETABLIST(STRING, STRING) EXCEPTION!!!");
	      }
	      player.getHandle().playerConnection.sendPacket(tab);
	    }
	  }
	  
	  public static void createNormalTabList()
	  {
	    String header = Main.getLobby().TabHeader;
	    String footer = Main.getLobby().TabFooter;
	    
	    createTablist(header + "\n", "\n" + footer);
	  }
	  
	  public static String JSONTEXT(String text)
	  {
	    return "{\"text\":\"" + text + "\"}";
	  }
}
