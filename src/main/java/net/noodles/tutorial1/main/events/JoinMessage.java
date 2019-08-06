package net.noodles.tutorial1.main.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    @EventHandler
    public void joinMessage(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
        p.sendMessage(ChatColor.BLUE + "Welcome to the BGHDDev Tutorial Server!");
        p.sendMessage(ChatColor.BLUE + "Your username is " + ChatColor.YELLOW + p.getName());
        p.sendMessage(ChatColor.BLUE + "Make sure to subscribe to our YT channel!");
        p.sendMessage(ChatColor.WHITE + "" + ChatColor.ITALIC + "https://youtube.com/bghddevelopment");
        p.sendMessage(ChatColor.GRAY + "----------------------------------------------------");

    }
}
