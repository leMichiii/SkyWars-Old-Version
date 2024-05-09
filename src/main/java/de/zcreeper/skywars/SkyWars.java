package de.zcreeper.skywars;

import de.zcreeper.skywars.command.StartCommand;
import de.zcreeper.skywars.countdown.LobbyCountdown;
import de.zcreeper.skywars.death.PlayerDeathListener;
import de.zcreeper.skywars.gamestate.GameState;
import de.zcreeper.skywars.listener.BlockedListener;
import de.zcreeper.skywars.listener.PlayerJoinListener;
import de.zcreeper.skywars.listener.PlayerQuitListener;
import de.zcreeper.skywars.lootsystem.PlayerInteractListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class SkyWars extends JavaPlugin {

    @Getter
    public static SkyWars instance;

    @Getter
    public static LobbyCountdown lobbyCountdown;

    @Getter
    @Setter
    public static GameState gameState;

    @Getter
    public static final String Prefix = ChatColor.GRAY + "§7[§x§5§0§F§B§0§8S§x§6§D§F§C§3§1k§x§8§A§F§C§5§Ay§x§A§8§F§D§8§4W§x§C§5§F§E§A§Da§x§E§2§F§E§D§6r§x§F§F§F§F§F§Fs§7] §7>> ";

    @Getter
    private static PlayerDeathListener deathListener;

    @Override
    public void onEnable() {
        instance = this;
        gameState = GameState.LOBBY;

        Bukkit.getConsoleSender().sendMessage(getPrefix() + ChatColor.GREEN + "SkyWars is enabled!");

        lobbyCountdown = new LobbyCountdown();
        lobbyCountdown.startCountdown(61);

        deathListener = new PlayerDeathListener();

        registerListeners();
        registerCommands();
    }

    private void registerCommands() {
        getCommand("start").setExecutor(new StartCommand());
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new BlockedListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);
        pm.registerEvents(new PlayerDeathListener(), this);
        pm.registerEvents(new PlayerInteractListener(), this);
    }

    public static void mapTeleport() {
        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
        Location[] teleportLocations = {
                new Location(Bukkit.getWorld("world"), -3.5, -59, 2.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 8.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 14.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 20.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 26.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 32.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 38.5),
                new Location(Bukkit.getWorld("world"), -3.5, -59, 44.5),
        };
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Location location = teleportLocations[i % teleportLocations.length];
            player.teleport(location);
        }
    }

    public static Location swLobbyTeleport(Player player) {
        Location spawn = new Location(Bukkit.getWorld("world"), -13.296, 65, -21.608);
        spawn.setPitch((float) -129.4);
        spawn.setPitch((float) 11.3);

        player.teleport(spawn);
        return spawn;
    }


    @Override
    public void onDisable() {
    Bukkit.getConsoleSender().sendMessage(getPrefix() + ChatColor.RED + "SkyWars is disabled!");
    }
}
