package me.TastischerGamer.CommandBlock.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.TastischerGamer.CommandBlock.Utils.ConfigUtil;
import me.TastischerGamer.CommandBlock.Utils.PluginUtils;
import me.TastischerGamer.CommandBlock.main.CommandBlockPlugin;

public class CBlockCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("commandblock")) {
			
			if(sender instanceof Player) {
			
				Player p = (Player)sender;
				
				if(p.hasPermission(PluginUtils.getCommandPermission("commandblock"))) {
					
					if(args.length == 0) {
						
						p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
						
					}else if(args.length == 1) {
						
						if(args[0].equalsIgnoreCase("help")) {
							
							p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~");
							p.sendMessage("§6CommandBlock Commands:");
							p.sendMessage(" §8- §7/commandblock add <Command>");
							p.sendMessage(" §8- §7/commandblock remove <Command>");
							p.sendMessage(" §8- §7/commandblock list");
							p.sendMessage(" §8- §7/commandblock notification");
							p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~");
							
						}else if(args[0].equalsIgnoreCase("list")) {
							
							p.sendMessage("§6Blocked Commands: ");
							p.sendMessage("§7" + PluginUtils.getBlockedCommands().toString().replace("[", " ").replace("]", " ").replace(";", ":"));
							
						}else if(args[0].equalsIgnoreCase("notification")) {
							
							if(PluginUtils.isNotificationToggled(p)) {
								
								CommandBlockPlugin.getInstance().getConfig().set("commandblock.player." + p.getName() + ".notification", false);
								
								CommandBlockPlugin.getInstance().saveConfig();
								
								p.sendMessage(PluginUtils.getPrefix() + " §7Du bekommst nun keine Benachrichtung mehr, wenn ein Spieler ein command eingibt, der blockiert ist!");
								
							}else {
								
								CommandBlockPlugin.getInstance().getConfig().set("commandblock.player." + p.getName() + ".notification", true);
								
								CommandBlockPlugin.getInstance().saveConfig();
															
								p.sendMessage(PluginUtils.getPrefix() + " §7Du bekommst nun eine Benachrichtung, wenn ein Spieler ein command eingibt, der blockiert ist!");
	
								
							}
							
						}else {
							
							p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
							
						}
						
					}else if(args.length == 2) {
						
						if(args[0].equalsIgnoreCase("add")) {
							
							List<String> blockedcommands = PluginUtils.getBlockedCommands();
							
							if(!blockedcommands.contains(args[1].replace(":", ";"))) {
								
								blockedcommands.add(args[1].replace(":", ";"));
							
								ConfigUtil.saveBlockedCommandsConfig(blockedcommands);
								
								p.sendMessage(PluginUtils.getPrefix() + " §7Der Command §6" + args[1] + " §7wurde erfolgreich hinzugefügt!");
							
							}else {
								
								p.sendMessage(PluginUtils.getPrefix() + " §cDieser Command existiert bereits!");
								
							}
													
						}else if(args[0].equalsIgnoreCase("remove")) {
							
							List<String> blockedcommands = PluginUtils.getBlockedCommands();
							
							if(blockedcommands.contains(args[1].replace(":", ";"))) {
							
								blockedcommands.remove(args[1].replace(":", ";"));
							
								ConfigUtil.saveBlockedCommandsConfig(blockedcommands);
								
								p.sendMessage(PluginUtils.getPrefix() + " §7Der Command §6" + args[1] + " §7wurde erfolgreich entfernt!");
							
							}else {
								
								p.sendMessage(PluginUtils.getPrefix() + " §cDieser Command wurde leider nicht gefunden!");
								
							}
							
						}else {
							
							p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
							
						}
						
					}else {
						
						p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
						
					}
					
				}else {
					
					p.sendMessage(PluginUtils.getPrefix() + PluginUtils.getNoPermission());
					
				}
				
			}else if(sender instanceof ConsoleCommandSender) {
				
				ConsoleCommandSender p = (ConsoleCommandSender)sender;
				
				if(args.length == 0) {
					
					p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
					
				}else if(args.length == 1) {
					
					if(args[0].equalsIgnoreCase("help")) {
						
						p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~");
						p.sendMessage("§6CommandBlock Commands:");
						p.sendMessage(" §8- §7/commandblock add <Command>");
						p.sendMessage(" §8- §7/commandblock remove <Command>");
						p.sendMessage(" §8- §7/commandblock list");
						p.sendMessage(" §8- §c/commandblock notification");
						p.sendMessage("§7~~~~~~~~~~~~~~~~~~~~~~~");
						
					}else if(args[0].equalsIgnoreCase("list")) {
						
						p.sendMessage("§6Blocked Commands: ");
						p.sendMessage("§7" + PluginUtils.getBlockedCommands().toString().replace("[", " ").replace("]", " ").replace(";", ":"));
						
					}else if(args[0].equalsIgnoreCase("notification")) {
						
						p.sendMessage(PluginUtils.getPrefix() + " §cDieser Command ist nur für Spieler!");
						
					}else {
						
						p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
						
					}
					
				}else if(args.length == 2) {
					
					if(args[0].equalsIgnoreCase("add")) {
						
						List<String> blockedcommands = PluginUtils.getBlockedCommands();
						
						if(!blockedcommands.contains(args[1].replace(":", ";"))) {
							
							blockedcommands.add(args[1].replace(":", ";"));
						
							ConfigUtil.saveBlockedCommandsConfig(blockedcommands);
							
							p.sendMessage(PluginUtils.getPrefix() + " §7Der Command §6" + args[1] + " §7wurde erfolgreich hinzugefügt!");
						
						}else {
							
							p.sendMessage(PluginUtils.getPrefix() + " §cDieser Command existiert bereits!");
							
						}
												
					}else if(args[0].equalsIgnoreCase("remove")) {
						
						List<String> blockedcommands = PluginUtils.getBlockedCommands();
						
						if(blockedcommands.contains(args[1].replace(":", ";"))) {
						
							blockedcommands.remove(args[1].replace(":", ";"));
						
							ConfigUtil.saveBlockedCommandsConfig(blockedcommands);
							
							p.sendMessage(PluginUtils.getPrefix() + " §7Der Command §6" + args[1] + " §7wurde erfolgreich entfernt!");
						
						}else {
							
							p.sendMessage(PluginUtils.getPrefix() + " §cDieser Command wurde leider nicht gefunden!");
							
						}
						
					}else {
						
						p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
						
					}
					
				}else {
					
					p.sendMessage(PluginUtils.getPrefix() + " §cBenutze: /commandblock help");
					
				}
				
			}
			
		}
		
		return false;
	}

}
