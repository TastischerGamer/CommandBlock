package me.TastischerGamer.CommandBlock.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.TastischerGamer.CommandBlock.commands.*;
import me.TastischerGamer.CommandBlock.Listener.*;
import me.TastischerGamer.CommandBlock.Utils.ConfigUtil;
import me.TastischerGamer.CommandBlock.Utils.SpigotMC;

public class CommandBlockPlugin extends JavaPlugin {
	
	private static CommandBlockPlugin instance;
		
	public void onEnable() {
		
		CommandBlockPlugin.instance = this;
		
		ConfigUtil.onConfigLoad();

		SpigotMC.sendPluginStartMessage(this.getDescription().getName(), this.getDescription().getVersion());
		
		this.getCommand("cbconfig").setExecutor(new ConfigCommand());
		this.getCommand("commandblock").setExecutor(new CBlockCommand());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new CommandListener(), this);
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	public static CommandBlockPlugin getInstance() {
		
		return CommandBlockPlugin.instance;
		
	}

}
