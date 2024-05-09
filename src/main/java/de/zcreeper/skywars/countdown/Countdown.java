package de.zcreeper.skywars.countdown;

import de.zcreeper.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public abstract class Countdown implements Runnable {


    private boolean running = false;


    private int startedSeconds;

    private int remainingSeconds;


    private BukkitTask task;


    public void startCountdown(int remainingSeconds) {
        this.running = true;
        this.startedSeconds = remainingSeconds;
        this.remainingSeconds = remainingSeconds;
        this.onStart();
        this.task = Bukkit.getScheduler().runTaskTimer(SkyWars.getInstance(), () -> {
            if (Countdown.this.remainingSeconds <= 0) {
                Countdown.this.cancelCountdown();
                Countdown.this.onEnd();
                return;
            }

            Countdown.this.run();
            Countdown.this.remainingSeconds--;
        }, 0, 20);
    }


    public abstract void onStart();


    public abstract void onEnd();

    public void cancelCountdown() {
        this.running = false;
        this.task.cancel();
    }

    public boolean isRunning() {
        return running;
    }

    public int getStartedSeconds() {
        return startedSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public Countdown setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
        return this;
    }

    public BukkitTask getTask() {
        return task;
    }
}
