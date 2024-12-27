package me.mrpants98.skyblockclone.Commands;

import me.mrpants98.skyblockclone.Holograms.TextComponents;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCritDamage implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        int damageValue = Integer.valueOf(strings[0]);

        Component damageTitle = TextComponents.getCritDamageTitle(damageValue);
        commandSender.sendMessage(damageTitle);

        return true;
    }
}
