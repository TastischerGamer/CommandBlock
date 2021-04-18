package me.TastischerGamer.CommandBlock.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.TastischerGamer.CommandBlock.Utils.ConfigUtil;
import me.TastischerGamer.CommandBlock.Utils.PluginUtils;

public class CommandListener implements Listener {
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onCommandListener(PlayerCommandPreprocessEvent e) {
				
		if(!e.getPlayer().hasPermission(ConfigUtil.permissionconfig.getString("permissions.command.bypass"))) {
			
			for(String blockedcommand : PluginUtils.getBlockedCommands()) {
				
				if(e.getMessage().toLowerCase().startsWith("/" + blockedcommand.replace(";", ":"))) {
				
					for(Player all : Bukkit.getOnlinePlayers()) {
						
						if(all.hasPermission(ConfigUtil.permissionconfig.getString("permissions.command.commandblock.notification"))) {
							
							if(PluginUtils.isNotificationToggled(all.getPlayer())) {
								
								all.sendMessage(PluginUtils.getStringfromConfig("commandblock.notificationmessage").replace("%player%", e.getPlayer().getName()).replace("%command%", e.getMessage()));
								
							}
							
						}
						
					}
					
					e.getPlayer().sendMessage(PluginUtils.getPrefix() + PluginUtils.getStringfromConfig("commandblock.blockmessage"));
					
					e.setCancelled(true);
				
				}

				
			}
	
		}
		
	}

}
