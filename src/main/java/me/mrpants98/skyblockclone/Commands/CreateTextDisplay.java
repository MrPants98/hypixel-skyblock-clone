package me.mrpants98.skyblockclone.Commands;

import me.mrpants98.skyblockclone.Holograms.MobTitle;
import me.mrpants98.skyblockclone.SkyblockClone;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CreateTextDisplay implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(commandSender instanceof Player p))
            return false;

        int entityLevel = Integer.parseInt(args[0]);
        int entityHealth = Integer.parseInt(args[1]);
        int entityMaxHealth = Integer.parseInt(args[2]);
        String entityName;
        if (args.length <= 3)
            entityName = "Graveyard Zombie";
        else {
            String[] nameArr = Arrays.copyOfRange(args, 3, args.length);
            p.sendMessage(Arrays.toString(args));
            p.sendMessage(Arrays.toString(nameArr));
            entityName = String.join(" ", nameArr);
        }

        MobTitle title = new MobTitle(SkyblockClone.getPlugin(), entityLevel, entityHealth, entityMaxHealth, entityName, p);
        title.runTaskTimer(SkyblockClone.getPlugin(), 0, 1);

        return true;
    }
}
