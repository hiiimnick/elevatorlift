package me.Nick.ElevatorLift;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		//startup, reload, plugin reload
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		//shutdown, reload, plugin reload
	}
	
	// /test <-- plugin works
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		/*if(label.equalsIgnoreCase("test")) {
			if(sender instanceof Player) {
				//player
				Player player = (Player) sender;
				player.sendMessage("plugin works");
				return true;
			}
			else {
				//console
				sender.sendMessage("plugin works but in console");
				return true;
			}
		}*/
		if(label.equalsIgnoreCase("elevatorlift")) {
			   if(sender instanceof Player) {
				   sender.sendMessage("§0=§r-§0=§r-§0=§r-§0=§r-§0=§6§lElevatorlift§0=§r-§0=§r-§0=§r-§0=§r-§0=");
				   sender.sendMessage("Check the spigot page for help.");
				   sender.sendMessage("");
				   sender.sendMessage("https://www.spigotmc.org/ <-- §b§lCLICK THE LINK");
				   sender.sendMessage("§0=§r-§0=§r-§0=§r-§0=§r-§0=§6§lElevatorlift§0=§r-§0=§r-§0=§r-§0=§r-§0=");
				   return true;
			   }
			   
		   }
		return false;
	  
	}
	
   @EventHandler
   public void onJump(PlayerMoveEvent event) {
	  Player player = (Player) event.getPlayer();
	  Location loc = player.getLocation();
	  String pula = "§4§lYou went up a level.";
      double x = loc.getX();
      double y = loc.getY();
      double z = loc.getZ();
      double yaw = loc.getYaw();
      double pitch = loc.getPitch();
      int yawInt = (int)yaw;
      int pitchInt = (int)pitch;
      World world = player.getWorld();
	  if(event.getFrom().getY() < event.getTo().getY() && player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.IRON_BLOCK && player.getLocation().subtract(0, 2, 0).getBlock().getType() == Material.REDSTONE_BLOCK) {
		  for(double i = y; i <= y+9; i++)
		  {
			  if(world.getBlockAt((int)x,(int)i,(int)z).getType() == Material.REDSTONE_BLOCK && world.getBlockAt((int)x,(int)i+1,(int)z).getType() == Material.IRON_BLOCK) {
				  Location penis = new Location(player.getWorld(), x, i+2 , z, yawInt, pitchInt);
				  player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(pula));
				  player.teleport(penis);			  
				  }
		  }
	  }
   }
   @EventHandler
   public void onSneak(PlayerToggleSneakEvent event) {
	  Player player = (Player) event.getPlayer();
	  Location loc = player.getLocation();
	  String pula = "§4§lYou went down a level.";
      double x = loc.getX();
      double y = loc.getY();
      double z = loc.getZ();
      double yaw = loc.getYaw();
      double pitch = loc.getPitch();
      int yawInt = (int)yaw;
      int pitchInt = (int)pitch;
      World world = player.getWorld();
	  if(player.isSneaking() && player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.IRON_BLOCK && player.getLocation().subtract(0, 2, 0).getBlock().getType() == Material.REDSTONE_BLOCK) {
		  for(double i = y-3; i >= y-13; i--)
		  {
			  if(world.getBlockAt((int)x,(int)i,(int)z).getType() == Material.REDSTONE_BLOCK && world.getBlockAt((int)x,(int)i+1,(int)z).getType() == Material.IRON_BLOCK) {
				  Location penis = new Location(player.getWorld(), x, i+2, z, yawInt, pitchInt);
				  player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(pula));
				  player.teleport(penis);
				  }
		  }
	  }
   }
	
}
