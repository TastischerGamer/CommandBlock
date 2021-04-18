package me.TastischerGamer.CommandBlock.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.TastischerGamer.CommandBlock.main.CommandBlockPlugin;

public class ConfigUtil {
	
	private static File permissionfile = new File(CommandBlockPlugin.getInstance().getDataFolder() + "/Permissions.yml");
	
	public static FileConfiguration permissionconfig = YamlConfiguration.loadConfiguration(permissionfile);
	
	private static File blockedcommandsfile = new File(CommandBlockPlugin.getInstance().getDataFolder() + "/BlockedCommands.yml");
	
	public static FileConfiguration BlockedCommandsConfig = YamlConfiguration.loadConfiguration(blockedcommandsfile);
	
	public static void onConfigLoad() {
		
		CommandBlockPlugin.getInstance().getConfig().options().copyDefaults(true);
		
		CommandBlockPlugin.getInstance().getConfig().addDefault("commandblock.prefix", "&a&lCommandBlock &8> ");
		CommandBlockPlugin.getInstance().getConfig().addDefault("commandblock.noPerm", " &c&lDu darfst diesen Command leider nicht ausführen!");
		CommandBlockPlugin.getInstance().getConfig().addDefault("commandblock.configrlmessage", " &a&lDie Config wurde erfolgreich neu geladen!");
		CommandBlockPlugin.getInstance().getConfig().addDefault("commandblock.blockmessage", " &c&lDieser Command wurde leider blockiert!");
		CommandBlockPlugin.getInstance().getConfig().addDefault("commandblock.notificationmessage", " &7Der Spieler &6%player% &7wollte den Command: &6%command% &7ausführen!");
		
		if(!permissionconfig.isSet("permissions.command")) {
			
			createPermissions();
			
		}
		
		if(!BlockedCommandsConfig.isSet("BlockedCommands")) {
			
			createBlockedCommands();
			
		}
		
		CommandBlockPlugin.getInstance().saveConfig();
		CommandBlockPlugin.getInstance().saveDefaultConfig();
		
	}
	
	public static void createPermissions() {
		
		savePermissionConfig("permissions.command.commandblock.perm", "system.commandblock");
		savePermissionConfig("permissions.command.commandblock.notification", "system.notify");
		savePermissionConfig("permissions.command.config.perm", "system.config");
		savePermissionConfig("permissions.command.bypass", "cb.blockbypass");
		
	}
	
	public static void createBlockedCommands() {
		
		List<String> blockcommands = new ArrayList<>();
		
		blockcommands.add("pl");
		blockcommands.add("plugins");
		blockcommands.add("bukkit;pl");
		blockcommands.add("bukkit;about");
		blockcommands.add("bukkit;help");
		blockcommands.add("bukkit;?");
		blockcommands.add("?");
		blockcommands.add("help");
		blockcommands.add("ver");
		blockcommands.add("bukkit;version");
		blockcommands.add("bukkit;ver");
		blockcommands.add("version");
		blockcommands.add("icanhasbukkit");
		blockcommands.add("about");
		blockcommands.add("me");
		blockcommands.add("minecraft;me");
		
		saveBlockedCommandsConfig(blockcommands);
			
	}
	
	public static void savePermissionConfig(String Path, Object args) {
		
		permissionconfig.set(Path, args);
		
		try {
			
			permissionconfig.save(permissionfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void saveBlockedCommandsConfig(List<String> commands) {
		
		BlockedCommandsConfig.set("BlockedCommands", commands);
		
		try {
			
			BlockedCommandsConfig.save(blockedcommandsfile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
