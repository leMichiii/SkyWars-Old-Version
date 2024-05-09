package de.zcreeper.skywars.countdown;

import de.zcreeper.skywars.SkyWars;
import de.zcreeper.skywars.gamestate.GameState;
import org.bukkit.Bukkit;

public class LobbyCountdown extends Countdown {

    @Override
    public void onStart() {
        Bukkit.broadcastMessage(SkyWars.getPrefix() + "§aCountdown started!");
    }

    @Override
    public void onEnd() {
        Bukkit.broadcastMessage(SkyWars.getPrefix() + "§aThe game begins now!");

        Bukkit.getOnlinePlayers().forEach(players -> {
            players.sendTitle("§2Sky§fWars", "§bis starting!", 20, 10 ,20);
        });
        SkyWars.mapTeleport();
        SkyWars.setGameState(GameState.INGAME);
    }

    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() >= 2) {

        if (getRemainingSeconds() == 60 || getRemainingSeconds() == 50 || getRemainingSeconds() == 40 || getRemainingSeconds() == 30 || getRemainingSeconds() == 20 || getRemainingSeconds() == 10 || getRemainingSeconds() == 9 || getRemainingSeconds() == 8 || getRemainingSeconds() == 7 || getRemainingSeconds() == 6
                || getRemainingSeconds() == 5 || getRemainingSeconds() == 4 || getRemainingSeconds() == 3 || getRemainingSeconds() == 2 || getRemainingSeconds() == 1) {
            Bukkit.broadcastMessage(SkyWars.getPrefix() + "§aThe round starts in §e" + getRemainingSeconds() + " §aseconds.");
        }
        Bukkit.getOnlinePlayers().forEach(players -> {
            players.setLevel(getRemainingSeconds());
            players.setExp((float) getRemainingSeconds() / (float) getStartedSeconds());
        });
    }else  {
            setRemainingSeconds(61);
        }
    }

}
