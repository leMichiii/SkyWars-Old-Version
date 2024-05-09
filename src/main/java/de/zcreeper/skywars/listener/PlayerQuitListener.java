package de.zcreeper.skywars.listener;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.gamestate.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (SkyWars.getGameState().equals(GameState.LOBBY)) {
            event.setQuitMessage(SkyWars.getPrefix() + "§e" + player.getDisplayName() + " §chas left the game!.");
        }
    }
}
