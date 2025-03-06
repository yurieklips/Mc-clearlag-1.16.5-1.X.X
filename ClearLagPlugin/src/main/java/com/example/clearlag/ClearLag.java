package com.example.clearlag;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class ClearLag extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("ClearLag activé !");
        getServer().getPluginManager().registerEvents(this, this);
        new BukkitRunnable() {
            int countdown = 900;
            @Override
            public void run() {
                if (countdown == 60 || countdown == 30 || countdown == 10) {
                    Bukkit.broadcastMessage(ChatColor.BLUE + "ClearLag dans " + countdown + " secondes !");
                }
                if (countdown <= 0) {
                    int removed = 0;
                    for (World world : Bukkit.getWorlds()) {
                        for (Entity entity : world.getEntities()) {
                            if (entity instanceof Item || entity instanceof Monster) {
                                entity.remove();
                                removed++;
                            }
                        }
                    }
                    Bukkit.broadcastMessage(ChatColor.BLUE + "ClearLag: " + removed + " entités supprimées pour réduire le lag.");
                    countdown = 900;
                } else {
                    countdown--;
                }
            }
        }.runTaskTimer(this, 0L, 20L);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
         Player player = event.getPlayer();
         player.sendMessage(ChatColor.BLUE + "Le clearLag de KarmaIsBack est utilisé sur ce serveur");
    }

    @Override
    public void onDisable() {
        getLogger().info("ClearLag désactivé !");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("clearlag")) {
            int removed = 0;
            for (World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getEntities()) {
                    if (entity instanceof Item || entity instanceof Monster) {
                        entity.remove();
                        removed++;
                    }
                }
            }
            sender.sendMessage(ChatColor.BLUE + "ClearLag: " + removed + " entités supprimées.");
            Bukkit.broadcastMessage(ChatColor.BLUE + "ClearLag: " + removed + " entités supprimées manuellement pour réduire le lag.");
            return true;
        }
        return false;
    }
}
