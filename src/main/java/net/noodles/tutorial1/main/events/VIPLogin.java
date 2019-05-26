package net.noodles.tutorial1.main.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class VIPLogin implements Listener {


    @EventHandler
    public void OnPlayerJoin(PlayerLoginEvent e) {
        if(e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if(e.getPlayer().hasPermission("vip.bypass")) {
                e.allow();
            }
        }
    }

}
