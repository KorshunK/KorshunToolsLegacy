package ru.korshun.korshuntoolslegacy.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class FlyTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            return null;
        }
        if(args.length == 2) {
            return List.of(
                    "true",
                    "false"
            );
        }
        return null;
    }
}