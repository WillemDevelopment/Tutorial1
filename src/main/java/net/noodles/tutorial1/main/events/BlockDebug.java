package net.noodles.tutorial1.main.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockDebug implements Listener {



    @EventHandler
    public void onPlayerBlockDebug(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        Location l = p.getLocation();
        l.add(0, -0.5, 0);
        Block b = l.getBlock();
        //p.sendMessage(ChatColor.RED + "[Debug] Standing on " + b + "Data Value " + b.getData());
    }

}
