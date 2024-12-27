package me.mrpants98.skyblockclone.Holograms;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

import java.awt.*;
import java.util.*;

import static net.kyori.adventure.text.Component.*;
import static net.kyori.adventure.text.format.NamedTextColor.*;

public class TextComponents {

    public static Component getMobTitle(int mobLvl, int mobHealth, int mobMaxHealth, String mobName) {
        Component displayText = text()
                .content("[").color(DARK_GRAY)
                .append(text("Lv" + mobLvl, GRAY),
                        text("]", DARK_GRAY),
                        text(" " + mobName + " ", RED),
                        text(mobHealth, GREEN),
                        text("/", WHITE),
                        text(mobMaxHealth, GREEN),
                        text("\u2665", RED))
                .build();

        return displayText;
    }

    public static Component getCritDamageTitle(int damage) {

        String damageStr = String.format("%,d", damage);

        NamedTextColor[] colors = { WHITE, WHITE, YELLOW, GOLD, RED, RED };
        int index = 0;

        ComponentBuilder textBuilder = text().content("\u2727").color(colors[index]);

        for (int i = 0; i < damageStr.length(); i++) {
            char c = damageStr.charAt(i);
            index = (index + 1) % colors.length;

            textBuilder.append(text(c, colors[index]));
        }

        index = (index + 1) % colors.length;
        textBuilder.append(text("\u2727", colors[index]));

        return textBuilder.build();
    }

    public static Component getDamageTitle(int damage) {

        String damageStr = String.format("%,d", damage);

        Component text = text()
                .content(damageStr).color(GRAY)
                .build();

        return text;
    }

}
