package me.mrpants98.skyblockclone;

import me.mrpants98.skyblockclone.Combat.MeleeAttack;
import me.mrpants98.skyblockclone.Commands.CreateTextDisplay;
import me.mrpants98.skyblockclone.Commands.ReloadMobValues;
import me.mrpants98.skyblockclone.Commands.TestCritDamage;
import me.mrpants98.skyblockclone.Configs.MobValues;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class SkyblockClone extends JavaPlugin {

    private static SkyblockClone plugin;
    private static BukkitScheduler scheduler;

    @Override
    public void onEnable() {
        plugin = this;
        scheduler = this.getServer().getScheduler();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        MobValues.setup();
        MobValues.get().options().copyDefaults(true);
        MobValues.save();

        getCommand("summontext").setExecutor(new CreateTextDisplay());
        getCommand("reloadmobvalues").setExecutor(new ReloadMobValues());
        getCommand("testcritdamage").setExecutor(new TestCritDamage());

        getServer().getPluginManager().registerEvents(new EntitySpawn(), this);
        getServer().getPluginManager().registerEvents(new MeleeAttack(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

    }

    @Override
    public void onDisable() {

    }

    public static SkyblockClone getPlugin() { return plugin; }
    public static BukkitScheduler getScheduler() { return scheduler; }
}