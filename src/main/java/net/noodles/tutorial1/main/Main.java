package net.noodles.tutorial1.main;

import net.noodles.tutorial1.main.commands.TutorialCommand;
import net.noodles.tutorial1.main.commands.FlyCommand;
import net.noodles.tutorial1.main.events.Events;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerEvents();
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
    }

}
