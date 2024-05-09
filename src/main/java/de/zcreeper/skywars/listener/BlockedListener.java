package de.zcreeper.skywars.listener;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.gamestate.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class BlockedListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (SkyWars.getGameState().equals(GameState.LOBBY) || SkyWars.getGameState().equals(GameState.ENDING)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (SkyWars.getGameState().equals(GameState.LOBBY) || SkyWars.getGameState().equals(GameState.ENDING)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (SkyWars.getGameState().equals(GameState.LOBBY) || SkyWars.getGameState().equals(GameState.ENDING)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onFood(FoodLevelChangeEvent event) {
        if (SkyWars.getGameState().equals(GameState.LOBBY) || SkyWars.getGameState().equals(GameState.ENDING)) {
            event.setCancelled(true);
            event.setFoodLevel(20);
        } else {
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (SkyWars.getGameState().equals(GameState.LOBBY) || SkyWars.getGameState().equals(GameState.ENDING)) {
            if (event.getAction().equals(Action.PHYSICAL)) {
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent event) {
        if (SkyWars.getGameState().equals(GameState.LOBBY) || SkyWars.getGameState().equals(GameState.ENDING)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }
}
