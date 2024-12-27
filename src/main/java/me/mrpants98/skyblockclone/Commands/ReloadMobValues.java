package me.mrpants98.skyblockclone.Commands;

import me.mrpants98.skyblockclone.Configs.MobValues;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadMobValues implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        MobValues.reload();
        commandSender.sendMessage("The mob values have been reloaded!");

        return true;
    }
}
