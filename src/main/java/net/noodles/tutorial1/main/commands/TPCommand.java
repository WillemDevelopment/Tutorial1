package net.noodles.tutorial1.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                player.sendMessage(ChatColor.RED + "Correct usage: /tp <player>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                player.sendMessage(ChatColor.RED + "That player is not online!");
                return true;
            }
            player.teleport(target);
            player.sendMessage(ChatColor.GREEN + "You teleported to " + target.getName() + "!");
            target.sendMessage(ChatColor.GREEN + player.getName() + " teleported to you!");
        }
        return true;
    }

}

