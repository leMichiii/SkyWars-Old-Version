package de.zcreeper.skywars.lootsystem;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.gamestate.GameState;
import de.zcreeper.skywars.utils.ItemBuilder;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Random;

public class LootSystem {

    private LootTable lootTable = new LootTable();
    private ArrayList<ItemBuilder> loot = lootTable.getLoot();
    private int chestInventorySize = 9 * 3 - 1;

    public void loadChestItem(Inventory chestInventory) {
        Random random = new Random();
        int amountOfItems = random.nextInt(chestInventorySize);

        if (SkyWars.getGameState().equals(GameState.INGAME)) {
            for (int i = 0; i <= amountOfItems; i++) {
                chestInventory.setItem(setItemRandom(chestInventorySize), lootTable.randomItem(loot).build());
            }
        }
    }


    public int setItemRandom ( int chestSize){
        Random random = new Random();
        return random.nextInt(chestSize);
    }

}
