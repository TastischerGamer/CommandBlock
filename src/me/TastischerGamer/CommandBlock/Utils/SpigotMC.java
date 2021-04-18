package me.TastischerGamer.CommandBlock.Utils;

import org.bukkit.Bukkit;

public class SpigotMC {
	
	private static String spigoturl = "https://www.spigotmc.org/resources/commandblock-plugin.72139/";
	
	public static void sendPluginStartMessage(String Pluginname, String PluginVersion) {
		
		Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Bukkit.getConsoleSender().sendMessage("§6" + Pluginname + ":");
		Bukkit.getConsoleSender().sendMessage(" §8- §7Coder: §6TastischerGamer");
		Bukkit.getConsoleSender().sendMessage(" §8- §7Version: §6" + PluginVersion);
		Bukkit.getConsoleSender().sendMessage(" §8- §7Running on: §6" + Bukkit.getBukkitVersion());
		Bukkit.getConsoleSender().sendMessage(" §8- §7SpigotURL: §6" + spigoturl);
		Bukkit.getConsoleSender().sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		if(PluginVersion.contains("BETA")) {
			
			Bukkit.getConsoleSender().sendMessage("§cThis Plugin is in Beta and it may has some Bugs!");
			
		}else if(PluginVersion.contains("ALPHA")) {
			
			Bukkit.getConsoleSender().sendMessage("§cThis Plugin is in Alpha and it may has some Bugs!");
			
		}
			
	}

}
