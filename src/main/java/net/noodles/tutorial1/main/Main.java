package net.noodles.tutorial1.main;

import me.tigerhix.lib.scoreboard.ScoreboardLib;
import net.noodles.tutorial1.main.NPC.NPCManager;
import net.noodles.tutorial1.main.commands.TutorialCommand;
import net.noodles.tutorial1.main.commands.FlyCommand;
import net.noodles.tutorial1.main.events.Events;
import net.noodles.tutorial1.main.events.JoinScoreboardEvent;
import net.noodles.tutorial1.main.events.LandMines;
import net.noodles.tutorial1.main.events.VIPLogin;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {


    private static NPCManager npcManager;
    private static Main Landmines;
    public ArrayList<Block> mines;


    public Main() {
        this.mines = new ArrayList<Block>();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerEvents();
        ScoreboardLib.setPluginInstance(this);
        this.npcManager = new NPCManager(this);
        Main.Landmines = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    public void registerCommands() {
        getCommand("tutorial").setExecutor(new TutorialCommand());
        getCommand("fly").setExecutor(new FlyCommand());

    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Events(), this);
        pm.registerEvents(new JoinScoreboardEvent(), this);
        pm.registerEvents(new LandMines(), this);
        pm.registerEvents(new VIPLogin(), this);
    }

    public static Main getLandmines() {
        return Main.Landmines;
    }





}
