package de.zcreeper.skywars.lootsystem;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class PlayerInteractListener implements Listener {

    private LootTable lootTable;

    private List<Location> touchedChest = new ArrayList<>();


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null) {
            if (event.getClickedBlock().getType() == Material.CHEST) {
                if (touchedChest.contains(event.getClickedBlock().getLocation()))return;
                BlockState state = event.getClickedBlock().getState();
                Chest chest = (Chest) state;
                Location chestLocation = chest.getLocation();
                Inventory chestInventory = chest.getInventory();
                new LootSystem().loadChestItem(chestInventory);
                touchedChest.add(chestLocation);
            }
        }
    }

}
