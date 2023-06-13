package ru.korshun.korshuntoolslegacy;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import ru.korshun.korshuntoolslegacy.commands.SetFoodCommand;
import ru.korshun.korshuntoolslegacy.commands.*;
import ru.korshun.korshuntoolslegacy.events.InvClickEvent;
import ru.korshun.korshuntoolslegacy.tabcomplete.FlyTabCompleter;
import ru.korshun.korshuntoolslegacy.tabcomplete.KorshunToolsTabCompleter;
import ru.korshun.korshuntoolslegacy.tabcomplete.SetFoodTabCompleter;
import ru.korshun.korshuntoolslegacy.tabcomplete.SetHealthTabCompleter;

public final class KorshunToolsLegacy extends JavaPlugin {
    private static KorshunToolsLegacy instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("fly").setTabCompleter(new FlyTabCompleter());
        getCommand("sethealth").setExecutor(new SetHealthCommand());
        getCommand("sethealth").setTabCompleter(new SetHealthTabCompleter());
        getCommand("setfood").setExecutor(new SetFoodCommand());
        getCommand("setfood").setTabCompleter(new SetFoodTabCompleter());
        getCommand("korshuntools").setExecutor(new KorshunToolsCommand());
        getCommand("korshuntools").setTabCompleter(new KorshunToolsTabCompleter());
        getLogger().info("[KorshunTools] " + ChatColor.GREEN + "Enabled!");
        getCommand("checkfly").setExecutor(new CheckFlyCommand());
        getCommand("checkhealth").setExecutor(new CheckHealthCommand());
        getCommand("checkfood").setExecutor(new CheckFoodCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        saveDefaultConfig();
    }
    @Override
    public void onDisable() {
        getLogger().info("[KorshunTools] " + ChatColor.RED + "Disabled!");
    }

    public static KorshunToolsLegacy getInstance() {
        return instance;
    }
}