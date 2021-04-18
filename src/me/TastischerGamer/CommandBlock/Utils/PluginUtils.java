package me.TastischerGamer.CommandBlock.Utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.TastischerGamer.CommandBlock.main.CommandBlockPlugin;

public class PluginUtils extends ConfigUtil {
	
	public static String getPrefix() {
		
		String prefix = "";
		
		prefix = ChatColor.translateAlternateColorCodes('&', getStringfromConfig("commandblock.prefix"));
		
		return prefix;
		
	}
	
	public static String getNoPermission() {
		
		String noPerms = "";
		
		noPerms = ChatColor.translateAlternateColorCodes('&', getStringfromConfig("commandblock.noPerm"));
		
		return noPerms;
		
	}
	
	public static String getStringfromConfig(String Path) {
		
		String Value = "";
		
		Value = ChatColor.translateAlternateColorCodes('&', CommandBlockPlugin.getInstance().getConfig().getString(Path));
		
		return Value;
		
	}
	
	public static boolean getBooleanfromConfig(String Path) {
		
		boolean Value = false;
		
		Value = CommandBlockPlugin.getInstance().getConfig().getBoolean(Path);
		
		return Value;
		
	}
	
	public static String getCommandPermission(String command) {
		
		String permission = "";
		
		if(!permissionconfig.isSet("permissions.command." + command + ".perm")) {
			
			Bukkit.getConsoleSender().sendMessage("§cDie Permission für den Command §6" + command + " §ckonnte nicht gefunden werden!");
			Bukkit.getConsoleSender().sendMessage("§cDie Permission wurde zu: §6system." + command + " §cgesetzt!");
			savePermissionConfig("permissions.command." + command + ".perm", "system." + command);
			
		}
		
		permission = permissionconfig.getString("permissions.command." + command + ".perm");
		
		return permission;
		
	}
	
	public static List<String> getBlockedCommands() {
		
		List<String> blockedcommands;
		
		blockedcommands = BlockedCommandsConfig.getStringList("BlockedCommands");
		
		return blockedcommands; 
		
	}
	
	public static boolean isNotificationToggled(Player p) {
		
		boolean Value = getBooleanfromConfig("commandblock.player." + p.getName() + ".notification");
		
		return Value;
		
	}

}
