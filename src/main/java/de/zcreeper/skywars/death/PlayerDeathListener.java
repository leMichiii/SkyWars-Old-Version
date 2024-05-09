package de.zcreeper.skywars.death;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.countdown.RestartingCountdown;
import de.zcreeper.skywars.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class PlayerDeathListener implements Listener {

    private final Set<Player> players = new HashSet<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (SkyWars.getGameState() == GameState.INGAME) {
            player.setGameMode(GameMode.SPECTATOR);
            players.add(player);
            checkWinner();
        }
    }

    private void checkWinner() {
        if (players.size() == 1) {
            Player winner = players.iterator().next();
            Bukkit.broadcastMessage(SkyWars.getPrefix() + "§bThe player §6" + winner.getName() + " §bhas §2won §bthe round.");
            RestartingCountdown restartingCountdown = new RestartingCountdown();
            restartingCountdown.startCountdown(16);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        players.remove(player);
        checkWinner();
    }

}
