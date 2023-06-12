package ru.korshun.korshuntoolslegacy.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import ru.korshun.korshuntoolslegacy.KorshunToolsLegacy;

public class InvClickEvent implements Listener {
    @EventHandler
    public void InvClick(InventoryClickEvent e) {
            if (e.getView().getTitle() == KorshunToolsLegacy.getInstance().getConfig().getString("messages.checkfly-menu-title")) {
                e.setCancelled(true);
            }
                   if (e.getInventory().getTitle() == KorshunToolsLegacy.getInstance().getConfig().getString("messages.checkfly-menu-title")) {
                       e.setCancelled(true);
                   }
        }
    }
