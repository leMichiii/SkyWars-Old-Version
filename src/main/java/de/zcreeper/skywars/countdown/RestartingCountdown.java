package de.zcreeper.skywars.countdown;

import de.zcreeper.skywars.SkyWars;
import org.bukkit.Bukkit;

public class RestartingCountdown extends Countdown {

    @Override
    public void onStart() {
        Bukkit.broadcastMessage(SkyWars.getPrefix() + "§cThe Game is over! The Server will restart now!...");
    }

    @Override
    public void onEnd() {
        Bukkit.broadcastMessage(SkyWars.getPrefix() + "§cThe Server is now restarting.");
        Bukkit.getServer().shutdown();
    }

    @Override
    public void run() {
        Bukkit.broadcastMessage(SkyWars.getPrefix() + "§cThe Server restarts in §6" + getRemainingSeconds() + " §cseconds!");
    }

}
