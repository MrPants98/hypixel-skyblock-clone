package me.mrpants98.skyblockclone.Holograms;

import me.mrpants98.skyblockclone.SkyblockClone;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import static me.mrpants98.skyblockclone.Holograms.TextComponents.*;

public class MobTitle extends BukkitRunnable {

    private final SkyblockClone plugin;
    private final int mobLevel;
    private final int mobHealth;
    private final int mobMaxHealth;
    private final String mobName;
    private final Entity mob;
    private TextDisplay text;

    public MobTitle(SkyblockClone plugin, @NotNull int mobLevel, @NotNull int mobHealth, @NotNull int mobMaxHealth, @NotNull String mobName, @NotNull Entity mobRef) {
        this.plugin = plugin;
        this.mobLevel = mobLevel;
        this.mobHealth = mobHealth;
        this.mobMaxHealth = mobMaxHealth;
        this.mobName = mobName;
        this.mob = mobRef;

        World playerWorld = mobRef.getWorld();
        playerWorld.spawn(mobRef.getLocation(), TextDisplay.class, textDisplay -> {

            Component displayText = getMobTitle(mobLevel, mobHealth, mobMaxHealth, mobName);

            textDisplay.text(displayText);
            textDisplay.setBillboard(Display.Billboard.CENTER);

            this.text = textDisplay;
        });

        mobRef.addPassenger(text);

    }

    @Override
    public void run() {
        if (text.isDead())
            cancel();

        if (mob.isDead()) {
            text.remove();
            cancel();
        }
    }
}
