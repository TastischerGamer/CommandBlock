package me.TastischerGamer.CommandBlock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.TastischerGamer.CommandBlock.Utils.PluginUtils;
import me.TastischerGamer.CommandBlock.main.CommandBlockPlugin;
import net.md_5.bungee.api.ChatColor;

public class ConfigCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("cbconfig")) {
			
			if(sender instanceof Player) {
			
				Player p = (Player)sender;
				FileConfiguration config = CommandBlockPlugin.getInstance().getConfig();
				
				if(p.hasPermission(PluginUtils.getCommandPermission("config"))) {
					
					CommandBlockPlugin.getInstance().reloadConfig();
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("commandblock.prefix")) + ChatColor.translateAlternateColorCodes('&', config.getString("commandblock.configrlmessage")));
					
				}else{
					
					p.sendMessage(PluginUtils.getPrefix() + PluginUtils.getNoPermission());
					
				}
			
			}else if(sender instanceof ConsoleCommandSender) {
				
				ConsoleCommandSender p = (ConsoleCommandSender) sender;
				FileConfiguration config = CommandBlockPlugin.getInstance().getConfig();
				
				CommandBlockPlugin.getInstance().reloadConfig();
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("commandblock.prefix")) + ChatColor.translateAlternateColorCodes('&', config.getString("commandblock.configrlmessage")));
				
			}
			
		}
		
		return false;
	}

}
