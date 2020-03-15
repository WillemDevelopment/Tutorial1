package net.noodles.tutorial1.main.NPC;

import net.jitse.npclib.NPCLib;
import net.jitse.npclib.api.NPC;
import net.jitse.npclib.api.events.NPCInteractEvent;
import net.jitse.npclib.api.skin.MineSkinFetcher;
import net.jitse.npclib.api.state.NPCSlot;
import net.noodles.tutorial1.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class NPCManager implements Listener {

    private Main main;
    private NPCLib npcLib;

    //NPCS HERE
    private NPC gameLobbyNPC;

    public NPCManager(Main main) {
        this.main = main;
        this.npcLib = new NPCLib(main);
        load();
        Bukkit.getPluginManager().registerEvents(this, main);
    }


    private void load() {
        int skinId = 277513;
        MineSkinFetcher.fetchSkinFromIdAsync(skinId, skin -> {
            gameLobbyNPC = npcLib.createNPC(Arrays.asList(ChatColor.GOLD + "Game Lobbies", ChatColor.GRAY + "(Click to connect)"));
            gameLobbyNPC.setLocation(new Location(Bukkit.getWorlds().get(0), 100, 70, 100, 0, 0));
            gameLobbyNPC.setItem(NPCSlot.MAINHAND, new ItemStack(Material.ANVIL));
            gameLobbyNPC.setSkin(skin);
            gameLobbyNPC.create();
        });
    }

    @EventHandler
    public void onNPCInteract(NPCInteractEvent event) {
        Player player = event.getWhoClicked();
        //DETECT WHEN PLAYERS HIT AN NPC AND DO SOMETHING
        if(event.getNPC() == gameLobbyNPC) {
            player.sendMessage(ChatColor.RED + "This is a message when you click me!");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        //SPAWN NPC'S WHEN PLAYER JOINS THE SERVER
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), () -> {
            Bukkit.getScheduler().runTask(Main.getPlugin(), () -> gameLobbyNPC.show(event.getPlayer()));
        }, 60L);
    }

}
