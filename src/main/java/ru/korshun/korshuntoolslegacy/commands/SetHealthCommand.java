package ru.korshun.korshuntoolslegacy.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korshun.korshuntoolslegacy.KorshunToolsLegacy;

public class SetHealthCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!KorshunToolsLegacy.getInstance().getConfig().getBoolean("commands.sethealth")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.command-disable")));
            return true;
        } else {
            if (!sender.hasPermission("korshuntools.sethealth")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.no-permissions")));
                return false;
            } else {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Использование: /sethealth <Игрок> <Уровень>");
                    return true;
                } else if (args.length == 1) {
                    sender.sendMessage(ChatColor.RED + "Укажите уровень здоровья!");
                    return true;
                }
                if (args.length == 2) {
                    int HealthLevel = Integer.parseInt(args[1]);
                    String targetname = args[0];
                    Player target = Bukkit.getPlayer(targetname);
                    if (HealthLevel > target.getMaxHealth()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.health-level-big").replace("{max_health}", String.valueOf(target.getMaxHealth()))));
                    }
                    if (target == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.player-not-found")));
                        return true;
                    }
                    target.setHealth(HealthLevel);
                    target.sendMessage(ChatColor.GREEN + "Вам установили здоровье на значение " + HealthLevel);
                    return true;
                }
            }
            return false;
        }
    }
}