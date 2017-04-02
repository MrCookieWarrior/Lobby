/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mrcookiewarrior.lobby.manager;

import de.mrcookiewarrior.lobby.main.Main;
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
            Team srdeveloper = board.registerNewTeam("ccc");
            Team developer = board.registerNewTeam("ddd");
            Team srmoderator = board.registerNewTeam("eee");
            Team moderator = board.registerNewTeam("fff");
            Team srsupporter = board.registerNewTeam("ggg");
            Team supporter = board.registerNewTeam("hhh");
            Team srbuilder = board.registerNewTeam("iii");
            Team builder = board.registerNewTeam("jjj");
            Team youtuber = board.registerNewTeam("kkk");
            Team premium = board.registerNewTeam("lll");
            Team spieler = board.registerNewTeam("mmm");
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(all).inGroup("Owner")) {
				owner.setPrefix(Main.getLobby().Owner);
				owner.addPlayer(all);				
			} else if (PermissionsEx.getUser(all).inGroup("Admin")) {
				admin.setPrefix(Main.getLobby().Admin);
				admin.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrDeveloper")) {
				srdeveloper.setPrefix(Main.getLobby().SrDev);
				srdeveloper.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Developer")) {
				developer.setPrefix(Main.getLobby().Dev);
				developer.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrModerator")) {
				srmoderator.setPrefix(Main.getLobby().SrMod);
				srmoderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Moderator")) {
				moderator.setPrefix(Main.getLobby().Mod);
				moderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrSupporter")) {
				srsupporter.setPrefix(Main.getLobby().SrSupp);
				srsupporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Supporter")) {
				supporter.setPrefix(Main.getLobby().Supp);
				supporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrBuilder")) {
				srbuilder.setPrefix(Main.getLobby().SrBuilder);
				srbuilder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Builder")) {
				builder.setPrefix(Main.getLobby().Builder);
				builder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("YouTuber")) {
				youtuber.setPrefix(Main.getLobby().YouTuber);
				youtuber.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Premium")) {
				premium.setPrefix(Main.getLobby().Premium);
				premium.addPlayer(all);
			}  else {
				spieler.setPrefix(Main.getLobby().Spieler);
				spieler.addPlayer(all);
			}
    }
	}
	public static void setScoreNull(Player p) {
        p.setScoreboard(null);
        
            Team owner = board.registerNewTeam("aaa");
            Team admin = board.registerNewTeam("bbb");
            Team srdeveloper = board.registerNewTeam("ccc");
            Team developer = board.registerNewTeam("ddd");
            Team srmoderator = board.registerNewTeam("eee");
            Team moderator = board.registerNewTeam("fff");
            Team srsupporter = board.registerNewTeam("ggg");
            Team supporter = board.registerNewTeam("hhh");
            Team srbuilder = board.registerNewTeam("iii");
            Team builder = board.registerNewTeam("jjj");
            Team youtuber = board.registerNewTeam("kkk");
            Team premium = board.registerNewTeam("lll");
            Team spieler = board.registerNewTeam("mmm");
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(all).inGroup("Owner")) {
				owner.setPrefix(Main.getLobby().Owner);
				owner.addPlayer(all);				
			} else if (PermissionsEx.getUser(all).inGroup("Admin")) {
				admin.setPrefix(Main.getLobby().Admin);
				admin.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrDeveloper")) {
				srdeveloper.setPrefix(Main.getLobby().SrDev);
				srdeveloper.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Developer")) {
				developer.setPrefix(Main.getLobby().Dev);
				developer.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrModerator")) {
				srmoderator.setPrefix(Main.getLobby().SrMod);
				srmoderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Moderator")) {
				moderator.setPrefix(Main.getLobby().Mod);
				moderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrSupporter")) {
				srsupporter.setPrefix(Main.getLobby().SrSupp);
				srsupporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Supporter")) {
				supporter.setPrefix(Main.getLobby().Supp);
				supporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrBuilder")) {
				srbuilder.setPrefix(Main.getLobby().SrBuilder);
				srbuilder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Builder")) {
				builder.setPrefix(Main.getLobby().Builder);
				builder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("YouTuber")) {
				youtuber.setPrefix(Main.getLobby().YouTuber);
				youtuber.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Premium")) {
				premium.setPrefix(Main.getLobby().Premium);
				premium.addPlayer(all);
			}  else {
				spieler.setPrefix(Main.getLobby().Spieler);
				spieler.addPlayer(all);
			}
    }
	}
	
}
