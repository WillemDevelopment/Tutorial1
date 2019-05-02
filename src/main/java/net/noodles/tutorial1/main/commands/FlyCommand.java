package net.noodles.tutorial1.main.commands;

import com.sun.xml.internal.ws.resources.SenderMessages;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FlyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fly")) {
            if (!(sender instanceof Player)) {
                System.out.println("You can only run this command as a player.");
            }
            Player player = (Player) sender;

            if (!player.hasPermission("fly.use")) {
                player.sendMessage(ChatColor.RED + "You can not use this command!");
                return true;
            }
            if (player.getAllowFlight() == true) {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage(ChatColor.RED + "You have disabled fly!");
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(ChatColor.GREEN + "You have enabled fly!");
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                player.getActivePotionEffects().clear();
            }
        }
        return false;
    }

}

