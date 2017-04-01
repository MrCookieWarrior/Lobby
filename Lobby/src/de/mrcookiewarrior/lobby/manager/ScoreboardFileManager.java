package de.mrcookiewarrior.lobby.manager;

import de.BungeeDev.Lobby.Main.Main;
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ScoreboardFileManager {
	
	public static File setting_file;
	public static FileConfiguration conf;
	
	public static void createScoreboardFile() {
		setting_file = new File("plugins//EasyServerManager", "Scoreboard.yml");
		conf = YamlConfiguration.loadConfiguration(setting_file);
	}
	public static void saveScoreboardFile() {
		try {
			conf.save(setting_file);
		} catch (IOException ex) {
			Bukkit.getConsoleSender().sendMessage(Main.getLobby().Prefix + "§4ERROR: §cThe class ScoreboardFileManager.java could not write in config.yml! Please contact the Developer BungeeDev!");
			ex.printStackTrace();
		}
	}
	public static void addDefaults() {
		addEntryString("Title", "&6Dein Server");
		addEntryString("Twelve", "&3Zeile 12");
		addEntryString("Eleven", "Zeile 11");
		addEntryString("Ten", "&dZeile 10");
		addEntryString("Nine", "&aZeile 9");
		addEntryString("Eight", "&bZeile 8");
		addEntryString("Seven", "&fZeile 7");
		addEntryString("Six", "&9Zeile 6");
		addEntryString("Five", "&aZeile 5");
		addEntryString("Four", "&lZeile 4");
		addEntryString("Three", "&eZeile 3");
		addEntryString("Two", "&1Zeile 2");
		addEntryString("One", "&3Zeile 1");
	}
	public static void addEntryString(String EntryName, String Text) {
		if(conf.get("Scoreboard." + EntryName) == null) {
			conf.set("Scoreboard." + EntryName, Text);
			try {
				conf.save(setting_file);
			} catch (IOException e) {
				Bukkit.getConsoleSender().sendMessage(Main.getLobby().Prefix + "§4ERROR: §cThe class ScoreboardFileManager.java could not write in config.yml! Please contact the Developer BungeeDev!");
				e.printStackTrace();				
			}
		}
	}

	  
	  public static void addEntryDouble(String EntryName, Double Double)
	  {
	    if (conf.get("Config." + EntryName) == null)
	    {
	      conf.set("Config." + EntryName, Double);
	      try
	      {
	        conf.save(setting_file);
	      }
	      catch (IOException e)
	      {
	        Bukkit.getConsoleSender().sendMessage(Main.getLobby().Prefix + "&4ERROR: &cThe class ScoreboardFileManager.java could not write something in config.yml! Please contact the Developer BungeeDev and send him the follow error code!");
	        e.printStackTrace();
	      }
	    }
	  }
	  
	  public static String getScoreTitle()
	  {
	    String final_text = conf.get("Scoreboard.Title").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreTwelve()
	  {
	    String final_text = conf.get("Scoreboard.Twelve").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreEleven()
	  {
	    String final_text = conf.get("Scoreboard.Eleven").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreTen()
	  {
	    String final_text = conf.get("Scoreboard.Ten").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreNine()
	  {
	    String final_text = conf.get("Scoreboard.Nine").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreEight()
	  {
	    String final_text = conf.get("Scoreboard.Eight").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreSeven()
	  {
	    String final_text = conf.get("Scoreboard.Seven").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  
	  public static String getScoreSix()
	  {
	    String final_text = conf.get("Scoreboard.Six").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  public static String getScoreFive()
	  {
	    String final_text = conf.get("Scoreboard.Five").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  public static String getScoreFour()
	  {
	    String final_text = conf.get("Scoreboard.Four").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  public static String getScoreThree()
	  {
	    String final_text = conf.get("Scoreboard.Three").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  public static String getScoreTwo()
	  {
	    String final_text = conf.get("Scoreboard.Two").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	  public static String getScoreOne()
	  {
	    String final_text = conf.get("Scoreboard.One").toString();
	    final_text = ChatColor.translateAlternateColorCodes('&', final_text);
	    return final_text;
	  }
	}