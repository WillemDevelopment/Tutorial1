package net.noodles.tutorial1.main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tutorial")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (sender.hasPermission("tutorial1")) {
                    ItemStack diamond = new ItemStack(Material.DIAMOND);
                    ItemStack bricks = new ItemStack(Material.BRICK);
                    bricks.setAmount(25);
                    player.getInventory().addItem(bricks, diamond);
                    player.sendMessage(ChatColor.GREEN + "You got free stuff!");
                } else {
                    player.sendMessage(ChatColor.RED + "YOU DO NOT HAVE PERMISSION TO RUN THIS COMMAND!");
                }
            }
        }
        return true;
    }


}
