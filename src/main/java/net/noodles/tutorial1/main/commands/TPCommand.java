package net.noodles.tutorial1.main.commands;

import net.noodles.tutorial1.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.java2d.windows.GDIRenderer;

public class TPCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tp")) {
            if (!(sender instanceof Player)) {
                System.out.println("You can only run this command as a player.");
            }
            Player player = (Player) sender;
            if (!player.hasPermission("tp.use")) {
                player.sendMessage(ChatColor.RED + "You can not use this command!");
                return true;
            }
            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Correct usage: /tp <player> <otherplayer> or /tp <x> <y> <z> <player>");
                return true;
            }
            if(args.length >=3) {
                if (args.length == 3) {
                    int x;
                    int y;
                    int z;
                    try {
                        x = Integer.parseInt(args[0]);
                        y = Integer.parseInt(args[1]);
                        z = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Invalid coordinates!");
                        return true;
                    }
                    player.teleport(new Location(player.getWorld(), x, y, z));
                    player.sendMessage(ChatColor.GREEN + "Teleported to " + x + ", " + y + ", " + z + ".");
                    return true;
                }
                if (args.length == 4) {
                    int x;
                    int y;
                    int z;
                    try {
                        x = Integer.parseInt(args[0]);
                        y = Integer.parseInt(args[1]);
                        z = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Invalid coordinates!");
                        return true;
                    }
                    Player target = Bukkit.getPlayer(args[3]);
                    if (target == null || !target.isOnline()) {
                        player.sendMessage(ChatColor.RED + "That player is not online!");
                        return true;
                    }
                    target.teleport(new Location(player.getWorld(), x, y, z));
                    player.sendMessage(ChatColor.GREEN + "Teleported " + target.getName() + " to " + x + "," + y + "," + z + ".");
                    target.sendMessage(ChatColor.GREEN + "You were teleported to " + x + "," + y + "," + z);
                    return true;
                }
            } else if (args.length >=1) {
                Player target = Bukkit.getPlayer(args[0]);
                    if(target == null || !target.isOnline()) {
                        player.sendMessage(ChatColor.RED + "That player is not online.");
                        return true;
                }
                    if (args.length == 2) {
                        Player target2 = Bukkit.getPlayer(args[1]);
                        if (target2 == null || !target2.isOnline()) {
                            player.sendMessage(ChatColor.RED + "That player is not online.");
                            return true;
                        }
                        target.teleport(target2);
                        player.sendMessage(ChatColor.GREEN + "Teleported " + target.getName() +  " to " + target2.getName());
                        return true;
                    }
                    player.teleport(target);
                    player.sendMessage(ChatColor.GREEN + "Teleported to " + target.getName());
                    return true;
            } else {
                player.sendMessage(ChatColor.RED + "Correct usage: /tp <player> <otherplayer> or /tp <x> <y> <z> <player>");
            }

        }
        return true;
    }

}

