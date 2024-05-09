package de.zcreeper.skywars.listener;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (SkyWars.getGameState().equals(GameState.LOBBY)) {
            event.setJoinMessage(SkyWars.getPrefix() + "§6" + player.getDisplayName() + " §ehas joined the round§7.");
            player.setGameMode(GameMode.SURVIVAL);
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.teleport(SkyWars.swLobbyTeleport(player));
            }
        }
    }

}
