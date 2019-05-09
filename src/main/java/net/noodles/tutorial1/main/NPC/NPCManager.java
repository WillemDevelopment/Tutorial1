package net.noodles.tutorial1.main.NPC;

import net.jitse.npclib.NPCLib;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.events.NPCInteractEvent;
import net.jitse.npclib.skin.MineSkinFetcher;
import net.noodles.tutorial1.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

public class NPCManager implements Listener {


    private Main main;
    private NPCLib npcLib;

    private NPC test;

    public NPCManager(Main main) {
        this.main = main;
        this.npcLib = new NPCLib(main);
        load();
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    public void display(Player player) {
        test.show(player);
    }


    private void load() {

        MineSkinFetcher.fetchSkinFromIdAsync(277513, skin -> {
            test = npcLib.createNPC(skin, Arrays.asList("THIS IS A TEST!", "Click me to send a message"));
            test.create(new Location(Bukkit.getWorlds().get(0), 0, 55, 0, 50, 0));

        });


    }


    @EventHandler
    public void onNPCInteract(NPCInteractEvent e) {
        Player player = e.getWhoClicked();
        if (e.getNPC() == test) {
            player.sendMessage(ChatColor.GREEN + "You have clicked an NPC!");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        display(player);
    }



}
