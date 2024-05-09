package de.zcreeper.skywars.lootsystem;

import de.zcreeper.skywars.utils.ItemBuilder;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Random;

public class LootTable {

    private ArrayList<ItemBuilder> loot = new ArrayList<>();

    public LootTable() {
        init();
    }

    private void init() {
        // LootItems
        loot.add(new ItemBuilder(Material.STONE).setAmount(20));
        loot.add(new ItemBuilder(Material.COBWEB).setAmount(4));
        loot.add(new ItemBuilder(Material.DIAMOND_SWORD));
        loot.add(new ItemBuilder(Material.IRON_SWORD));
        loot.add(new ItemBuilder(Material.NETHERITE_SWORD));
        loot.add(new ItemBuilder(Material.IRON_CHESTPLATE));
        loot.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE));
        loot.add(new ItemBuilder(Material.NETHERITE_CHESTPLATE));
        loot.add(new ItemBuilder(Material.TOTEM_OF_UNDYING));
        loot.add(new ItemBuilder(Material.GOLDEN_LEGGINGS));
        loot.add(new ItemBuilder(Material.DIAMOND_LEGGINGS));
        loot.add(new ItemBuilder(Material.NETHERITE_LEGGINGS));
        loot.add(new ItemBuilder(Material.DIAMOND).setAmount(2));
        loot.add(new ItemBuilder(Material.STICK).setAmount(2));
        loot.add(new ItemBuilder(Material.IRON_INGOT).setAmount(4));
        loot.add(new ItemBuilder(Material.CROSSBOW));
        loot.add(new ItemBuilder(Material.ARROW).setAmount(7));
        loot.add(new ItemBuilder(Material.WATER_BUCKET));
        loot.add(new ItemBuilder(Material.LAVA_BUCKET));
        loot.add(new ItemBuilder(Material.IRON_BOOTS));
        loot.add(new ItemBuilder(Material.DIAMOND_BOOTS));
        loot.add(new ItemBuilder(Material.NETHERITE_BOOTS));
        loot.add(new ItemBuilder(Material.CHAINMAIL_HELMET));
        loot.add(new ItemBuilder(Material.IRON_HELMET));
        loot.add(new ItemBuilder(Material.DIAMOND_HELMET));
        loot.add(new ItemBuilder(Material.NETHERITE_HELMET));
        loot.add(new ItemBuilder(Material.DIAMOND_AXE));
        loot.add(new ItemBuilder(Material.DIAMOND_PICKAXE));
    }

    public ItemBuilder randomItem (ArrayList<ItemBuilder> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public ArrayList<ItemBuilder> getLoot() {
        return loot;
    }

}
