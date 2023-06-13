package ru.korshun.korshuntoolslegacy.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korshun.korshuntoolslegacy.KorshunToolsLegacy;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!KorshunToolsLegacy.getInstance().getConfig().getBoolean("commands.heal")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.command-disable")));
            return true;
        } else {
            if (!sender.hasPermission("korshuntools.heal")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.no-permissions")));
                return false;
            }
            else {
                Player player = (Player) sender;
                if(args.length == 0) {
                    if(!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.sender-not-player")));
                        return false;
                    }
                    double HealthLevel = player.getMaxHealth();
                    player.setHealth(HealthLevel);
                    player.setFoodLevel(20);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.heal-command")));
                }
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.player-not-found")));
                        return false;
                    }
                    double HealthLevelTarget = target.getMaxHealth();
                    target.setHealth(HealthLevelTarget);
                    target.setFoodLevel(20);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.heal-command-target").replace("{player_name}", player.getName())));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', KorshunToolsLegacy.getInstance().getConfig().getString("messages.heal-command-target-me")));
                }
            }
            return true;
        }
    }
}
