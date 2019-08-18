package net.noodles.tutorial1.main.events;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.inventivetalent.bossbar.BossBar;
import org.inventivetalent.bossbar.BossBarAPI;

public class BossBarJoinEvent implements Listener {

    @EventHandler
    public void onbossbarJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        BossBar bossBar = BossBarAPI.addBar(p,new TextComponent(ChatColor.RED + "Hello " + ChatColor.GREEN + p.getName() + ChatColor.RED + "!"), BossBarAPI.Color.BLUE, BossBarAPI.Style.NOTCHED_20, 1.0f, 0, 0);
    }

}
