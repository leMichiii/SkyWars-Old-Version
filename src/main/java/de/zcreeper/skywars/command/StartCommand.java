package de.zcreeper.skywars.command;

import de.zcreeper.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("skywars.cmd.start")) {
            if (SkyWars.getLobbyCountdown().getRemainingSeconds() > 10) {
                SkyWars.getLobbyCountdown().setRemainingSeconds(10);
                sender.sendMessage(SkyWars.getPrefix() + "§aYou skipped the LobbyCountdown!");
                Bukkit.broadcastMessage(SkyWars.getPrefix() + "§aThe Countdown were shortend.");
            } else {
                sender.sendMessage(SkyWars.getPrefix() + "§cYou cannot forcestart the Round anymore!");
            }
        } else {
            sender.sendMessage(SkyWars.getPrefix() + "§cYou do not have the permissions to perform that command.");
        }

        return true;
    }
}
