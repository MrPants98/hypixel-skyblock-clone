package me.mrpants98.skyblockclone.Configs;

import me.mrpants98.skyblockclone.SkyblockClone;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MobValues {

    private static File file;
    private static FileConfiguration config;

    public static void setup() {
        file = new File(SkyblockClone.getPlugin().getDataFolder(), "mobvalues.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return config;
    }

    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {

        }
    }

    public static void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}
