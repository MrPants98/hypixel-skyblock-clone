package me.mrpants98.skyblockclone.Holograms;

import me.mrpants98.skyblockclone.SkyblockClone;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static me.mrpants98.skyblockclone.Holograms.TextComponents.*;

public class DamageMob extends BukkitRunnable {

    private final SkyblockClone plugin;
    private final Entity mob;
    private TextDisplay text;

    public DamageMob(@NotNull SkyblockClone plugin, @NotNull int damageAmount, @NotNull boolean didCritical, @NotNull Entity mobRef) {
        this.plugin = plugin;
        this.mob = mobRef;

        World playerWorld = mobRef.getWorld();

        Location mobLocation = mobRef.getLocation();

        Random rand = new Random();

        double xOffset = 0.25;
        double zOffset = 0.25;
        double yOffset = 1.3;

        mobLocation.add(xOffset, yOffset, zOffset);

        playerWorld.spawn(mobLocation, TextDisplay.class, textDisplay -> {

            Component displayText;
            if (didCritical)
                displayText = getCritDamageTitle(damageAmount);
            else
                displayText = getDamageTitle(damageAmount);

            textDisplay.text(displayText);
            textDisplay.setBillboard(Display.Billboard.CENTER);

            this.text = textDisplay;
        });

    }

    @Override
    public void run() {
        if (text.isDead())
            return;

        text.remove();
    }
}
