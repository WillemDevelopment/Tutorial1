package net.noodles.tutorial1.main;

import me.tigerhix.lib.scoreboard.ScoreboardLib;
import net.noodles.tutorial1.main.NPC.NPCManager;
import net.noodles.tutorial1.main.commands.TutorialCommand;
import net.noodles.tutorial1.main.commands.FlyCommand;
import net.noodles.tutorial1.main.events.Events;
import net.noodles.tutorial1.main.events.JoinScoreboardEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    private static NPCManager npcManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerEvents();
        ScoreboardLib.setPluginInstance(this);
        this.npcManager = new NPCManager(this);
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

    }





}
