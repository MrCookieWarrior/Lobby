/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 *
 * @author BungeeDev
 */
public class ScoreboardManager {
    
	
	public static Scoreboard board;
	
	public static void setJoinScoreboard(Player p) {
		
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		
		Objective obj = board.registerNewObjective("test", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ScoreboardFileManager.getScoreTitle());
		
		Score twelve = obj.getScore(ScoreboardFileManager.getScoreTwelve());
		  Score eleven = obj.getScore(ScoreboardFileManager.getScoreEleven());
		  Score ten = obj.getScore(ScoreboardFileManager.getScoreTen());
		  Score nine = obj.getScore(ScoreboardFileManager.getScoreNine());
		  Score eight = obj.getScore(ScoreboardFileManager.getScoreEight());
		  Score seven = obj.getScore(ScoreboardFileManager.getScoreSeven());
		  Score six = obj.getScore(ScoreboardFileManager.getScoreSix());
		  Score five = obj.getScore(ScoreboardFileManager.getScoreFive());
		  Score four = obj.getScore(ScoreboardFileManager.getScoreFour());
		  Score three = obj.getScore(ScoreboardFileManager.getScoreThree());
		  Score two = obj.getScore(ScoreboardFileManager.getScoreTwo());
		  Score one = obj.getScore(ScoreboardFileManager.getScoreOne());

		  twelve.setScore(12);
		  eleven.setScore(11);
		  ten.setScore(10);
		  nine.setScore(9);
		  eight.setScore(8);
		  seven.setScore(7);
		  six.setScore(6);
		  five.setScore(5);
		  four.setScore(4);
		  three.setScore(3);
		  two.setScore(2);
		  one.setScore(1);
        
        p.setScoreboard(board);
        
        Team owner = board.registerNewTeam("aaa");
		Team admin = board.registerNewTeam("bbb");
		Team developer = board.registerNewTeam("ccc");
		Team srmoderator = board.registerNewTeam("ddd");
		Team moderator = board.registerNewTeam("eee");
		Team supporter = board.registerNewTeam("fff");
		Team srbuilder = board.registerNewTeam("ggg");
		Team builder = board.registerNewTeam("hhh");
		Team youtuber = board.registerNewTeam("jjj");
		Team premium = board.registerNewTeam("kkk");
		Team spieler = board.registerNewTeam("lll");
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(all).inGroup("Owner")) {
				owner.setPrefix("§4Owner §7» §4");
				owner.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("Admin")) {
				admin.setPrefix("§4Admin §7» §4");
				admin.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Developer")) {
				developer.setPrefix("§bDev §7» §b");
				developer.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrModerator")) {
				srmoderator.setPrefix("§cSrMod §7» §c");
				srmoderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Moderator")) {
				moderator.setPrefix("§cMod §7» §c");
				moderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Supporter")) {
				supporter.setPrefix("§9Supp §7» §9");
				supporter.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("SrBuilder")) {
				srbuilder.setPrefix("§eSrBuilder §7» §e");
				srbuilder.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("Builder")) {
				builder.setPrefix("§eBuilder §7» §e");
				builder.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("YouTuber")) {
				youtuber.setPrefix("§5");
				youtuber.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("Premium")) {
				premium.setPrefix("§6");
				premium.addPlayer(all);
				
			}  else {
				spieler.setPrefix("§8");
				spieler.addPlayer(all);
				
			}
    }
	}
	public static void setScoreNull(Player p) {
        p.setScoreboard(null);
        
        Team owner = board.registerNewTeam("aaa");
		Team admin = board.registerNewTeam("bbb");
		Team developer = board.registerNewTeam("ccc");
		Team srmoderator = board.registerNewTeam("ddd");
		Team moderator = board.registerNewTeam("eee");
		Team supporter = board.registerNewTeam("fff");
		Team srbuilder = board.registerNewTeam("ggg");
		Team builder = board.registerNewTeam("hhh");
		Team youtuber = board.registerNewTeam("jjj");
		Team premium = board.registerNewTeam("kkk");
		Team spieler = board.registerNewTeam("lll");
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(all).inGroup("Owner")) {
				owner.setPrefix("§4Owner §7» §4");
				owner.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("Admin")) {
				admin.setPrefix("§4Admin §7» §4");
				admin.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Developer")) {
				developer.setPrefix("§bDev §7» §b");
				developer.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrModerator")) {
				srmoderator.setPrefix("§cSrMod §7» §c");
				srmoderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Moderator")) {
				moderator.setPrefix("§cMod §7» §c");
				moderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Supporter")) {
				supporter.setPrefix("§9Supp §7» §9");
				supporter.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("SrBuilder")) {
				srbuilder.setPrefix("§eSrBuilder §7» §e");
				srbuilder.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("Builder")) {
				builder.setPrefix("§eBuilder §7» §e");
				builder.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("YouTuber")) {
				youtuber.setPrefix("§5");
				youtuber.addPlayer(all);
				
			} else if (PermissionsEx.getUser(all).inGroup("Premium")) {
				premium.setPrefix("§6");
				premium.addPlayer(all);
				
			}  else {
				spieler.setPrefix("§8");
				spieler.addPlayer(all);
				
			}
    }
	}
	
}
